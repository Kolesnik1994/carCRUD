package cars.com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Main class, that starting application
 * @author VLadislav K
 */


@EntityScan ("cars.com.model")
@SpringBootApplication
public class AddCarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddCarsApplication.class, args);
	}

}
