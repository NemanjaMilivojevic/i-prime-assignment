package com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto;

import java.util.List;

public record CustomPageDto<T>(List<T> content, int pageNumber, int pageSize, long totalElements) {
}
