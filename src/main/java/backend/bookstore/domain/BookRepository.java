package backend.bookstore.domain;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
        
    Optional<Book> findById(Long id);

    List<Book> findByBookName(String bookName);
}
