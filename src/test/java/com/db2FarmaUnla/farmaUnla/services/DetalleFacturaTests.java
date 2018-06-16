package com.db2FarmaUnla.farmaUnla.services;

import com.bd2FarmaUNLa.farmaUNLa.FarmaUnLaApplication;
import com.bd2FarmaUNLa.farmaUNLa.model.DetalleFactura;
import com.bd2FarmaUNLa.farmaUNLa.service.*;
import com.bd2FarmaUNLa.farmaUNLa.service.imp.DetalleFacturaServiceImplementation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FarmaUnLaApplication.class})

@DataJpaTest
public class DetalleFacturaTests {

	@Test
	public void contextLoads() {
		
	}
}
