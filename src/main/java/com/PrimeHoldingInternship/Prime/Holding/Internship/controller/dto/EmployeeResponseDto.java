package com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto;

public class EmployeeResponseDto {
    private String fullName;
    private Long count;

    public EmployeeResponseDto() {
    }

    public EmployeeResponseDto(String fullName, Long count) {
        this.fullName = fullName;
        this.count = count;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
