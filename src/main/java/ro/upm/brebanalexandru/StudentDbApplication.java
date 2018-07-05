package ro.upm.brebanalexandru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudentDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDbApplication.class, args);		
	}
}
