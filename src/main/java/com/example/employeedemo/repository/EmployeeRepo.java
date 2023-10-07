package com.example.employeedemo.repository;

import com.example.employeedemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mo'men Magdy
 * Employee data (JPA)
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
