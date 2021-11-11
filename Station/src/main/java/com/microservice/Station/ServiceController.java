package com.microservice.Station;

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

import com.microservice.Station.Model.StationModel;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/station")
public class ServiceController {

	@Autowired
	ServiceImplementation serviceImplementation;

	@GetMapping("")
	public List<StationModel> getAll() {
		return serviceImplementation.getAll();
	}

	@PostMapping("")
	public StationModel addStation(@RequestBody StationModel station) {
		return serviceImplementation.addStation(station);
	}

	@PutMapping("")
	public StationModel updateStation(@RequestBody StationModel station) {
		return serviceImplementation.updateStation(station);
	}

	@DeleteMapping("/{id}")
	public void deleteStation(@PathVariable String id) {
		serviceImplementation.deleteStation(id);
	}

	@GetMapping("/{id}")
	public Object getStationId(@PathVariable String id) {
		return serviceImplementation.getStationId(id);
	}

}
