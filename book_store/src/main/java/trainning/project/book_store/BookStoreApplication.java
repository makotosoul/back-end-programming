package trainning.project.book_store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import trainning.project.book_store.domain.AppUser;
import trainning.project.book_store.domain.AppUserRepository;
import trainning.project.book_store.domain.Book;
import trainning.project.book_store.domain.BookRepository;
import trainning.project.book_store.domain.Category;
import trainning.project.book_store.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
    @Bean
    public CommandLineRunner demo(BookRepository repository, CategoryRepository Crepository, AppUserRepository Urepository) {
        return (args) -> {
            //Categories
            Category Cat1 = new Category("Fantasy");
            Category Cat2 = new Category("Science");
            Category Cat3 = new Category("Romance");
            Crepository.save(Cat1);
            Crepository.save(Cat2);
            Crepository.save(Cat3);
 
            //book data
            Book book1 = new Book("Book1", "author1", 2024, "1sa123", 12.2,Cat1);
            Book book2 = new Book("Book2", "author2", 2023, "1sasda", 12.1,Cat2);
            repository.save(book1);
            repository.save(book2);



            //new users: admin/admin user/user
            AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			Urepository.save(user1);
			Urepository.save(user2);
            
        };
    }

}

