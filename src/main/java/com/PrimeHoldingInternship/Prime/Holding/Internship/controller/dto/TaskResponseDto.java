package com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto;


import java.time.LocalDate;

public class TaskResponseDto {
    private String title;
    private String description;
    private String employeeFullName;
    private String employeeEmail;
    private LocalDate dueDate;

    public TaskResponseDto() {
    }

    public TaskResponseDto(String title, String description, String employeeFullName, String employeeEmail, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.employeeFullName = employeeFullName;
        this.employeeEmail = employeeEmail;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
