package com.scotiabank.colpatria.test.dev.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.scotiabank.colpatria.test.dev.entiti.City;
import com.scotiabank.colpatria.test.dev.entiti.Employee;
import com.scotiabank.colpatria.test.dev.entiti.State;

public class MockData {

	public static Employee employeeNum1(){
		State state = new State(1L, "activo");
		City city = new City(1L, "Bogota");
		return new Employee(1L,"pablo","ferandes","vazques",city,"carr 123 siempre viva", new Date(949381200000L),"3201525521","Desarrollador", new Date(new Date().getTime() +999999) ,"pablito123@gmail.com",55555,state, new Date());
	}
	public static Employee employeeNum2(){
		State state = new State(1L, "activo");
		City city = new City(1L, "Bogota");
		return new Employee(1L,"pablo","ferandes","vazques",city,"carr 123 siempre viva", new Date(949381200000L),"3201525521","Desarrollador", new Date() ,"pablito123@gmail.com",55555,state, new Date());
	}
	public static Employee employeeNum3(){
		State state = new State(1L, "activo");
		City city = new City(1L, "Bogota");
		return new Employee(1L,"pablo","ferandes","vazques",city,"carr 123 siempre viva", new Date(),"3201525521","Desarrollador", new Date(new Date().getTime() +999999) ,"pablito123@gmail.com",55555,state, new Date());
	}
	public static Employee employeeNum4(){
		State state = new State(1L, "activo");
		City city = new City(2L, "Rio de Plata");
		return new Employee(1L,"pablo","ferandes","vazques",city,"carr 123 siempre viva", new Date(949381200000L),"3201525521","Desarrollador", new Date(new Date().getTime() +999999) ,"pablito123@gmail.com",55555,state, new Date());
	}
	public static List<Employee> listEmployee(){
		List<Employee> list = new ArrayList<>();
		list.add(employeeNum1());
		return list;
	}
}
