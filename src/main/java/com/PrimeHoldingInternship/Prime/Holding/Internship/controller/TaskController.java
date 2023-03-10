package com.PrimeHoldingInternship.Prime.Holding.Internship.controller;

import com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto.CustomPageDto;
import com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto.TaskRequestDto;
import com.PrimeHoldingInternship.Prime.Holding.Internship.controller.dto.TaskResponseDto;
import com.PrimeHoldingInternship.Prime.Holding.Internship.controller.mapper.TaskMapper;
import com.PrimeHoldingInternship.Prime.Holding.Internship.service.EmployeeService;
import com.PrimeHoldingInternship.Prime.Holding.Internship.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final EmployeeService employeeService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, EmployeeService employeeService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.employeeService = employeeService;
        this.taskMapper = taskMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<TaskRequestDto> saveTask(@Valid @RequestBody TaskRequestDto taskRequestDto) {
        var assignee = employeeService.findEmployeeById(taskRequestDto.getEmployeeId());
        var task = taskMapper.mapToEntity(taskRequestDto);
        task.setEmployee(assignee);
        taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskRequestDto);
    }

    @DeleteMapping("delete/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable(name = "taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("update/{taskId}")
    public ResponseEntity<TaskRequestDto> updateTask(@PathVariable(name = "taskId") Long taskId, @RequestBody TaskRequestDto taskRequestDto) {
        var oldTask = taskService.findTaskById(taskId);
        var newTask = taskMapper.editTask(oldTask, taskRequestDto);
        taskService.updateTask(newTask, taskRequestDto.getEmployeeId());
        return ResponseEntity.status(HttpStatus.OK).body(taskRequestDto);
    }

    @GetMapping("/all")
    public ResponseEntity<CustomPageDto<TaskResponseDto>> findTask(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        var result = taskService.findAllTasks(pageable).map(TaskMapper::mapToDto);
        var customPageDto = new CustomPageDto<>(result.getContent(), result.getNumber(), result.getSize(), result.getTotalElements());
        return ResponseEntity.status(HttpStatus.OK).body(customPageDto);
    }

}
