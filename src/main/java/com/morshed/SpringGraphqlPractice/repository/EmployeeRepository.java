package com.morshed.SpringGraphqlPractice.repository;

import com.morshed.SpringGraphqlPractice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
