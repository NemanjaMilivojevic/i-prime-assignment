package com.PrimeHoldingInternship.Prime.Holding.Internship.controller.mapper;

import com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto.EmployeeDto;
import com.PrimeHoldingInternship.Prime.Holding.Internship.domain.entity.Employee;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class EmployeeMapper {
    public Employee mapToEntity(EmployeeDto employeeDto) {
        var employee = new Employee();
        employee.setFullName(employeeDto.getFullName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setMonthlySalary(employeeDto.getMonthlySalary());
        return employee;
    }
    public Employee editEmployee (Employee employee, EmployeeDto employeeDto) {
        if (nonNull(employeeDto.getFullName()) && !employeeDto.getFullName().isEmpty()) {
            employee.setFullName(employeeDto.getFullName());
        }
        if (nonNull(employeeDto.getEmail()) && !employeeDto.getEmail().isEmpty()) {
            employee.setEmail(employeeDto.getEmail());
        }
        if (nonNull(employeeDto.getPhoneNumber()) && !employeeDto.getPhoneNumber().isEmpty()) {
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
        }
        if (nonNull(employeeDto.getDateOfBirth())) {
            employee.setDateOfBirth(employeeDto.getDateOfBirth());
        }
        if (nonNull(employeeDto.getMonthlySalary())) {
            employee.setMonthlySalary(employeeDto.getMonthlySalary());
        }
        return employee;
    }
    public static EmployeeDto mapToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFullName(employee.getFullName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setDateOfBirth(employee.getDateOfBirth());
        employeeDto.setMonthlySalary(employee.getMonthlySalary());
        return employeeDto;
    }
}
