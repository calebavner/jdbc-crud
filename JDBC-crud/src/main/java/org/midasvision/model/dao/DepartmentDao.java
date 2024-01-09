package org.midasvision.model.dao;

import org.midasvision.model.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department d);

    void update(Department d);

    void deleteById(Integer id);

    Department findById(Integer id);

    List<Department> findAll();
}
