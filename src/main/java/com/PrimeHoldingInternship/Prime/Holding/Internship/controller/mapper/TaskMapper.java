package com.PrimeHoldingInternship.Prime.Holding.Internship.controller.mapper;

import com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto.TaskRequestDto;
import com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto.TaskResponseDto;
import com.PrimeHoldingInternship.Prime.Holding.Internship.domain.entity.Task;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Component
public class TaskMapper {
    public Task mapToEntity(TaskRequestDto taskRequestDto) {
        var task = new Task();
        task.setTitle(taskRequestDto.getTitle());
        task.setDescription(taskRequestDto.getDescription());
        task.setDueDate(taskRequestDto.getDueDate());
        return task;
    }

    public Task editTask (Task task, TaskRequestDto taskRequestDto) {
        if (nonNull(taskRequestDto.getTitle()) && !taskRequestDto.getTitle().isEmpty()) {
            task.setTitle(taskRequestDto.getTitle());
        }
        if (nonNull(taskRequestDto.getDescription()) && !taskRequestDto.getDescription().isEmpty()) {
            task.setDescription(taskRequestDto.getDescription());
        }
        if (nonNull(taskRequestDto.getDueDate())) {
            task.setDueDate(taskRequestDto.getDueDate());
        }
        return task;
    }

    public static TaskResponseDto mapToDto(Task task) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setTitle(task.getTitle());
        taskResponseDto.setDescription(task.getDescription());
        taskResponseDto.setEmployeeFullName(task.getEmployee().getFullName());
        taskResponseDto.setEmployeeEmail(task.getEmployee().getEmail());
        taskResponseDto.setDueDate(task.getDueDate());
        return taskResponseDto;
    }
}
