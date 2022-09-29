package cars.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simple POJO class, that represent main entity "Car"
 * @author VLadislav K
 */
@Entity
@Table (name = "Cars")
public class Car {
	
	@Id
	@GeneratedValue (strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column (name ="vehicle_mark", nullable=false)
	private String mark;
	@Column (name ="vehicle_model", nullable = false)
	private String model;
	@Column (name ="vehicle_year", nullable = false)
	private String year;

	
	public Car () {}
	
	public Car(String mark, String model, String year) {
		this.mark = mark;
		this.model = model;
		this.year = year;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	
	

}
