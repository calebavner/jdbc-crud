package org.midasvision.db;

import org.midasvision.exceptions.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection conn = null;
    private static Properties loadProps() {
        try(FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;

        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static Connection getConnection() {
        if(conn == null) {
            try {
                Properties props = loadProps();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);

            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if(conn != null){
            try {
                conn.close();

            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement s) {
        if(s != null)
            try {
                s.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
    }

    public static void closeResultSet(ResultSet rs) {
        if(rs != null)
            try {
                rs.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
    }
}
