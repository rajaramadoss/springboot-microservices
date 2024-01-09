package com.sample.project.employeeservice.service.impl;

import com.sample.project.employeeservice.dto.EmployeeDto;
import com.sample.project.employeeservice.entity.Employee;
import com.sample.project.employeeservice.repository.EmployeeRepository;
import com.sample.project.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

   /* public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    } insted of @ALLArgsConstructor*/

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee=new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName(),employeeDto.getEmail());

        Employee savedEmployee=employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto=new EmployeeDto(savedEmployee.getId(),savedEmployee.getFirstName(),savedEmployee.getLastName(),savedEmployee.getEmail());

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).get();
            EmployeeDto employeeDto=new EmployeeDto(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail());
        return employeeDto;
    }
}
