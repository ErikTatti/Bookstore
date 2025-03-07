package backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import backend.bookstore.entity.Book;
import backend.bookstore.entity.Category;
import backend.bookstore.repository.BookRepository;
import backend.bookstore.repository.CategoryRepository;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findByBookName() {
        List<Book> books = bookRepository.findByBookName("The Great Gatsby");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getBookName()).isEqualTo("The Great Gatsby");
    }

    @Test
    public void createNewBook() {
        Category category = new Category("Fiction");
        categoryRepository.save(category);
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, category);
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteNewBook() {
        List<Book> books = bookRepository.findByBookName("The Great Gatsby");
        Book book = books.get(0);
        bookRepository.delete(book);
        List<Book> newBooks = bookRepository.findByBookName("The Great Gatsby");
        assertThat(newBooks).hasSize(0);
}
}