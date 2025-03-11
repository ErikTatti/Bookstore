package backend.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "publication_year", nullable = false)
    private int publicationYear;
    @Column(name = "isbn", nullable = false)
    private String isbn;
    @Column(name = "price", nullable = false)
    private double price;

    @NotNull(message = "Category cannot be empty.")

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book() {
        super();

    }

    public Book(String title, String author, int publicationYear, String isbn, double price, Category category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null)
            return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                    + ", isbn=" + isbn + ", price=" + price + ", category=" + this.getCategory() + "]";
        else

            return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                    + ", isbn=" + isbn + ", price=" + price + "]";
    }

}
