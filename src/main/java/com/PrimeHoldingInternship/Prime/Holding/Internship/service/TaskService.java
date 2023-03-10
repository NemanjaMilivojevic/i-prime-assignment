package com.PrimeHoldingInternship.Prime.Holding.Internship.service;

import com.PrimeHoldingInternship.Prime.Holding.Internship.domain.entity.Task;
import com.PrimeHoldingInternship.Prime.Holding.Internship.domain.repository.TaskRepository;
import com.PrimeHoldingInternship.Prime.Holding.Internship.service.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final EmployeeService employeeService;

    public TaskService(TaskRepository taskRepository, EmployeeService employeeService) {
        this.taskRepository = taskRepository;
        this.employeeService = employeeService;
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task findTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new NotFoundException("Task with provided ID not found"));
    }

    public void updateTask(Task task, Long id) {

        if (nonNull(id)) {
            var assignee = employeeService.findEmployeeById(id);
            task.setEmployee(assignee);
        }
        taskRepository.save(task);
    }

    public Page<Task> findAllTasks(Pageable pageable) {

        return taskRepository.findAll(pageable);
    }


}
