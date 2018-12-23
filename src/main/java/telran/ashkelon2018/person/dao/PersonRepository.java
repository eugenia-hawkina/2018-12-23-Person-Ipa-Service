package telran.ashkelon2018.person.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.ashkelon2018.person.domain.Person;
import telran.ashkelon2018.person.dto.ChildDto;
import telran.ashkelon2018.person.dto.CityPopulationDto;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	List<Person> findByBirthDateBetween(LocalDate fromDate, LocalDate toDate);
	
	List<Person> findByAddressCity(String city);
	
	@Query("select p from Person p where p.salary between ?1 and ?2")
	// btw 1st and 2nd arguments
	// (query in sql, nativeQuery=true)
	List<Person> findBySalaryBetween(int minSalary, int maxSalary);
	
	@Query("select new telran.ashkelon2018.person.dto.ChildDto(p.name, p.address.city, "
			+ "p.kindergarten) from Person p where p.kindergarten is not null")
	Iterable<ChildDto> findAllChildren();

	@Query("select p from Person p where p.company = ?1")
	Iterable<Person> findAllEmployeesByCompany(String company);

	@Query ("select new telran.ashkelon2018.person.dto.CityPopulationDto "
			+ "(p.address.city, count(p)) FROM Person p GROUP BY p.address.city"
			+ "order by count(p) asc")
	Iterable<CityPopulationDto> getPopulation();
}
