package org.midasvision;

import org.midasvision.model.Department;
import org.midasvision.model.dao.DaoFactory;
import org.midasvision.model.dao.DepartmentDao;

import java.util.ArrayList;
import java.util.List;

public class MainDepartment {
    public static void main(String[] args) {

        DepartmentDao dao = DaoFactory.createDepartmentDao();

        List<Department> l = new ArrayList<>();
        l = dao.findAll();

        for(Department d : l) {
            System.out.println(d);
        }
    }
}
