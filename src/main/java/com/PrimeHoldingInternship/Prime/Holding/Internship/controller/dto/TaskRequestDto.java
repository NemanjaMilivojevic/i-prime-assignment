package com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class TaskRequestDto {
    @NotBlank(message = "Title must not be blank")
    @Size(min = 2, max = 255, message = "Title must be between 2 and 255 characters")
    private String title;
    @NotBlank(message = "Description must not be blank")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;
    private Long employeeId;
    @NotNull(message = "Due date must not be null")
    @Future(message = "Due date must be a future date")
    private LocalDate dueDate;

    public TaskRequestDto() {
    }

    public TaskRequestDto(String title, String description, Long employeeId, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.employeeId = employeeId;
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
