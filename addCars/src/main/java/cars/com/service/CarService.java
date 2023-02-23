package cars.com.service;

import java.util.List;

import cars.com.model.Car;

/**
 * Service interface
 * @author VLadislav K
 */
public interface CarService {
	List <Car> getAllCars();
	
	Car saveCar (Car car);
	
	Car getCarById(Long id);
	
	Car updateCar (Car car);
	
	void deleteById (Long id);
	

}
