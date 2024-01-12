package org.midasvision.model.dao;

import org.midasvision.db.DB;
import org.midasvision.exceptions.DbException;
import org.midasvision.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department d) {

    }

    @Override
    public void update(Department d) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("""
                select * from department""");

            rs = ps.executeQuery();

            List<Department> list = new ArrayList<>();

            while(rs.next()) {
                Department d = instantiateDepartment(rs);
                list.add(d);
            }
            return list;

        } catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department d = new Department();
        d.setId(rs.getInt("Id"));
        d.setName(rs.getString("Name"));
        return d;
    }
}
