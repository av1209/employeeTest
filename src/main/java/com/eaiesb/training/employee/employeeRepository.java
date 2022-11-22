package com.eaiesb.training.employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.eaiesb.training.employee.*;

public interface employeeRepository extends MongoRepository<employee, String>{
	employee findByEmployeeId(String employeeId);

	

	

}

