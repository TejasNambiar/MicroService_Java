package com.microservice.Station;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.Station.Model.StationModel;

@Service
public class ServiceImplementation {

	@Autowired
	ServiceRepository serviceRepository;

	public List<StationModel> getAll() {
		return serviceRepository.findAll();
	}

	public StationModel addStation(StationModel station) {
		return serviceRepository.insert(station);
	}

	public StationModel updateStation(StationModel station) {
		return serviceRepository.save(station);
	}

	public void deleteStation(String id) {
		serviceRepository.deleteById(id);
	}

	public Object getStationId(String id) {
		return serviceRepository.findById(id);
	}

	public Optional<StationModel> findStation(String name) {
		return serviceRepository.findOne(null);
	}
}
