package com.PrimeHoldingInternship.Prime.Holding.Internship.controller;

import com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto.CustomPageDto;
import com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto.EmployeeDto;
import com.PrimeHoldingInternship.Prime.Holding.Internship.controller.mapper.EmployeeMapper;
import com.PrimeHoldingInternship.Prime.Holding.Internship.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        var employee = employeeMapper.mapToEntity(employeeDto);
        employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long contactId) {
        employeeService.deleteEmployee(contactId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<EmployeeDto> updateContact(@PathVariable(name = "id") Long id, @RequestBody EmployeeDto employeeDto) {
        var oldEmployee = employeeService.findEmployeeById(id);
        var newEmployee = employeeMapper.editEmployee(oldEmployee, employeeDto);
        employeeService.updateEmployee(newEmployee);
        return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
    }

    @GetMapping("/all")
    public ResponseEntity<CustomPageDto<EmployeeDto>> findContacts(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        var result = employeeService.findAllUsers(pageable).map(EmployeeMapper::mapToDto);
        var customPageDto = new CustomPageDto<>(result.getContent(), result.getNumber(), result.getSize(), result.getTotalElements());
        return ResponseEntity.status(HttpStatus.OK).body(customPageDto);
    }

    @GetMapping("/top-5-empoyees")
    public ResponseEntity<?> findContacts() {
        var res = employeeService.findTopEmployeesByNumTasksCompleted();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
