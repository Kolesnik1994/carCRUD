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
public class AddCarsApplication /*implements CommandLineRunner*/ {

	public static void main(String[] args) {
		SpringApplication.run(AddCarsApplication.class, args);
	}

	//@Autowired
	//private CarRepository carrepo;
	
	//@Override
	//public void run(String... args) throws Exception {
		
	//	Car car1  = new Car ("Mers", "600", "2023");
	//	Car car2  = new Car ("Nissan", "SkyLine", "2023");
	//	Car car3  = new Car ("Audi", "q8", "2023");
		
	//	carrepo.save(car1);
	//	carrepo.save(car2);
	//	carrepo.save(car3);
		
		
	//}

}
