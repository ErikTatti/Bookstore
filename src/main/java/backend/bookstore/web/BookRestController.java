package backend.bookstore.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;
import backend.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class BookRestController {

    private static final Logger log = LoggerFactory.getLogger(BookRestController.class);

    private final BookRepository repository;
    private final CategoryRepository cRepository;

    public BookRestController(BookRepository repository, CategoryRepository cRepository) {
        this.repository = repository;
        this.cRepository = cRepository;
    }

    @GetMapping("/books")
    public Iterable<Book> getbooks() {
        log.info("//fetch and return books");
        return repository.findAll();
    }    

    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        log.info("save new book" + newBook);
        return repository.save(newBook);
    }

    @PutMapping("/books/{id}")
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
        log.info("edit book" + editedBook);
        editedBook.setId(id);
        return repository.save(editedBook);
    }

    @DeleteMapping("/books/{id}")
    public Iterable<Book> deleteBook(@PathVariable Long id) {
        log.info("delete book, id = " + id);
        repository.deleteById(id);
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    Optional<Book> getBook(@PathVariable Long id) {
        log.info("find book, id = " + id);
        return repository.findById(id);
    }

}
