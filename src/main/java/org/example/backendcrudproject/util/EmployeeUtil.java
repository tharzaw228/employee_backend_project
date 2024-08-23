package org.example.backendcrudproject.util;

import org.example.backendcrudproject.dto.EmployeeDto;
import org.example.backendcrudproject.entity.Employee;
import org.springframework.beans.BeanUtils;

public class EmployeeUtil {

    public static EmployeeDto employeeToEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }

    public static  Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;
    }
}
