package com.sample.project.employeeservice.service;

import com.sample.project.employeeservice.dto.APIResponseDto;
import com.sample.project.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
