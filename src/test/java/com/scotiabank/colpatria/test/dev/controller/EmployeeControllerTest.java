package com.scotiabank.colpatria.test.dev.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scotiabank.colpatria.test.dev.data.MockData;
import com.scotiabank.colpatria.test.dev.entiti.Employee;

import com.scotiabank.colpatria.test.dev.service.EmployeedService;


@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

    ObjectMapper maper;
    
    @Autowired
	private MockMvc mvc;
    
    @MockitoBean
    private EmployeedService service;
    
	@BeforeEach
	void setUp() {
		maper = new ObjectMapper();
	}
	
	@Test
	void testListEmployees() throws Exception {
		
		when(service.findAll()).thenReturn(MockData.listEmployee());
		
		mvc.perform(
					MockMvcRequestBuilders.get("/")
					.contentType(MediaType.APPLICATION_JSON)			
				)
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].id").value(1L))
		.andExpect(jsonPath("$[0].firstName").value("pablo"))
		.andExpect(jsonPath("$", Matchers.hasSize(1)))
		;
		verify(service).findAll();
	}

	@Test
	void testDetailEmployee() throws Exception {
		when(service.findById(anyLong())).thenReturn(Optional.of(MockData.employeeNum1()));
		mvc.perform(
				MockMvcRequestBuilders.get("/datail/1")
				.contentType(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1L))
		.andExpect(jsonPath("$.firstName").value("pablo"))
		;
		verify(service).findById(1L);
	}

	@Test
	void testSaveEmployee() throws Exception {
		when(service.save(any())).thenReturn(MockData.employeeNum1());
		//System.out.print(maper.writeValueAsString(MockData.employeeNum1()));
		mvc.perform(		
				MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(maper.writeValueAsString(MockData.employeeNum1()))
				)
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1L))
		;
		verify(service).save(any());
	}

	@Test
	void testUpdateEmpleoye() throws Exception {
		when(service.findById(anyLong())).thenReturn(Optional.of(MockData.employeeNum1()));
		when(service.save(any())).thenReturn(MockData.employeeNum1());
		System.out.print(maper.writeValueAsString(MockData.employeeNum1()));
		mvc.perform(		
				MockMvcRequestBuilders.put("/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(maper.writeValueAsString(MockData.employeeNum1()))
				)
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").value(1L))
		;
		verify(service).findById(anyLong());
		verify(service).save(any());
	}

	@Test
	@DisplayName("test validation fields empty or null")
	void testValidEmpty()  throws Exception{
		mvc.perform(		
				MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(maper.writeValueAsString(new Employee()))
				)
		.andExpect(status().isBadRequest())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.salary").value("The field salary Invalid amount"))
		.andExpect(jsonPath("$.state").value("The field state must not be null"))
		.andExpect(jsonPath("$.dateArrival").value("The field dateArrival must not be null"))
		.andExpect(jsonPath("$.locationCity").value("The field locationCity must not be null"))
		;
		
	}
	@Test
	@DisplayName("test validation hireDate")
	void testValidHireDate()  throws Exception{
		mvc.perform(		
				MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(maper.writeValueAsString(MockData.employeeNum2()))
				)
		.andExpect(status().isBadRequest())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.hireDate").value("The field hireDate date is not valid"))
		;
		
	}
	@Test
	@DisplayName("test validation hireDate")
	void testValidDate()  throws Exception{
		mvc.perform(		
				MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(maper.writeValueAsString(MockData.employeeNum3()))
				)
		.andExpect(status().isBadRequest())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.dateBirth").value("The field dateBirth Invalid value"))
		;
		
	}

	@Test
	@DisplayName("test validation address length")
	void testValidAddressLength()  throws Exception{
		mvc.perform(		
				MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(maper.writeValueAsString(MockData.employeeNum5()))
				)
		.andExpect(status().isBadRequest())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.address").value("The field address It must have a length between 6 and a maximum of 100"))
		;
		
	}
	@Test
	@DisplayName("test validation address pattern")
	void testValidAddressPattern()  throws Exception{
		mvc.perform(		
				MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(maper.writeValueAsString(MockData.employeeNum6()))
				)
		.andExpect(status().isBadRequest())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.address").value("The field address not comply with the format"))
		;
		
	}
}
