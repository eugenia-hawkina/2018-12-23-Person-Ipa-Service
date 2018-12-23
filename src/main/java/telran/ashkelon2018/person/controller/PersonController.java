package telran.ashkelon2018.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import telran.ashkelon2018.person.domain.Address;
import telran.ashkelon2018.person.domain.Person;
import telran.ashkelon2018.person.dto.ChildDto;
import telran.ashkelon2018.person.dto.CityPopulationDto;
import telran.ashkelon2018.person.service.PersonService;


@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@PostMapping
	public boolean addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}
	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable int id) {
		return personService.getPerson(id);
	}
	
	@DeleteMapping("/{id}")
	public Person removePerson(@PathVariable int id){
		return personService.removePerson(id);
	}
	
	@PutMapping("/{id}")
	public Person updateAddress(@PathVariable int id, @RequestBody @NonNull Address address) {
		return personService.updateAddress(id, address);
	}
	
	@GetMapping("/age/{minAge}/{maxAge}")
	public Iterable<Person> getPersonsByAge(@PathVariable int minAge, @PathVariable int maxAge){
		return personService.getPersonsByAge(minAge, maxAge);
	}
	
	@GetMapping("/city/{city}")
	public Iterable<Person> getPersonsByCity(@PathVariable String city){
		return personService.getPersonsByCity(city);
	}

	@GetMapping("/salary/{minSalary}/{maxSalary}")
	public Iterable<Person> getEmployeesBySalary(@PathVariable int minSalary, 
			@PathVariable int maxSalary){
		return personService.getEmployeesBySalary(minSalary, maxSalary);
	}
	
	@GetMapping("/children")
	public Iterable<ChildDto> findAllChildren() {
		return personService.findAllChildren();
	}
	
	@GetMapping("/employees/{company}")
	public Iterable<Person> findAllEmployeesByCompany(@PathVariable String company) {
		return personService.findAllEmployeesByCompany(company);
	}
	
	@GetMapping("/cities/population")
	public Iterable<CityPopulationDto> getPopulation() {
		return personService.getPopulation();
	}

}
