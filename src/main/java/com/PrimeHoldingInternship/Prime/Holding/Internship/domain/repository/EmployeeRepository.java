package com.PrimeHoldingInternship.Prime.Holding.Internship.domain.repository;

import com.PrimeHoldingInternship.Prime.Holding.Internship.domain.entity.Employee;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    default Optional<Employee> getEmpolyeeById(Long employeeId) {
        return this.findById(employeeId);
    }
    @Override
    void deleteById(@NotNull Long employeeId);

    @Query("SELECT e.fullName, COUNT(t.id) AS numTasks " +
            "FROM Employee e " +
            "JOIN Task t ON e.id = t.employee.id " +
            "WHERE t.dueDate BETWEEN :startDate AND :endDate " +
            "GROUP BY e.id " +
            "ORDER BY numTasks DESC " +
            "LIMIT 5")
    List<Object[]> findTopEmployeesByNumTasksCompleted(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}


