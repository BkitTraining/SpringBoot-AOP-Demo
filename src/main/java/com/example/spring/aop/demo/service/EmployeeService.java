package com.example.spring.aop.demo.service;

import com.example.spring.aop.demo.exception.ResourceNotFoundException;
import com.example.spring.aop.demo.model.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
  List<EmployeeEntity> getAllEmployees();

  Optional<EmployeeEntity> getEmployeeById(Long employeeId);

  EmployeeEntity addEmployee(EmployeeEntity employeeEntity);

  EmployeeEntity updateEmployee(Long employeeId, EmployeeEntity employeeEntityDetails) throws ResourceNotFoundException;

  void deleteEmployee(Long employeeId) throws ResourceNotFoundException;
}
