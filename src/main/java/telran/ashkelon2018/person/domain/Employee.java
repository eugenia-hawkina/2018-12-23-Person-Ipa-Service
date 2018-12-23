package telran.ashkelon2018.person.domain;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Employee extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String company;
	int salary;
	public Employee(int id, String name, LocalDate birthDate, Address address, 
			String company, int salary) {
		super(id, name, birthDate, address);
		this.company = company;
		this.salary = salary;
	}	
}
