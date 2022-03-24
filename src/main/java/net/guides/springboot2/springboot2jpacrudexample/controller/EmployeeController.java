package net.guides.springboot2.springboot2jpacrudexample.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
		

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;

@RestController @CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class EmployeeController {
	
	 private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);
	 
	 @Autowired
	    private EmployeeRepository employeeRepository;

	    @GetMapping("/employees")
	    public List<Employee> getAllEmployees() {
	    	
	    	List<Employee> employees = employeeRepository.findAll();
	    	
	    	LOGGER.info("From Log4j EmployeeController getAllEmployees() response{}", employees); 	
	    	
	        return employees;
	    }

	    @GetMapping("/employees/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
	        throws ResourceNotFoundException {
	        Employee employee = employeeRepository.findById(employeeId)
	          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
	        return ResponseEntity.ok().body(employee);
	    }
	    
	    @PostMapping("/employees")
	    public List<Employee> createEmployee(@Valid @RequestBody List<Employee> employee) {
	    	try {
	    	LOGGER.info("From Log4j EmployeeController createEmployee() inputs{}", employee);
	    	
	    	List<Employee> eList = employeeRepository.saveAll(employee);
	    	
	    	LOGGER.info("From Log4j EmployeeController createEmployee() response{}", employee);
	    	}
	    	catch (Exception e)
	    	{
	    		LOGGER.error("Log4j error", e);
	    	}
	    	return employee;
	    }

	    @PutMapping("/employees/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
	         @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
	        Employee employee = employeeRepository.findById(employeeId)
	        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

	        employee.setEmailId(employeeDetails.getEmailId());
	        employee.setLastName(employeeDetails.getLastName());
	        employee.setFirstName(employeeDetails.getFirstName());
	        final Employee updatedEmployee = employeeRepository.save(employee);
	        return ResponseEntity.ok(updatedEmployee);
	    }

	    @DeleteMapping("/employees/{id}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
	         throws ResourceNotFoundException {
	        Employee employee = employeeRepository.findById(employeeId)
	       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

	        employeeRepository.delete(employee);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
