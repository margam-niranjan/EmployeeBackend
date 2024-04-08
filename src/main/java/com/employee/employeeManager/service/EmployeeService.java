package com.employee.employeeManager.service;

import com.employee.employeeManager.exception.UserNotFoundException;
import com.employee.employeeManager.model.Employee;
import com.employee.employeeManager.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee updateEmployee(Employee employee){

        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }


    public Employee findEmployeeById(Long id) throws UserNotFoundException {
        return employeeRepository.findEmployeeById(id).orElseThrow(
                () ->new UserNotFoundException("User by id "+id+" not found")
        );
    }



}
