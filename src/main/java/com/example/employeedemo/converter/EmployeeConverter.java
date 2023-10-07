package com.example.employeedemo.converter;

import com.example.employeedemo.dto.EmployeeDTO;
import com.example.employeedemo.model.Employee;

public class EmployeeConverter {

    public static EmployeeDTO toDTO(Employee employee){
        return EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .department(employee.getDepartment())
                .salary(employee.getSalary())
                .build();
    }

    public static Employee toEntity(EmployeeDTO employeeDTO){
        return Employee.builder()
                .id(employeeDTO.getId())
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .department(employeeDTO.getDepartment())
                .salary(employeeDTO.getSalary())
                .build();
    }
}
