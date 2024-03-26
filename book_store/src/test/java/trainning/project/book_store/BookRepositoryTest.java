package trainning.project.book_store;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import trainning.project.book_store.domain.Book;
import trainning.project.book_store.domain.BookRepository;
import trainning.project.book_store.domain.Category;
import trainning.project.book_store.domain.CategoryRepository;

@SpringBootTest(classes = BookStoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {
    @Autowired
    private BookRepository bRepository;

    @Autowired
    private CategoryRepository cRepository;

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = bRepository.findByTitle("Book1");

        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("author1");
    }

    @Test
    public void createNewBook() {
        Category category = new Category("Thriller");
        cRepository.save(category);
        Book book = new Book("book3", "author3", 2022, "asdbvc", 11.1, category);
        bRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }
    @Test 
    public void deleteNewBook() {
        List<Book> books = bRepository.findByTitle("Book1");
        Book book = books.get(0);
        bRepository.delete(book);
        List<Book> newBooks = bRepository.findByTitle("Book1");
        assertThat(newBooks).hasSize(0);
    }
}
