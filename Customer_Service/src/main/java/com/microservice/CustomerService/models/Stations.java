package com.microservice.CustomerService.models;

public class Stations {

	private String stationName;
	private String stationCode;

	public Stations() {
	}

	public Stations(String stationName, String stationCode) {
		this.stationName = stationName;
		this.stationCode = stationCode;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	@Override
	public String toString() {
		return "Stations [stationName=" + stationName + ", stationCode=" + stationCode + "]";
	}

}
