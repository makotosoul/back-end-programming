package backend.thiennguyen.bookmark.domain;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface WebsiteRepository extends CrudRepository<Website, Long>{
    List<Website> findByProjectId(Long projectId);

}
