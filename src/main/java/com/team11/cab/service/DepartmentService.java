package com.team11.cab.service;

import java.util.ArrayList;

import com.team11.cab.model.Department;

public interface DepartmentService {

	ArrayList<Department> findAllDepartments();

	Department findDepartment(String did);

	Department createDepartment(Department dep);

	Department changeDepartment(Department dep);

	void removeDepartment(Department dep);

}