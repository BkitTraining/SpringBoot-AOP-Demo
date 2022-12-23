package com.example.spring.aop.demo.service;

import com.example.spring.aop.demo.exception.ResourceNotFoundException;
import com.example.spring.aop.demo.model.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
  List<EmployeeEntity> getAllEmployees();

  EmployeeEntity getEmployeeById(Long employeeId) throws ResourceNotFoundException;

  EmployeeEntity addEmployee(EmployeeEntity employeeEntity);

  EmployeeEntity updateEmployee(Long employeeId, EmployeeEntity employeeEntityDetails) throws ResourceNotFoundException;

  void deleteEmployee(Long employeeId) throws ResourceNotFoundException;
}
