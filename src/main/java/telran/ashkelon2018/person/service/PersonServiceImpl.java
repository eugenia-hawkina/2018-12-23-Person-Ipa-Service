package telran.ashkelon2018.person.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2018.person.dao.PersonRepository;
import telran.ashkelon2018.person.domain.Address;
import telran.ashkelon2018.person.domain.Person;
import telran.ashkelon2018.person.dto.ChildDto;
import telran.ashkelon2018.person.dto.CityPopulationDto;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public boolean addPerson(Person person) {
		if(personRepository.existsById(person.getId())) {
			return false;
		}
		personRepository.save(person);
		return true;
	}

	@Override
	public Person getPerson(int id) {
		return personRepository.findById(id).orElse(null);
	}

	@Override
	public Person removePerson(int id) {
		Person person = personRepository.findById(id).orElse(null);
		if(person != null) {
			personRepository.deleteById(id);
			return person;
		}
		return null;
	}

	@Override
	@Transactional
	// updates object after method ends
	public Person updateAddress(int id, Address address) {
		Person person = personRepository.findById(id).orElse(null);
		if(person != null) {
			person.setAddress(address);
			// personRepository.save(person);
			// save() rewrites whole object
		}
		return person;
	}

	@Override
	public Iterable<Person> getPersonsByAge(int minAge, int maxAge) {
		LocalDate from = LocalDate.now().minusYears(maxAge);
		LocalDate to = LocalDate.now().minusYears(minAge);
		return personRepository.findByBirthDateBetween(from, to);
	}

	@Override
	public Iterable<Person> getPersonsByCity(String city) {
		return personRepository.findByAddressCity(city);
	}

	@Override
	public Iterable<Person> getEmployeesBySalary(int minSalary, int maxSalary) {
		return personRepository.findBySalaryBetween(minSalary, maxSalary);
	}
	
	@Override
	public Iterable<ChildDto> findAllChildren(){
		return personRepository.findAllChildren();
	}

	@Override
	public Iterable<Person> findAllEmployeesByCompany(String company) {
		return personRepository.findAllEmployeesByCompany(company);
	}

	@Override
	public Iterable<CityPopulationDto> getPopulation() {
		return personRepository.getPopulation();
	}
}
