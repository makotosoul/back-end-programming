package trainning.project.book_store.domain;
import org.springframework.data.repository.CrudRepository;


import java.util.List;



public interface BookRepository extends CrudRepository<Book, String> {
    List<Book> findByAuthor(String author);;
}
