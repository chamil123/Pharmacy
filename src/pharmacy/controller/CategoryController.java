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
import pharmacy.model.Category;

/**
 *
 * @author chami
 */
public class CategoryController {

    public static boolean save(Category c) {

        String sql = "INSERT into category (name) Values(?)";
        try {

            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCat_name());
            ps.setString(2, c.getCat_description());
            ps.setInt(3, c.getCat_status());
            ps.setDate(4, (Date) c.getCreated_at());
            ps.setDate(5, (Date) c.getUpdated_at());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static List<Category> list() {
        List<Category> list = new ArrayList<Category>();
        String sql = "SELECT* from category";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cat_id");
                String name = rs.getString("cat_name");
                String description = rs.getString("cat_description");
                int status = rs.getInt("cat_status");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");

                Category c = new Category();
                c.setCat_id(id);
                c.setCat_name(name);
                c.setCat_description(description);
                c.setCat_status(status);
                c.setCreated_at(created_at);
                c.setUpdated_at(updated_at);
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Category getCategory_id_byName(String catName) {
       Category c = null ;
        String sql = "SELECT* from category WHERE cat_name='"+catName+"'";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cat_id");
                String name = rs.getString("cat_name");
                String description = rs.getString("cat_description");
                int status = rs.getInt("cat_status");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");

                c= new Category();
                c.setCat_id(id);
                c.setCat_name(name);
                c.setCat_description(description);
                c.setCat_status(status);
                c.setCreated_at(created_at);
                c.setUpdated_at(updated_at);
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
      public static Category getCatById(int cat_id) {
        Category c = null;
        String sql = "SELECT* from category WHERE cat_id='" + cat_id + "'";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cat_id");
                String name = rs.getString("cat_name");
                String description = rs.getString("cat_description");
                int status = rs.getInt("cat_status");
                Date created_at = rs.getDate("created_at");
                Date updated_at = rs.getDate("updated_at");

                c = new Category();
                c.setCat_id(cat_id);
                c.setCat_name(name);
                c.setCat_description(description);
                c.setCat_status(status);
                c.setCreated_at(created_at);
                c.setUpdated_at(updated_at);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
}
