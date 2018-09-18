package spring.begining.spring_app.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.begining.spring_app.Customer;
import spring.begining.spring_app.entity.repository.CustomerRepository;

@Controller
@RequestMapping(path = "/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	public CustomerController(CustomerRepository customerRespository) {
		this.repository = customerRespository;
	}
	
	// mapeia o método 'GET' para trazer uma lista de customers, não possui um path, pois a intenção
	//é trazer todos os dados da tabela
	@GetMapping
	@ResponseBody
	public List<Customer> findAll() {

		return (List<Customer>) repository.findAll();

	}
	// mapeia o método 'GET' para trazer um customer específico através do 'name'
	
	@GetMapping(path = "/name/{name}")
	@ResponseBody
	public Customer findByName(@PathVariable String name) {
		return repository.findByName(name);

	}

	// mapeia o método 'GET' para trazer um customer específico através no 'id'
	@GetMapping(path = "/{id}")
	@ResponseBody
	public Customer findOne(@PathVariable Long id) {
		return repository.findOne(id);

	}

	//mapeia o método 'POST' trazendo consigo os 'names' e 'ages' para lista-los
	@PostMapping
	@ResponseBody
	public Customer create(@RequestParam String name, @RequestParam Integer age) {

		Customer customer = new Customer(name, age);
		if (name != null && name.length() > 0 && age != null && age > 0) {
			repository.save(customer);

		}
		return customer;
	}
	
	// Mapeia o método 'DELETE' pelo parametro 'id' para saber quais dados deverá deletar
	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public void destroy(@PathVariable Long id) {
		Customer customer = repository.findOne(id);
		
		if(customer != null ) {
		repository.delete(customer);
		}
	}
	
	
}

