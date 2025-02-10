package backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;
import backend.bookstore.domain.CategoryRepository;

import org.springframework.ui.Model;

@Controller
public class BookController {

    private final BookRepository repository;
    private final CategoryRepository cRepository;

    // Constructor injection for both repositories
    public BookController(BookRepository repository, CategoryRepository cRepository) {
        this.repository = repository;
        this.cRepository = cRepository;
    }

    @GetMapping(value = { "/", "/booklist" })
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepository.findAll());
        return "addbook";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        repository.deleteById(bookId);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/edit/{id}")
    public String showEditBook(@PathVariable("id") Long bookId, Model model) {
        Book book = repository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + bookId));
        model.addAttribute("book", book);
        model.addAttribute("categories", cRepository.findAll()); 
        return "editbook";
    }

    @PostMapping("/updateBook")
    public String updateBook(@ModelAttribute Book book) {
        repository.save(book);
        return "redirect:/booklist";
    }
}
