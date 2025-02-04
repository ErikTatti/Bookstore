package backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(BookRepository repository) {
		return (args) -> {

			log.info("Save a couple of books");
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1234-5678", 12.99));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "1234-5679", 9.99));
			repository.save(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "1234-5680", 10.99));
			repository.save(new Book("1984", "George Orwell", 1949, "1234-5681", 11.99));
			repository.save(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "1234-5682", 13.99));

			log.info("tulostetaan kirjat");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
