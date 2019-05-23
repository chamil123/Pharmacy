/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pharmacy.DB.DB;
import pharmacy.model.Brand;
import pharmacy.model.Category;

/**
 *
 * @author chami
 */
public class BrandController {

    public static boolean save(Brand b) {

        String sql = "INSERT into brand (brand_name,brand_description,brand_status,created_at,updated_at) Values(?,?,?,?,?)";
        try {

            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, b.getBrand_name());
            ps.setString(2, b.getBrand_description());
            ps.setInt(3, b.getBrand_status());
            ps.setDate(4, (Date) b.getCreated_at());
            ps.setDate(5, (Date) b.getUpdated_at());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static List<Brand> list() {
        List<Brand> list = new ArrayList<Brand>();
        String sql = "SELECT* from brand";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("brand_id");
                String name = rs.getString("brand_name");
                String description = rs.getString("brand_description");
                int status = rs.getInt("brand_status");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");

                Brand b = new Brand();
                b.setBrand_id(id);
                b.setBrand_name(name);
                b.setBrand_description(description);
                b.setBrand_status(status);
                b.setCreated_at(created_at);
                b.setUpdated_at(updated_at);
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Brand getBrand_id_byName(String brandName) {
       Brand b = null ;
        String sql = "SELECT* from brand WHERE brand_name='"+brandName+"'";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("brand_id");
                String name = rs.getString("brand_name");
                String description = rs.getString("brand_description");
                int status = rs.getInt("brand_status");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");

                b= new Brand();
                b.setBrand_id(id);
                b.setBrand_name(name);
                b.setBrand_description(description);
                b.setBrand_status(status);
                b.setCreated_at(created_at);
                b.setUpdated_at(updated_at);
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
     public static Brand getBrandById(int brand_id) {
        Brand b=null;
        String sql = "SELECT* from brand WHERE brand_id='"+brand_id+"'";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("brand_id");
                String name = rs.getString("brand_name");
                String description = rs.getString("brand_description");
                int status = rs.getInt("brand_status");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");

                b = new Brand();
                b.setBrand_id(id);
                b.setBrand_name(name);
                b.setBrand_description(description);
                b.setBrand_status(status);
                b.setCreated_at(created_at);
                b.setUpdated_at(updated_at);
              
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
     
     
    
}
