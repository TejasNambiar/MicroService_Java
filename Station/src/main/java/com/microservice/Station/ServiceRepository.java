package com.microservice.Station;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.Station.Model.StationModel;

@Repository
public interface ServiceRepository extends MongoRepository<StationModel, String> {
}
