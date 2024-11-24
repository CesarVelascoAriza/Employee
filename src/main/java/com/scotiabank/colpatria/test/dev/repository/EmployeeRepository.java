package com.scotiabank.colpatria.test.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scotiabank.colpatria.test.dev.entiti.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
