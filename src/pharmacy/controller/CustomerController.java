/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pharmacy.DB.DB;
import pharmacy.model.Customer;
import pharmacy.model.Supplier;
import pharmacy.model.User;

/**
 *
 * @author chami
 */
public class CustomerController {

    public static int save(Customer c) {

        String sql = "INSERT into  customer (cus_firstName,cus_lastName,cus_IDNumber,cus_address,cus_email,cus_mobile,cus_status,created_at,updated_at) Values(?,?,?,?,?,?,?,?,?)";
        try {

            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCus_firstName());
            ps.setString(2, c.getCus_lastName());
            ps.setString(3, c.getCus_IDNumber());
            ps.setString(4, c.getCus_address());
            ps.setString(5, c.getCus_email());
            ps.setString(6, c.getCus_mobile());
            ps.setInt(7, c.getCus_status());
            ps.setString(8, c.getCreated_at());
            ps.setString(9, c.getUpdated_at());
            ps.executeUpdate();

            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

    public static List<Customer> list() {
        List<Customer> list = new ArrayList<Customer>();
        String sql = "SELECT* from customer WHERE cus_status=0";
        Customer c;
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                //User user = UserController.getUserById(rs.getInt("user_id"));
                c = new Customer();
                c.setCus_id(rs.getInt("cus_id"));
                c.setCus_firstName(rs.getString("cus_firstName"));
                c.setCus_lastName(rs.getString("cus_lastName"));
                c.setCus_IDNumber(rs.getString("cus_IDNumber"));
                c.setCus_address(rs.getString("cus_address"));
                c.setCus_email(rs.getString("cus_email"));
                c.setCus_mobile(rs.getString("cus_mobile"));
                c.setCus_status(rs.getInt("cus_status"));
                c.setCreated_at(rs.getString("created_at"));
                c.setUpdated_at(rs.getString("updated_at"));
                // s.setUser_id(user);

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Customer searchCustomerById(String id) throws ClassNotFoundException, SQLException {
        String quary = "SELECT*FROM customer WHERE cus_id='" + id + "'";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
        ResultSet rs = ps.executeQuery();
        Customer c = null;
        if (rs.next()) {
            //User user = UserController.getUserById(rs.getInt("user_id"));

            c = new Customer();
            c.setCus_id(rs.getInt("cus_id"));
            c.setCus_firstName(rs.getString("cus_firstName"));
            c.setCus_lastName(rs.getString("cus_lastName"));
            c.setCus_IDNumber(rs.getString("cus_IDNumber"));
            c.setCus_address(rs.getString("cus_address"));
            c.setCus_email(rs.getString("cus_email"));
            c.setCus_mobile(rs.getString("cus_mobile"));
            c.setCus_status(rs.getInt("cus_status"));
            c.setCreated_at(rs.getString("created_at"));
            c.setUpdated_at(rs.getString("updated_at"));
            // s.setUser_id(user);
        }

        rs = null;
        return c;

    }public static int update(Customer customer) throws ClassNotFoundException, SQLException {
       

        String quary = "UPDATE customer set cus_firstName=?,cus_lastName=?,cus_IDNumber=?,cus_address=?,cus_email=?,cus_mobile=?,updated_at=? WHERE cus_id='" + customer.getCus_id()+ "'";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
        ps.setObject(1, customer.getCus_firstName());
        ps.setObject(2, customer.getCus_lastName());
        ps.setObject(3, customer.getCus_IDNumber());
        ps.setObject(4, customer.getCus_address());
        ps.setObject(5, customer.getCus_email());
        ps.setObject(6, customer.getCus_mobile());
        ps.setObject(7, customer.getUpdated_at());

        return ps.executeUpdate();
    }
    public static int delete(int id) throws ClassNotFoundException, SQLException {
            String quary = "UPDATE customer set cus_status=1 WHERE cus_id='" + id+ "'";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
      
        return ps.executeUpdate();

    }
    public static List<Customer> searchCustomerByName(String name) throws ClassNotFoundException, SQLException {
        String quary = "Select * From customer where cus_firstName LIKE'" + name + "%' AND cus_status=0";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
        ResultSet rs = ps.executeQuery();
        Customer c;
        List<Customer> list = new ArrayList();
        while (rs.next()) {
           // User user = UserController.getUserById(rs.getInt("user_id"));

            c = new Customer();
            c.setCus_id(rs.getInt("cus_id"));
            c.setCus_firstName(rs.getString("cus_firstName"));
            c.setCus_lastName(rs.getString("cus_lastName"));
            c.setCus_IDNumber(rs.getString("cus_IDNumber"));
            c.setCus_address(rs.getString("cus_address"));
            c.setCus_email(rs.getString("cus_email"));
            c.setCus_mobile(rs.getString("cus_mobile"));
            c.setCus_status(rs.getInt("cus_status"));
            c.setCreated_at(rs.getString("created_at"));
            c.setUpdated_at(rs.getString("updated_at"));
           // c.setUser_id(user);

            list.add(c);
        }

        rs = null;
        return list;

    }
     public static Customer searchCustomerByNameDefault(String name) throws ClassNotFoundException, SQLException {
        String quary = "SELECT*FROM customer WHERE cus_firstName='" + name + "'";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
        ResultSet rs = ps.executeQuery();
        Customer c = null;
        if (rs.next()) {
            //User user = UserController.getUserById(rs.getInt("user_id"));

            c = new Customer();
            c.setCus_id(rs.getInt("cus_id"));
            c.setCus_firstName(rs.getString("cus_firstName"));
            c.setCus_lastName(rs.getString("cus_lastName"));
            c.setCus_IDNumber(rs.getString("cus_IDNumber"));
            c.setCus_address(rs.getString("cus_address"));
            c.setCus_email(rs.getString("cus_email"));
            c.setCus_mobile(rs.getString("cus_mobile"));
            c.setCus_status(rs.getInt("cus_status"));
            c.setCreated_at(rs.getString("created_at"));
            c.setUpdated_at(rs.getString("updated_at"));
            // s.setUser_id(user);
        }

        rs = null;
        return c;

    }
}
