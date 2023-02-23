package cars.com.addCars;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import cars.com.model.Car;
import cars.com.repository.CarRepository;
import cars.com.service.impl.CarServiceImpl;



/**
 * Test Controller Class -> cars/com/controller/CarController.java class
 * @author Vladislav Kolesnyk
 */

@AutoConfigureMockMvc
@SpringBootTest
public class TestController {
	
	@Autowired	
	private MockMvc mock;
	
	@Mock
	CarRepository carRepo;
	
	@Mock
	CarServiceImpl carService;
	
	/**set up list of cars entity, execute service method getAllCar and return list of cars, 
	 * assert that expected list and actual are deeply equal 
	 * 
	 * use  mockMvc to perform web request for slash ("/cars") and then i expected status 202 that everything okay
     *  get ModelandView in controller, and assert expected view name in controller and actual ("cars")
	 */
	@Test
	public void getCarHttpRequest () throws Exception {
		
		Car car1 = new Car ("Mersedes", "Amg", "2018");
		Car car2 = new Car ( "Volkswagen", "Polo", "2022");
		List <Car> cars = new ArrayList<> (Arrays.asList(car1, car2));
		
		when(carService.getAllCars()).thenReturn(cars);
		Assertions.assertIterableEquals(cars, carService.getAllCars());
		
		MvcResult mvcResult = mock.perform(MockMvcRequestBuilders.get("/cars")).andExpect(status().isOk()).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		ModelAndViewAssert.assertViewName(mav, "cars");
	
	}

	
	

}
