package com.sample.project.departmentservice.controller;

import com.sample.project.departmentservice.dto.DepartmentDto;
import com.sample.project.departmentservice.entity.Department;
import com.sample.project.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    //Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartments(@RequestBody DepartmentDto departmentDto){
    DepartmentDto savedDepartment= departmentService.saveDepartment(departmentDto);
    return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    //Build get department REST API
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto=departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }

}
