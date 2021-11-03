package com.microservice.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.CustomerService.models.ServiceModel;

@Service
public class ServiceImplementation {

	@Autowired
	ServiceRepository serviceRepository;

	public List<ServiceModel> getAll() {
		return serviceRepository.findAll();
	}

	public ServiceModel addServiceQuery(ServiceModel query) {
		return serviceRepository.insert(query);
	}

	public ServiceModel updateQuery(ServiceModel query) {
		return serviceRepository.save(query);
	}

	public void delete(String id) {
		serviceRepository.deleteById(id);
	}

	public Object getOrderId(String id) {
		return serviceRepository.findById(id);
	}
}
