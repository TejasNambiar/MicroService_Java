package com.microservice.CustomerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.CustomerService.models.ServiceModel;

class ServiceControllerTest {

	ServiceController controller;

	@Autowired
	ServiceModel model, model2;

	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		controller = mock(ServiceController.class);
		testReporter.publishEntry("Running " + testInfo.getDisplayName());
	}

	@Test
	@DisplayName("Testing updateServiceQuery")
	void testupdateService() {
		model = new ServiceModel("test", "general", "testing mockito save");
		model2 = new ServiceModel("testUpdated", "general", "testing mockito save");

		when(controller.updateServiceQuery("617f91cbee05332333c9cfac", model)).thenReturn(model2);
		assertEquals(model2, controller.updateServiceQuery("617f91cbee05332333c9cfac", model), "Testing addService");

	}

	@Test
	@DisplayName("Testing addService")
	void testAdd() {
		model = new ServiceModel("testing", "testing", "testing");

		when(controller.addServiceQuery(model)).thenReturn(model);
		assertEquals(model, controller.addServiceQuery(model), "Testing addService");
	}

	@Test
	@DisplayName("Testing deleteService")
	void testDelete() {

		when(controller.deleteQuery("61960133d77b30096e5186b2"))
				.thenReturn("Deleted Service with id: 61960133d77b30096e5186b2");
		assertEquals("Deleted Service with id: 61960133d77b30096e5186b2",
				controller.deleteQuery("61960133d77b30096e5186b2"), "Testing DeleteService");
	}

}
