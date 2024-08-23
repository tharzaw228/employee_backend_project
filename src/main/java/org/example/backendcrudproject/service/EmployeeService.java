package org.example.backendcrudproject.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.backendcrudproject.dao.EmployeeDao;
import org.example.backendcrudproject.dto.EmployeeDto;
import org.example.backendcrudproject.entity.Employee;
import org.example.backendcrudproject.util.EmployeeUtil;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return EmployeeUtil.employeeToEmployeeDto(employeeDao.save(EmployeeUtil.employeeDtoToEmployee(employeeDto)));
    }

    public EmployeeDto findEmployeeById(Long id) {
        return EmployeeUtil.employeeToEmployeeDto(employeeDao.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long id) {
        if(employeeDao.existsById(id)) {
            employeeDto.setId(id);
            return EmployeeUtil.employeeToEmployeeDto(employeeDao
                    .save(EmployeeUtil.employeeDtoToEmployee(employeeDto)));
        }else {
            throw new EntityNotFoundException("Employee Not Found");
        }
    }

    public void deleteEmployee(Long id) {
        if(employeeDao.existsById(id)) {
            employeeDao.deleteById(id);
        }else {
            throw new EntityNotFoundException("Employee Not Found");
        }
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeDao.findAll()
                .stream()
                .map(EmployeeUtil::employeeToEmployeeDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
