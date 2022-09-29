package cars.com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cars.com.model.Car;
import cars.com.repository.CarRepository;
import cars.com.service.CarService;

/**
 *  Service class that implements CarServcice methods 
 * @author VLadislav K
 */
@Service
public class CarServiceImpl implements CarService{

	private CarRepository carrepo;
	public CarServiceImpl(CarRepository carrepo) {
		this.carrepo = carrepo;
	}

	@Override
	public List<Car> getAllCars() {
		return carrepo.findAll();
	}

	@Override
	public Car saveCar(Car car) {
		return carrepo.save(car);
	}

	@Override
	public Car getCarById(Long id) {
		
		return carrepo.findById(id).get();
	}

	@Override
	public Car updateCar(Car car) {
	
		return carrepo.save(car);
	}

	@Override
	public void deleteById(Long id) {
		carrepo.deleteById(id);
		
	}

}
