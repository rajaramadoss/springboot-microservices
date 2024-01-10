package com.sample.project.employeeservice.service.impl;

import com.sample.project.employeeservice.dto.APIResponseDto;
import com.sample.project.employeeservice.dto.DepartmentDto;
import com.sample.project.employeeservice.dto.EmployeeDto;
import com.sample.project.employeeservice.entity.Employee;
import com.sample.project.employeeservice.repository.EmployeeRepository;
import com.sample.project.employeeservice.service.APIClient;
import com.sample.project.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;

   // private WebClient webClient;
    // Feign Client Logic
    private APIClient apiClient;

   /* public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    } insted of @ALLArgsConstructor*/

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee=new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName(),employeeDto.getEmail(),employeeDto.getDepartmentCode());

        Employee savedEmployee=employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto=new EmployeeDto(savedEmployee.getId(),savedEmployee.getFirstName(),savedEmployee.getLastName(),savedEmployee.getEmail(),savedEmployee.getDepartmentCode());

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).get();

      /* ResponseEntity<DepartmentDto> responseEntity= restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),DepartmentDto.class);
       DepartmentDto departmentDto=responseEntity.getBody();*/

       // DepartmentDto departmentDto=webClient.get().uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
        DepartmentDto departmentDto=apiClient.getDepartment(employee.getDepartmentCode()); // Open Feign Logic
            EmployeeDto employeeDto=new EmployeeDto(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode());

        APIResponseDto apiResponseDto=new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
            return apiResponseDto;
    }
}
