package com.microservice.Station.Model;

public class StationModel {

	private String id;
	private String stationName;
	private String stationCode;

	public StationModel() {
	}

	public StationModel(String id, String stationName, String stationCode) {
		this.id = id;
		this.stationName = stationName;
		this.stationCode = stationCode;
	}

	public String getId() {
		return id;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

}
