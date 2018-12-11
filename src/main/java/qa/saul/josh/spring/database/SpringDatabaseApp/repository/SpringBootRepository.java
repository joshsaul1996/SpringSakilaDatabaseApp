package qa.saul.josh.spring.database.SpringDatabaseApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qa.saul.josh.spring.database.SpringDatabaseApp.model.SpringBootDataModel;


@Repository
public interface SpringBootRepository extends JpaRepository<SpringBootDataModel, Long>{

}
