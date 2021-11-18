package com.microservice.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.CustomerService.models.ServiceModel;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	ServiceImplementation serviceImplementation;

	@GetMapping("")
	public List<ServiceModel> getAll() {
		return serviceImplementation.getAll();
	}

	@PostMapping("")
	public ServiceModel addServiceQuery(@RequestBody ServiceModel query) {
		return serviceImplementation.addServiceQuery(query);
	}

	@PutMapping("/{id}")
	public ServiceModel updateServiceQuery(@PathVariable String id, @RequestBody ServiceModel query) {
		if (query.getId() != null)
			return serviceImplementation.updateQuery(query, id);
		return null;
	}

	@DeleteMapping("/{id}")
	public String deleteQuery(@PathVariable String id) {
		return serviceImplementation.delete(id);
	}

	@GetMapping("/{id}")
	public Object getQueryId(@PathVariable String id) {
		return serviceImplementation.getOrderId(id);
	}
}
