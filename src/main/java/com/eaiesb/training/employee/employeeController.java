package com.eaiesb.training.employee;
import org.springframework.boot.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class employeeController {
	
	@Autowired
	private employeeRepository empRepo;
	
	@GetMapping("/getEmployees")
	public List <employee> getAllgetEmployees(){
	return empRepo.findAll();
	}
	
	@GetMapping("/getEmployee/{id}")
	public Optional <employee> getEmployeeById(@PathVariable String id){
	return empRepo.findById(id);
	}
	
	@PostMapping("/employee")
	public employee saveEmployee( @RequestBody employee emp) {
		return empRepo.save(emp);
	}
	
	@PutMapping("/employee/{id}")
	public employee update(@PathVariable String id,@Validated @RequestBody employee emp) {
		emp.setId(id);
		return empRepo.save(emp);
	}
	
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable String id) {
		 empRepo.deleteById(id);
	}
	
}

