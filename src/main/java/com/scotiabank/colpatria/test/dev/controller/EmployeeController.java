package com.scotiabank.colpatria.test.dev.controller;

import org.springframework.web.bind.annotation.RestController;

import com.scotiabank.colpatria.test.dev.entiti.Employee;
import com.scotiabank.colpatria.test.dev.service.EmployeedService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeedService service;
	
	@GetMapping
	public ResponseEntity<?> listEmployees() {
		return ResponseEntity.ok(service.findAll()); 
	}
	@GetMapping("/datail/{id}")
	public ResponseEntity<?> detailEmployee(@PathVariable Long id) {
		Optional<Employee> emp = service.findById(id);
		if(!emp.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(emp.get());
	}
	@PostMapping
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee entity,BindingResult result) {
		if(!result.hasErrors() )
			return this.validar(result);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmpleoye(@PathVariable Long id, @Valid @RequestBody Employee entity,BindingResult result) {
		if(!result.hasErrors() )
			return this.validar(result);
		Optional<Employee> optiona = service.findById(id);
		if(!optiona.isPresent()) 
			return ResponseEntity.notFound().build();
		Employee empDb = optiona.get();
		empDb.setSalary(entity.getSalary());
		empDb.setAddress(entity.getAddress());
		empDb.setPositionTitle(entity.getPositionTitle());
		empDb.setEmail(entity.getEmail());
		empDb.setLocationCity(entity.getLocationCity());
		empDb.setState(entity.getState());
		empDb.setTelephone(entity.getTelephone());
		return ResponseEntity.ok(service.save(empDb));
	}
	
	protected ResponseEntity<?> validar(BindingResult result) {
		Map<String, Object> errores = new HashMap<>();
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), "el atributo " + err.getField() + " " + err.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}
	
}
