package cars.com.addCars;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import cars.com.model.Car;
import cars.com.repository.CarRepository;
import cars.com.service.impl.CarServiceImpl;


/**
 *  Test class for Service Layer -> path "/src/main/java/cars/com/service/CarService.java"
 *  @author VLadislav K
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestServiceImplCar {

	@InjectMocks
	private CarServiceImpl carService;
	
	@Mock
	private CarRepository carrepo;
	
	//@Mock
	//private Car car;
	
	@Test
	void testGetAllCars () {
		carService.getAllCars();
		verify(carrepo).findAll();
	}
	
	// Set up car entity, execute service layer, assert our expected and actual value
	@Test
	void testSaveCar() {
		Car car = new Car();
		car.setMark("Mers");
		car.setModel("ll");
		car.setYear("222");
        carService.saveCar(car);

        Assertions.assertNotNull(car, "Object not null");
        Assertions.assertEquals ("Mers", car.getMark());
        Assertions.assertEquals ("ll", car.getModel());
        Assertions.assertEquals ("222", car.getYear());
	}
	
	/** set up car entity, execute method, 
	 * assert that expected id value and actual equal
	 */
	@Test
	void getCarById() {

		Car car = new Car();
		car.setId(1L);
	
		when(carrepo.findById(1l)).thenReturn(Optional.of(car));
		
		Car actualCar = carService.getCarById(1L);
		Assertions.assertEquals (car, actualCar);
		
	}
	
	/**
	 * Set up car entity, execute service method and verifies that repository save entity
	 */
	@Test
	void testUpdateCarById () {
		Car car = new Car();
		car.setId(1L);
		carService.updateCar(car);
		verify(carrepo).save(car);
	
	}
	
	@Test
	void testRemoveCarById() {
		carService.deleteById(1L);
		verify(carrepo).deleteById(1L);
	}
}
