package backend.thiennguyen.bookmark;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.thiennguyen.bookmark.domain.AppUser;
import backend.thiennguyen.bookmark.domain.AppUserRepository;
import backend.thiennguyen.bookmark.domain.Category;
import backend.thiennguyen.bookmark.domain.CategoryRepository;
import backend.thiennguyen.bookmark.domain.Website;
import backend.thiennguyen.bookmark.domain.WebsiteRepository;

@SpringBootApplication
public class BookmarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmarkApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(WebsiteRepository repository, CategoryRepository Crepository, AppUserRepository Urepository){
		return (args) -> {
			//Categories
			Category Cat1 = new Category("School");
			Category Cat2 = new Category("Entertaiment");
			Crepository.save(Cat1);
			Crepository.save(Cat2);


			//website data
			Website web1 = new Website("github","https://github.com/","for uploading project!",Cat1);
			Website web2 = new Website("moodle","https://hhmoodle.haaga-helia.fi/my/index.php?lang=en","for submitting homework",Cat1);
			Website web3 = new Website("youtube","https://www.youtube.com/","for watching clips",Cat2);
			repository.save(web1);
			repository.save(web2);
			repository.save(web3);

			//new users: admin/admin user/user
            AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			Urepository.save(user1);
			Urepository.save(user2);

		};
	}

}
