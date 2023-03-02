/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    public static UserService userService = null;

    public static UserService getInstance() {
        if (userService == null) {
            return new UserService();
        } else {
            return userService;
        }
    }
    
    public static User getUser(int userId) {
        User user = new User();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from users where userId =?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                user.setUserId(rs.getInt("userId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setAadharNumber(rs.getString("aadharNumber"));
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

//    public ArrayList getAllEmployees() {
//        ArrayList empList = new ArrayList();
//        String sql = "SELECT  employeeId,firstName,lastName,phone,gender,age,departmentName,roleName,basicSalary FROM employees LEFT JOIN roles On employees.roleId= roles.roleId LEFT JOIN departments On employees.departmentId= departments.departmentId";
//        try {
//            Connection con = JDBCConnectionManager.getConnection();
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            System.out.println(rs);
//
//            while (rs.next()) {
//                Employee emp = new Employee();
//
//                emp.setEmployeeId(rs.getString("employeeId"));
//                emp.setFirstName(rs.getString("firstName"));
//                emp.setLastName(rs.getString("lastName"));
//                emp.setPhone(rs.getString("phone"));
//                emp.setGender(rs.getString("gender"));
//                emp.setAge(rs.getString("age"));
//                emp.setDepartmentName(rs.getString("departmentName"));
//                emp.setRoleName(rs.getString("roleName"));
//                emp.setBasicSalary(rs.getString("basicSalary"));
//
//                empList.add(emp);
//            }
//
//        } catch (SQLException ex) {
//            Logger log = Logger.getLogger(EmployeeService.class.getName());
//            log.error("Error in Employee Service");
//        }
//        System.err.println("Total rows:" + empList.size());
//        return empList;
//    }

//    public boolean Edit(Employee emp) {
//        boolean result = false;
//        try {
//            Connection con = JDBCConnectionManager.getConnection();
//            String sql = "UPDATE employeedatabase.employees\n"
//                    + "SET firstName = ? , lastName = ? , phone = ? ,\n"
//                    + "gender = ? , age = ? , basicSalary = ?,departmentId=?,roleId=?\n"
//                    + "WHERE employeeId = ?";
//
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//
//            preparedStatement.setString(1, emp.getFirstName());
//            preparedStatement.setString(2, emp.getLastName());
//            preparedStatement.setString(3, emp.getPhone());
//
//            preparedStatement.setString(4, emp.getGender());
//            preparedStatement.setString(5, emp.getAge());
//            preparedStatement.setString(6, emp.getBasicSalary());
//            preparedStatement.setString(7, emp.getDepartmentId());
//            preparedStatement.setString(8, emp.getRoleId());
//
//            preparedStatement.setString(9, emp.getEmployeeId());
//            System.out.println(preparedStatement);
//
//            int row = preparedStatement.executeUpdate();
//            
//
//            if (row == 1) {
//                result = true;
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }

//    public boolean addEmployee(Employee emp) {
//        boolean result = false;
//        String sql = "INSERT INTO employeedatabase.employees\n"
//                + "(firstName,\n"
//                + "lastName,\n"
//                + "phone,\n"
//                + "gender,\n"
//                + "age,\n"
//                + "departmentId,\n"
//                + "roleId,\n"
//                + "basicSalary)\n"
//                + "VALUES\n"
//                + "(?,?,?,?,?,?,?,?);";
//
//        try {
//            Connection con = JDBCConnectionManager.getConnection();
//
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            preparedStatement.setString(1, emp.getFirstName());
//            preparedStatement.setString(2, emp.getLastName());
//            preparedStatement.setString(3, emp.getPhone());
//            preparedStatement.setString(4, emp.getGender());
//            preparedStatement.setString(5, emp.getAge());
//            preparedStatement.setString(6, emp.getDepartmentId());
//            preparedStatement.setString(7, emp.getRoleId());
//            preparedStatement.setInt(8, Integer.parseInt(emp.getBasicSalary()));
//            
//            System.out.println(preparedStatement);
//
//            int row = preparedStatement.executeUpdate();
//
//            if (row == 1) {
//                result = true;
//            }
//
//            
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }

//    public ArrayList searchEmployee(Employee emp) {
//        ArrayList empList = new ArrayList<>();
//        try {
//            Connection con = JDBCConnectionManager.getConnection();
//            String sql = "select * from employees e, departments d, roles r where e.departmentId=d.departmentId and e.roleId=r.roleId "
//                    + "having firstName like ? and lastName like ? and gender like ? and e.departmentId like ? and e.roleId like ?";
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//            System.out.println(emp.getFirstName());
//            preparedStatement.setString(1, emp.getFirstName() + "%");
//            preparedStatement.setString(2, emp.getLastName() + "%");
//            preparedStatement.setString(3, emp.getGender() + "%");
//            preparedStatement.setString(4, emp.getDepartmentId() + "%");
//            preparedStatement.setString(5, emp.getRoleId() + "%");
//            System.out.println("Prepared statement = " + preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                Employee emp1 = new Employee();
//                emp1.setEmployeeId(rs.getString("employeeId"));
//                emp1.setFirstName(rs.getString("firstName"));
//                emp1.setLastName(rs.getString("lastName"));
//                emp1.setPhone(rs.getString("phone"));
//                emp1.setGender(rs.getString("gender"));
//                emp1.setAge(rs.getString("age"));
//                emp1.setDepartmentId(rs.getString("departmentId"));
//                emp1.setDepartmentName(rs.getString("departmentName"));
//
//                emp1.setRoleId(rs.getString("roleId"));
//                emp1.setRoleName(rs.getString("roleName"));
//
//                emp1.setBasicSalary(rs.getString("basicSalary"));
//                
//
//                empList.add(emp1);
//
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return empList;
//
//    }
    
    
}

