package com.PrimeHoldingInternship.Prime.Holding.Internship.domain.repository;

import com.PrimeHoldingInternship.Prime.Holding.Internship.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Override
    Optional<Task> findById(Long taskId);

    @Override
    void deleteById(Long taskId);


}
