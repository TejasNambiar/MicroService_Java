package com.microservice.CustomerService.models;

public class ServiceModel {

	private String id;
	private String userName;
	private String serviceName;
	private String serviceRequest;
	private String serviceResponse;

	public ServiceModel() {
	}

	public ServiceModel(String userName, String serviceRequest) {
		this.userName = userName;
		this.serviceRequest = serviceRequest;
		this.serviceName = "general";
	}

	public ServiceModel(String userName, String serviceName, String serviceRequest) {
		this.userName = userName;
		this.serviceRequest = serviceRequest;
		this.serviceName = serviceName;
	}

	public ServiceModel(String id, String userName, String serviceName, String serviceRequest) {
		this.id = id;
		this.userName = userName;
		this.serviceName = serviceName;
		this.serviceRequest = serviceRequest;
		this.serviceResponse = serviceResponse;
	}

	public String getUserName() {
		return userName;
	}

	public String getServiceRequest() {
		return serviceRequest;
	}

	public String getServiceResponse() {
		return serviceResponse;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setServiceRequest(String serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public void setServiceResponse(String serviceResponse) {
		this.serviceResponse = serviceResponse;
	}

	@Override
	public String toString() {
		return "ServiceModel [id=" + id + ", userName=" + userName + ", serviceName=" + serviceName
				+ ", serviceRequest=" + serviceRequest + ", serviceResponse=" + serviceResponse + "]";
	}

}
