package telran.ashkelon2018.person.service;

import telran.ashkelon2018.person.domain.Address;
import telran.ashkelon2018.person.domain.Person;
import telran.ashkelon2018.person.dto.ChildDto;
import telran.ashkelon2018.person.dto.CityPopulationDto;

public interface PersonService {
	
	boolean addPerson(Person person);
	
	Person getPerson(int id);
	
	Person removePerson(int id);
	
	Person updateAddress(int id, Address address);
	
	Iterable<Person> getPersonsByAge(int minAge, int maxAge);
	
	Iterable<Person> getPersonsByCity(String city);

	Iterable<Person> getEmployeesBySalary(int minSalary, int maxSalary);

	Iterable<ChildDto> findAllChildren();
	
	Iterable<Person> findAllEmployeesByCompany(String company);
	
	Iterable<CityPopulationDto> getPopulation();
}
