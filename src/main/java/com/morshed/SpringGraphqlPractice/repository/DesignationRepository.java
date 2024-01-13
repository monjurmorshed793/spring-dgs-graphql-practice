package com.morshed.SpringGraphqlPractice.repository;

import com.morshed.SpringGraphqlPractice.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DesignationRepository extends JpaRepository<Designation, UUID> {
}
