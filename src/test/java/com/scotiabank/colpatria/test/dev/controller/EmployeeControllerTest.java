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
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scotiabank.colpatria.test.dev.data.MockData;
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
	}

}
