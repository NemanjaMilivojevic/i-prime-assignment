package com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDto {
    @NotBlank(message = "Full name must not be blank")
    @Size(min = 2, max = 255, message = "Full name must be between 2 and 255 characters")
    private String fullName;
    @Email(message = "Please provide a valid email address")
    private String email;
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Please provide a valid phone number in the format '+1234567890'")
    private String phoneNumber;
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    @DecimalMin(value = "0.0", message = "Monthly salary must be positive")
    private BigDecimal monthlySalary;

    public EmployeeDto() {

    }

    public EmployeeDto(String fullName, String email, String phoneNumber, LocalDate dateOfBirth, BigDecimal monthlySalary) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.monthlySalary = monthlySalary;


    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
