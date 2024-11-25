package com.scotiabank.colpatria.test.dev.service.imp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.scotiabank.colpatria.test.dev.repository.CityRepository;
import com.scotiabank.colpatria.test.dev.repository.EmployeeRepository;
@DataJpaTest
class EmployeeServiceImplTest {

	@Autowired
	private CityRepository cityrepository;
	@Autowired
	private EmployeeRepository employeerepository;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSave() {
		
	}

}
