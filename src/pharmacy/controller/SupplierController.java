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
import pharmacy.model.Brand;
import pharmacy.model.Category;
import pharmacy.model.Drug;
import pharmacy.model.Supplier;
import pharmacy.model.User;

/**
 *
 * @author chami
 */
public class SupplierController {

    public static int save(Supplier s) {

        String sql = "INSERT into  supplier (sup_name,sup_address,sup_teliphone,sup_email,sup_status,sup_companyName,sup_IDnumber,created_at,updated_at,user_id) Values(?,?,?,?,?,?,?,?,?,?)";
        try {

            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getSup_name());
            ps.setString(2, s.getSup_address());
            ps.setString(3, s.getSup_teliphone());
            ps.setString(4, s.getSup_email());
            ps.setInt(5, s.getSup_status());
            ps.setString(6, s.getSup_companyName());
            ps.setString(7, s.getSup_IDnumber());
            ps.setString(8, s.getCreated_at());
            ps.setString(9, s.getUpdated_at());
            ps.setInt(10, 1);
            ps.executeUpdate();

            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

    public static int update(Supplier supplier) throws ClassNotFoundException, SQLException {
       

        String quary = "UPDATE supplier set sup_name=?,sup_address=?,sup_teliphone=?,sup_email=?,sup_companyName=?,sup_IDnumber=?,updated_at=?,user_id=? WHERE sup_id='" + supplier.getSup_id()+ "'";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
        ps.setObject(1, supplier.getSup_name());
        ps.setObject(2, supplier.getSup_address());
        ps.setObject(3, supplier.getSup_teliphone());
        ps.setObject(4, supplier.getSup_email());
        ps.setObject(5, supplier.getSup_companyName());
        ps.setObject(6, supplier.getSup_IDnumber());
        ps.setObject(7, supplier.getUpdated_at());
        ps.setObject(8, supplier.getUser_id().getUser_id());
        return ps.executeUpdate();
    }

    public static List<Supplier> list() {
        List<Supplier> list = new ArrayList<Supplier>();
        String sql = "SELECT* from supplier WHERE sup_status=0";
        Supplier s;
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User user = UserController.getUserById(rs.getInt("user_id"));

                s = new Supplier();
                s.setSup_id(rs.getInt("sup_id"));
                s.setSup_name(rs.getString("sup_name"));
                s.setSup_address(rs.getString("sup_address"));
                s.setSup_teliphone(rs.getString("sup_teliphone"));
                s.setSup_email(rs.getString("sup_email"));
                s.setSup_status(rs.getInt("sup_status"));
                s.setSup_companyName(rs.getString("sup_companyName"));
                s.setSup_IDnumber(rs.getString("sup_IDnumber"));
                s.setCreated_at(rs.getString("created_at"));
                s.setUpdated_at(rs.getString("updated_at"));
                s.setUser_id(user);

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Supplier> searchSupplierByName(String name) throws ClassNotFoundException, SQLException {
        String quary = "Select * From supplier where sup_name LIKE'" + name + "%' AND sup_status=0";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
        ResultSet rs = ps.executeQuery();
        Supplier s;
        List<Supplier> list = new ArrayList();
        while (rs.next()) {
            User user = UserController.getUserById(rs.getInt("user_id"));

            s = new Supplier();
            s.setSup_id(rs.getInt("sup_id"));
            s.setSup_name(rs.getString("sup_name"));
            s.setSup_address(rs.getString("sup_address"));
            s.setSup_teliphone(rs.getString("sup_teliphone"));
            s.setSup_email(rs.getString("sup_email"));
            s.setSup_status(rs.getInt("sup_status"));
            s.setSup_companyName(rs.getString("sup_companyName"));
            s.setSup_IDnumber(rs.getString("sup_IDnumber"));
            s.setCreated_at(rs.getString("created_at"));
            s.setUpdated_at(rs.getString("updated_at"));
            s.setUser_id(user);

            list.add(s);
        }

        rs = null;
        return list;

    }

    public static Supplier searchSupplierById(String id) throws ClassNotFoundException, SQLException {
        String quary = "SELECT*FROM supplier WHERE sup_id='" + id + "'";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
        ResultSet rs = ps.executeQuery();
        Supplier s = null;
        if (rs.next()) {
            User user = UserController.getUserById(rs.getInt("user_id"));

            s = new Supplier();
            s.setSup_id(rs.getInt("sup_id"));
            s.setSup_name(rs.getString("sup_name"));
            s.setSup_address(rs.getString("sup_address"));
            s.setSup_teliphone(rs.getString("sup_teliphone"));
            s.setSup_email(rs.getString("sup_email"));
            s.setSup_status(rs.getInt("sup_status"));
            s.setSup_companyName(rs.getString("sup_companyName"));
            s.setSup_IDnumber(rs.getString("sup_IDnumber"));
            s.setCreated_at(rs.getString("created_at"));
            s.setUpdated_at(rs.getString("updated_at"));
            s.setUser_id(user);
        }

        rs = null;
        return s;

    }public static int delete(int id) throws ClassNotFoundException, SQLException {
            String quary = "UPDATE supplier set sup_status=1 WHERE sup_id='" + id+ "'";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
      
        return ps.executeUpdate();

    }
}
