package com.gabrielgermano.manager.service;

import com.gabrielgermano.manager.model.Employee;
import com.gabrielgermano.manager.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Long id) {
        logger.info("Fetching employee by id: {}", id);
        return employeeRepository.findById(id).orElseThrow();
    }

    public List<Employee> getAllEmployees() {
        logger.info("Fetching all employees");
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        logger.info("Creating new employee: name={}, email={}, position={}", employee.getName(), employee.getEmail(), employee.getPosition());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        logger.info("Updating employee with ID: {}", id);
        Employee foundEmployee = employeeRepository.findById(id).orElseThrow();

        foundEmployee.setName(employee.getName());
        foundEmployee.setSalary(employee.getSalary());
        foundEmployee.setEmail(employee.getEmail());
        foundEmployee.setPosition(employee.getPosition());

        logger.info("Employee with ID: {} updated successfully", id);
        return employeeRepository.save(foundEmployee);
    }

    public void deleteEmployee(Long id) {
        logger.info("Attempting to delete employee with ID: {}", id);
        employeeRepository.deleteById(id);
    }




}
