package org.midasvision.model.dao;

import org.midasvision.db.DB;
import org.midasvision.exceptions.DbException;
import org.midasvision.model.Department;
import org.midasvision.model.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao{

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller s) {

    }

    @Override
    public void update(Seller s) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("""                    
                SELECT seller.*,department.Name as DepName
                FROM seller INNER JOIN department
                ON seller.DepartmentId = department.Id
                WHERE seller.Id = ?""");

            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                Department d = new Department();
                d.setId(rs.getInt("DepartmentId"));
                d.setName(rs.getString("DepName"));

                Seller s = new Seller();
                s.setId(rs.getInt("Id"));
                s.setName(rs.getString("Name"));
                s.setEmail(rs.getString("Email"));
                s.setBaseSalary(rs.getDouble("BaseSalary"));
                s.setBirthDate(rs.getDate("BirthDate"));
                s.setDepartment(d);
                return s;
            }
            return null;
        } catch(SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
