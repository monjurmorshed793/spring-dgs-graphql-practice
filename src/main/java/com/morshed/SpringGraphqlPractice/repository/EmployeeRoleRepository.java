package com.morshed.SpringGraphqlPractice.repository;

import com.morshed.SpringGraphqlPractice.entity.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, UUID> {
}
