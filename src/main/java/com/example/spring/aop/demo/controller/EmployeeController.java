package com.example.spring.aop.demo.controller;

import com.example.spring.aop.demo.annotation.LogMethod;
import com.example.spring.aop.demo.exception.ResourceNotFoundException;
import com.example.spring.aop.demo.model.EmployeeEntity;
import com.example.spring.aop.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@LogMethod
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping("/employees")
  public List<EmployeeEntity> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/employees/{id}")
  public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable(value = "id") Long employeeId)
      throws ResourceNotFoundException {
    EmployeeEntity employeeEntity = employeeService.getEmployeeById(employeeId);
    return ResponseEntity.ok().body(employeeEntity);
  }

  @PostMapping("/employees")
  public EmployeeEntity createEmployee(@Validated @RequestBody EmployeeEntity employeeEntity) {
    return employeeService.addEmployee(employeeEntity);
  }

  @PutMapping("/employees")
  public ResponseEntity<EmployeeEntity> updateEmployee(@Validated @RequestBody EmployeeEntity employeeEntityDetails)
      throws ResourceNotFoundException {
    EmployeeEntity updatedEmployeeEntity = employeeService.updateEmployee(employeeEntityDetails.getId(), employeeEntityDetails);
    return ResponseEntity.ok(updatedEmployeeEntity);
  }

  @DeleteMapping("/employees/{id}")
  public void deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
    employeeService.deleteEmployee(employeeId);
  }
}
