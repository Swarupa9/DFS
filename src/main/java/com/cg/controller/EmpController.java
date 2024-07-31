package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.BO.EmpBO;
import com.cg.service.EmpService;

@RestController
@RequestMapping("/emp")

public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);

	@Autowired
	private EmpService empService;
	
	@GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Backend call is successful");
    }
	
	@GetMapping
	public ResponseEntity<List<EmpBO>> getAgetAllEmployees(){
		logger.info("Fetching all employees");
		return ResponseEntity.ok(empService.getAllEmployees());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmpBO> getEmployeeById(@PathVariable("id") Long id){
		logger.info("Fetching employee with id: {}", id);
		return ResponseEntity.ok(empService.getEmployeeById(id));
	}
	
	@PostMapping
	public ResponseEntity<EmpBO> createEmployee(@RequestBody EmpBO empBO){
		logger.info("Creating new employee: {}", empBO);
		return ResponseEntity.ok(empService.createEmployee(empBO));
	}
	
}
