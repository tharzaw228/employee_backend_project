package org.example.backendcrudproject.dao;

import org.example.backendcrudproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
