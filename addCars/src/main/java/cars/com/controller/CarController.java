package cars.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cars.com.model.Car;
import cars.com.service.CarService;

/**
 * Controller class
 * @author VLadislav K
 */
@Controller

public class CarController {
	
	private CarService carserv;

	public CarController(CarService carserv) {
		this.carserv = carserv;
	}
	
	/* get all cars from service layer and displays them on the page cars.html */ 
	@GetMapping ("/cars") 
	public String listCar(Model model) {
		model.addAttribute("cars", carserv.getAllCars());
		return "cars";	
	}
	
	/* get new template for creating a new model */ 
	@GetMapping ("/cars/new")
	public String createCars (Model model) {
		Car car = new Car ();
		model.addAttribute("car", car);
		return "create_car";
}
	
	/* post new entity and redirect to main page  */
	@PostMapping ("/cars")
	public String saveCars(@ModelAttribute("car") Car car) {
		carserv.saveCar(car);
		return "redirect:/cars";
		
	}
	
	/* you can get car by id to edit model fields*/ 
	@GetMapping ("/cars/edit/{id}")
	public String editCar (@PathVariable Long id, Model model) {
		model.addAttribute("car", carserv.getCarById(id));
		return "edit_car";
		
	}
	
	/* post new model changes and redirect to main page */
	@PostMapping ("/cars/{id}")
	public String updateCar (@PathVariable Long id, @ModelAttribute ("car") Car car, Model model) {
		Car existcar = carserv.getCarById(id);
		existcar.setId(id);
		existcar.setMark(car.getMark());
		existcar.setModel(car.getModel());
		existcar.setYear(car.getYear());
		
		carserv.updateCar(existcar);
		return "redirect:/cars";
		
		
	}
	
	/* delete car by id and redirect to main page */
	@GetMapping("cars/{id}")
	public String deleteCar (@PathVariable Long id) {
		carserv.deleteById(id);
		return "redirect:/cars";
	}
	
}
