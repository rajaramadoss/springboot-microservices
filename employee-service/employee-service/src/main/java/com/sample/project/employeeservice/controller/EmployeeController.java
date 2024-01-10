package com.sample.project.employeeservice.controller;

import com.sample.project.employeeservice.dto.APIResponseDto;
import com.sample.project.employeeservice.dto.EmployeeDto;
import com.sample.project.employeeservice.entity.Employee;
import com.sample.project.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APIResponseDto apiResponseDto =employeeService.getEmployeeById(employeeId);
                    return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }

}
