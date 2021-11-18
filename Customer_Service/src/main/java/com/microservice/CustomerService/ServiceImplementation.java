package com.microservice.CustomerService;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.CustomerService.models.ServiceModel;

@Service
public class ServiceImplementation {

	@Autowired
	ServiceRepository serviceRepository;

	ServiceModel updatedModel = new ServiceModel();

	public List<ServiceModel> getAll() {
		return serviceRepository.findAll();
	}

	public ServiceModel addServiceQuery(ServiceModel query) {
		return serviceRepository.insert(query);
	}

	public ServiceModel updateQuery(ServiceModel query, String id) {
		if (!serviceRepository.findById(id).isPresent())
			return null;

		updatedModel = serviceRepository.findById(id).get();

		if (Objects.nonNull(query.getServiceName()) && !"".equalsIgnoreCase(query.getServiceName()))
			updatedModel.setServiceName(query.getServiceName());

		if (Objects.nonNull(query.getServiceRequest()) && !"".equalsIgnoreCase(query.getServiceRequest()))
			updatedModel.setServiceRequest(query.getServiceRequest());

		if (Objects.nonNull(query.getServiceResponse()) && !"".equalsIgnoreCase(query.getServiceResponse()))
			updatedModel.setServiceResponse(query.getServiceResponse());

		return serviceRepository.save(updatedModel);
	}

	public String delete(String id) {
		serviceRepository.deleteById(id);
		return "Deleted Service with id: " + id;
	}

	public Object getOrderId(String id) {
		return serviceRepository.findById(id);
	}
}
