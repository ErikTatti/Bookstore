package backend.bookstore.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long categoryId;
    @Size(min = 3, max = 250)
    
    @Column(name = "name", nullable = false)
    private String name;

    @JsonIgnoreProperties("category")   

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL) 
    private List<Book> books;


    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
