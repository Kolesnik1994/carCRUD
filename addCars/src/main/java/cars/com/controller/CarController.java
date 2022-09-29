package cars.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	/* Give templates "cars.html" by the address (localhost:8078/cars) */ 
	@GetMapping ("/cars") 
	public String listCar(Model model) {
		model.addAttribute("cars", carserv.getAllCars());
		return "cars";	
	}
	
	/* Give templates "create_car.html" by the address (localhost:8078/cars/new) */ 
	@GetMapping ("/cars/new")
	public String createCars (Model model) {
		Car car = new Car ();
		model.addAttribute("car", car);
		return "create_car";
}
	
	/* create car on the templates (create_car.html) and redirect to templates (cars.html) */
	@PostMapping ("/cars")
	public String saveCars(@ModelAttribute("car") Car car) {
		carserv.saveCar(car);
		return "redirect:/cars";
		
	}
	
	/* Give templates "edit_car.html" by the address (localhost:8078/cars/edit/{id}) */ 
	@GetMapping ("/cars/edit/{id}")
	public String editCar (@PathVariable Long id, Model model) {
		model.addAttribute("car", carserv.getCarById(id));
		return "edit_car";
		
	}
	
	/* update car on the templates (edit_car.html) by id and redirect to templates (cars.html) */
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
	
	/* delete car on the templates (cars.html) by id */
	@GetMapping("cars/{id}")
	public String deleteCar (@PathVariable Long id) {
		carserv.deleteById(id);
		return "redirect:/cars";
	}
	
}
