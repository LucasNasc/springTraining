package spring.begining.spring_app.entity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import spring.begining.spring_app.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
		
	public Customer findByName(String name);
}
