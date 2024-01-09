package com.sample.project.departmentservice.service.impl;

import com.sample.project.departmentservice.dto.DepartmentDto;
import com.sample.project.departmentservice.entity.Department;
import com.sample.project.departmentservice.repository.DepartmentRepository;
import com.sample.project.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert department dto to department jpa entity

        Department department=new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
            Department savedDepartment=departmentRepository.save(department);

            DepartmentDto savedDepartmentDto=new DepartmentDto(
                    savedDepartment.getId(),
                    savedDepartment.getDepartmentName(),
                    savedDepartment.getDepartmentDescription(),
                    savedDepartment.getDepartmentCode()

            );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentcode) {
        Department department=departmentRepository.findByDepartmentCode(departmentcode);
        DepartmentDto departmentDto=new DepartmentDto(
                department.getId(),department.getDepartmentName(),department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
