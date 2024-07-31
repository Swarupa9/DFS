package com.cg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.EmpMap;
import com.cg.BO.EmpBO;
import com.cg.DAO.EmpDAO;
import com.cg.EO.EmpEO;

@Service
public class EmpServiceImpl implements EmpService{
	
	private static final Logger logger = LoggerFactory.getLogger(EmpServiceImpl.class);

	private final EmpMap employeeMap;

    @Autowired
    public EmpServiceImpl(EmpMap empMap) {
        this.employeeMap = empMap;
    }
	
	@Autowired
	private EmpDAO empDAO;
	/*
	@Autowired    
	private EmpMap employeeMap;
	*/
	@Override
	public List<EmpBO> getAllEmployees() {
		logger.debug("Fetching all employees");
		
		return empDAO.findAll().stream()
				.map(employeeMap::employee_BO)
                .collect(Collectors.toList());
	}

	@Override
	public EmpBO getEmployeeById(Long id) {
		logger.debug("Fetching employee by id: {}", id);
		return empDAO.findById(id)
                .map(employeeMap::employee_BO)
                .orElse(null);
	}

	@Override
	public EmpBO createEmployee(EmpBO empBO) {
		logger.debug("Creating employee: {}", empBO);
		EmpEO  empEO = employeeMap.employee_EO(empBO);
		EmpEO EO = empDAO.save(empEO);
		return employeeMap.employee_BO(EO);
	}

}
