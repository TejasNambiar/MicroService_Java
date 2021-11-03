package com.microservice.CustomerService;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.CustomerService.models.ServiceModel;

@Repository
public interface ServiceRepository extends MongoRepository<ServiceModel, String> {
}
