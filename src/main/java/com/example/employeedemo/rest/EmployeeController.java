package com.example.employeedemo.rest;

import com.example.employeedemo.dto.EmployeeDTO;
import com.example.employeedemo.dto.GenericRestResponse;
import com.example.employeedemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<GenericRestResponse<?>> getAllEmployees() {
        return ResponseEntity.ok(this.service.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericRestResponse<?>> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<GenericRestResponse<?>> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeDTO.setId(0L);
        return ResponseEntity.ok(this.service.saveEmployee(employeeDTO));
    }

    @PutMapping
    public ResponseEntity<GenericRestResponse<?>> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(this.service.saveEmployee(employeeDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GenericRestResponse<?>> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok(this.service.deleteEmployee(id));
    }
}
