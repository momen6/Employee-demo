package com.example.employeedemo.service;

import com.example.employeedemo.converter.EmployeeConverter;
import com.example.employeedemo.dto.EmployeeDTO;
import com.example.employeedemo.dto.GenericRestResponse;
import com.example.employeedemo.exception.NotFoundException;
import com.example.employeedemo.model.Employee;
import com.example.employeedemo.repository.EmployeeRepo;
import com.example.employeedemo.util.ModelMapperUtil;
import com.example.employeedemo.util.enums.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public GenericRestResponse<?> getAllEmployees() {
        return GenericRestResponse.builder()
                .date(this.employeeRepo.findAll().stream().map(employee -> ModelMapperUtil.MAPPER().map(employee, EmployeeDTO.class)))
                .responseMessage(ResponseMessage.SUCCESS)
                .responseCode(ResponseMessage.SUCCESS.getCode())
                .build();
    }

    public GenericRestResponse<?> getEmployeeById(Long id) {
        Employee employee = this.employeeRepo.findById(id).orElseThrow(() -> new NotFoundException("No Employees Found with this Id: " + id));
        return GenericRestResponse.builder()
                .date(EmployeeConverter.toDTO(employee))
                .responseMessage(ResponseMessage.SUCCESS)
                .responseCode(ResponseMessage.SUCCESS.getCode())
                .build();
    }

    public GenericRestResponse<?> saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = this.employeeRepo.save(EmployeeConverter.toEntity(employeeDTO));
        return GenericRestResponse.builder()
                .date(employee)
                .responseMessage(ResponseMessage.SUCCESS)
                .responseCode(ResponseMessage.SUCCESS.getCode())
                .build();
    }

    public GenericRestResponse<?> deleteEmployee(Long id){
        Optional<Employee> employee = this.employeeRepo.findById(id);
        if (employee.isPresent())
            this.employeeRepo.deleteById(id);
        else
            throw new NotFoundException("No Employees Found with this Id: " + id);
        return GenericRestResponse.builder()
                .responseMessage(ResponseMessage.SUCCESS)
                .responseCode(ResponseMessage.SUCCESS.getCode())
                .build();
    }
}
