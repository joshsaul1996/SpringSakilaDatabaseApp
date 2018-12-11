package qa.saul.josh.spring.database.SpringDatabaseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SpringDatabaseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseAppApplication.class, args);
	}
}
