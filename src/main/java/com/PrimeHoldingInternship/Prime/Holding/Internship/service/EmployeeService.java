package com.PrimeHoldingInternship.Prime.Holding.Internship.service;

import com.PrimeHoldingInternship.Prime.Holding.Internship.domain.entity.Employee;
import com.PrimeHoldingInternship.Prime.Holding.Internship.domain.repository.EmployeeRepository;
import com.PrimeHoldingInternship.Prime.Holding.Internship.service.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.getEmpolyeeById(employeeId)
                .orElseThrow(() -> new NotFoundException("Employee with provided ID not found"));
    }

    public Page<Employee> findAllUsers(Pageable pageable) {

        return employeeRepository.findAll(pageable);
    }

    public List<Object[]> findTopEmployeesByNumTasksCompleted() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(30);
        return employeeRepository.findTopEmployeesByNumTasksCompleted(startDate, endDate);
    }

}
