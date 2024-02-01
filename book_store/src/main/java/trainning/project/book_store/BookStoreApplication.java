package trainning.project.book_store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import trainning.project.book_store.domain.Book;
import trainning.project.book_store.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	 @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return args -> {
            Book book1 = new Book("Book1", "author1", 2024, "1sa123", 12.2);
            Book book2 = new Book("Book2", "author2", 2023, "1sasda", 12.1);
            repository.save(book1);
            repository.save(book2);
        };
    }

}
