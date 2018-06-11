package com.team11.cab.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team11.cab.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {
	
	@Query("SELECT d.departmentId FROM Department d")
	ArrayList<String> findDepartmentNames();

}
