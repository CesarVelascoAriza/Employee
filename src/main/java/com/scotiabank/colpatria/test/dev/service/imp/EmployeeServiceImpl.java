package com.scotiabank.colpatria.test.dev.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scotiabank.colpatria.test.dev.entiti.Employee;
import com.scotiabank.colpatria.test.dev.repository.EmployeeRepository;
import com.scotiabank.colpatria.test.dev.service.EmployeedService;

@Service
public class EmployeeServiceImpl implements EmployeedService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Employee> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Employee> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public void deleteById(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
		}
	}

	
	

}
