package trainning.project.book_store.domain;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
