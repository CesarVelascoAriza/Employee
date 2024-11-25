package com.scotiabank.colpatria.test.dev.Implement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.scotiabank.colpatria.test.dev.entiti.City;
import com.scotiabank.colpatria.test.dev.entiti.Employee;
import com.scotiabank.colpatria.test.dev.entiti.State;
import com.scotiabank.colpatria.test.dev.repository.CityRepository;
import com.scotiabank.colpatria.test.dev.repository.EmployeeRepository;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class EmployeeServiceImplTest {

    @Autowired
    CityRepository cityRepository;
    @Autowired
    EmployeeRepository repository;


    @Test
    @DisplayName("test list dbFind All  Employee repository ")
    @Order(1)  
    void testListEmployeesRespository(){
        List<Employee> list = repository.findAll();
        assertTrue(list.isEmpty());
    }
    @Test
    @DisplayName("test save Employe repository ")
    @Order(2)
    void testSaveEmployeesRespository(){
        State state = new State(1L, "activo");
		City city = new City(1L, "Bogota");
        Employee employee = new Employee(null,"pablo","ferandes","vazques",city,"carr 123 siempre viva", new Date(949381200000L),"3201525521","Desarrollador", new Date(new Date().getTime() +999999) ,"pablito123@gmail.com",55555,state, new Date());
        Employee empSave = repository.save(employee) ;
        assertEquals("pablo", empSave.getFirstName());
        assertEquals(1L, empSave.getId());
    }
    @Test
    @DisplayName("test Update Employe repository ")
    @Order(3)
    void testUpdateEmployeesRespository(){
        State state = new State(1L, "activo");
		City city = new City(1L, "Bogota");
        Employee employee = new Employee(null,"pablo","ferandes","vazques",city,"Calle 123 # 32A 22", new Date(949381200000L),"3201525521","Desarrollador", new Date(new Date().getTime() +999999) ,"pablito13@gmail.com",90000,state, new Date());
        Employee empSave = repository.save(employee) ;
        employee.setAddress("Calle 123 # 33A 22");
        employee.setEmail("pablito13@yahoo.com");
        employee.setSalary(93000);
        Employee empUpdate = repository.save(empSave);
        assertEquals("Calle 123 # 33A 22", empUpdate.getAddress());
        assertEquals("pablito13@yahoo.com", empUpdate.getEmail());
        assertEquals(93000, empUpdate.getSalary());
    }
    @Test
    @DisplayName("test list dbFind All repository ")
    @Order(4)
    void testListEmployees(){
        List<City> list = cityRepository.findAll();
        assertFalse(list.isEmpty());
    }
}
