package com.microservice.CustomerService;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservice.CustomerService.models.ServiceModel;

@SpringBootTest
class CustomerServiceApplicationTests {

	@Mock
	@Autowired
	ServiceRepository repository2;

	@Autowired
	ServiceRepository repository;

	ServiceModel model;

	@Autowired
	ServiceImplementation service;

	@BeforeEach
	void init() {
		MockitoAnnotations.initMocks(this);
		System.out.println("Intitializing test cases");
		System.out.println("output: " + repository.findAll());

	}

	@Test
	void contextLoads() {

		assertTrue(true);
		System.out.println("Intitializing test cases");
		System.out.println("output: " + repository.findAll());
	}

	@Test
	void getAll() {
		String result = "[ServiceModel [id=61793438a5657d7f1bbccb76, userName=chiku, serviceName=general, serviceRequest=thisis the first request, serviceResponse=null], ServiceModel [id=61793451a5657d7f1bbccb77, userName=walts, serviceName=general, serviceRequest=better be good, serviceResponse=null], ServiceModel [id=61793477a5657d7f1bbccb78, userName=nullifying, serviceName=general, serviceRequest=better be good, serviceResponse=null], ServiceModel [id=617934f6e45018324d48fdc4, userName=damning, serviceName=general, serviceRequest=better request, serviceResponse=null], ServiceModel [id=617958f351e63c2180654100, userName=well wats holding you back, serviceName=Station, serviceRequest=hello Soldier, serviceResponse=null]]";
		System.out.println("output: " + repository.findAll().toString());

		assertEquals(result, repository.findAll().toString());
	}

	@Test
	void getId() {
		String id = "61793438a5657d7f1bbccb76";
		model = repository.findById(id).get();
//		String resultString = "Optional[ServiceModel [id=61793438a5657d7f1bbccb76, userName=chiku, serviceName=general, serviceRequest=thisis the first request, serviceResponse=null]]";
		assertAll(() -> assertEquals("chiku", model.getUserName(), "returns and tests userName"),
				() -> assertEquals("general", model.getServiceName(), "returns and tests serviceName"),
				() -> assertEquals("thisis the first request", model.getServiceRequest(),
						"returns and tests serviceRequest"),
				() -> assertEquals(null, model.getServiceResponse(), "returns and tests serviceResponse"));
	}

	@Test
	void getIdMock() {
		String id = "617f91fd86e2bf5c93b651f4";
		Optional<ServiceModel> optional = repository2.findById(id);
		when(service.getOrderId(id)).thenReturn(optional);
		model = (ServiceModel) ((Optional<ServiceModel>) service.getOrderId(id)).get();
		assertEquals("testing123", model.getUserName(), "checks for inserted data name");

	}

	@Test
	void getIdPostSaveMock() {
		model = new ServiceModel("testing123", "testing mockito save");
		ServiceModel optional = repository2.save(model);
		when(service.addServiceQuery(model)).thenReturn(optional);
		assertEquals("testing123", repository2.save(model).getServiceName(), "checks for inserted data name");

	}

}
