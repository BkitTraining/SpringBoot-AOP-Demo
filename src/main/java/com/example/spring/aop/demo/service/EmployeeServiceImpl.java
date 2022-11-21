package com.example.spring.aop.demo.service;

import com.example.spring.aop.demo.exception.ResourceNotFoundException;
import com.example.spring.aop.demo.model.EmployeeEntity;
import com.example.spring.aop.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Override
  public List<EmployeeEntity> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public Optional<EmployeeEntity> getEmployeeById(Long employeeId) {
    return employeeRepository.findById(employeeId);
  }

  @Override
  @Transactional
  public EmployeeEntity addEmployee(EmployeeEntity employeeEntity) {
    return employeeRepository.save(employeeEntity);
  }

  @Override
  @Transactional
  public EmployeeEntity updateEmployee(Long employeeId,
                                       EmployeeEntity employeeEntityDetails) throws ResourceNotFoundException {
    EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
    employeeEntity.setEmail(employeeEntityDetails.getEmail());
    employeeEntity.setLastName(employeeEntityDetails.getLastName());
    employeeEntity.setFirstName(employeeEntityDetails.getFirstName());
    return employeeRepository.save(employeeEntity);
  }

  @Override
  public void deleteEmployee(Long employeeId)
      throws ResourceNotFoundException {
    EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
    employeeRepository.delete(employeeEntity);
  }
}
