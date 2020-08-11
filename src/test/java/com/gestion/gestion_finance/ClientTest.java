package com.gestion.gestion_finance;

import com.dulcepan.Application;
import com.dulcepan.entity.Client;
import com.dulcepan.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.Assert.*;

@SpringBootTest(classes = Application.class)
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application.properties")
class ClientTest {

	@Autowired
	private ClientService clientService;

	@Test
	void createClient() {

		Client clientToInsert = Client.builder().nameClient("Gonzalo")
				.address("Dirección")
				.commune("Comuna")
				.nameMarket("Nombre Market")
				.phone("+56944674728")
				.rut("17852509-3")
				.build();
		Client client =clientService.createClient(clientToInsert);

		assertEquals(clientToInsert.getAddress(),client.getAddress());
		assertEquals(clientToInsert.getCommune(),client.getCommune());
		assertEquals(clientToInsert.getRut(),client.getRut());
		assertEquals(clientToInsert.getNameClient(),client.getNameClient());
		assertEquals(clientToInsert.getNameMarket(),client.getNameMarket());
		assertEquals(clientToInsert.getPhone(),client.getPhone());
	}

}
