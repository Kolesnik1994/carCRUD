package cars.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cars.com.model.Car;

/**
 * Repository interface that extends JpaRepository for main entity
 * @author VLadislav K
 */
@Repository
public interface CarRepository extends JpaRepository <Car, Long>  {
	

}
