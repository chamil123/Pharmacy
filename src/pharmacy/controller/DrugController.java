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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import pharmacy.DB.DB;
import pharmacy.model.Brand;
import pharmacy.model.Category;
import pharmacy.model.Drug;

/**
 *
 * @author chami
 */
public class DrugController {

    public static int save(Drug d) {

        String sql = "INSERT into drug (drug_name,drug_generic_name,drug_minimum_stock,drug_status,created_at,updated_at,cat_id,user_id,brand_id) Values(?,?,?,?,?,?,?,?,?)";
        try {

            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, d.getDrug_name());
            ps.setString(2, d.getDrug_generic_name());
            ps.setString(3, d.getDrug_minimum_stock());
            ps.setInt(4, d.getDrug_status());
            ps.setString(5, d.getCreated_at());
            ps.setString(6, d.getUpdated_at());
            ps.setInt(7, d.getCategory_id().getCat_id());
            ps.setInt(8, 1);
            ps.setInt(9, d.getBrand_id().getBrand_id());
            ps.executeUpdate();

            System.out.println("dasasd : " + d.getDrug_name());
            return 1;
        } catch (Exception e) {
            return 0;
        }

    }

    public static List<Drug> list() {
        List<Drug> list = new ArrayList<Drug>();
        String sql = "SELECT* from drug WHERE drug_status=0";
        Drug c;
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Brand brand = BrandController.getBrandById(rs.getInt("brand_id"));
                Category category = CategoryController.getCatById(rs.getInt("cat_id"));
                 c = new Drug();
                c.setDrug_id(rs.getInt("drug_id"));
                c.setDrug_name(rs.getString("drug_name"));
                c.setDrug_generic_name(rs.getString("drug_generic_name"));
                c.setDrug_minimum_stock(rs.getString("drug_minimum_stock"));
                c.setBrand_id(brand);
                c.setCategory_id(category);
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

//    public static int deleteDrugByID(String drugId) throws ClassNotFoundException, SQLException {
//        String quary = "delete  from drug where drug_id='" + drugId + "'";
//        Connection con = DB.getCon();
//        PreparedStatement ps = con.prepareStatement(quary);
//        int res = ps.executeUpdate();
//
//        if (res > 0) {
//            return 1;
//        } else {
//            return 0;
//        }
//
//    }
    public static int deleteDrugByID(String drugId) throws ClassNotFoundException, SQLException {

        String quary = "UPDATE drug set drug_status=? WHERE drug_id='" + drugId + "'";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);

        ps.setObject(1, 1);
        return ps.executeUpdate();

    }

    public static List<Drug> searchDrugByName(String name) throws ClassNotFoundException, SQLException {
        String quary = "Select * From drug where drug_name LIKE'" + name + "%'";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
        ResultSet rst = ps.executeQuery();

        Brand brand;
        Category category;
        List<Drug> list = new ArrayList();
        while (rst.next()) {
            brand = BrandController.getBrandById(rst.getInt("brand_id"));
            category = CategoryController.getCatById(rst.getInt("cat_id"));
            list.add(new Drug(rst.getInt("drug_id"), rst.getString("drug_name"), rst.getString("drug_generic_name"), rst.getString("drug_minimum_stock"), rst.getInt("drug_status"), rst.getString("created_at"), rst.getString("updated_at"), category, brand));
        }

        rst = null;
        return list;

    }

    public static Drug searchByDrugId(String id) throws SQLException, ClassNotFoundException {

        String quary = "Select * From drug WHERE drug_id='" + id + "'";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
        ResultSet rst = ps.executeQuery();
        Drug drug = null;
        Brand brand;
        Category category;
        if (rst.next()) {
            brand = BrandController.getBrandById(rst.getInt("brand_id"));
            category = CategoryController.getCatById(rst.getInt("cat_id"));
            drug = new Drug(rst.getInt("drug_id"), rst.getString("drug_name"), rst.getString("drug_generic_name"), rst.getString("drug_minimum_stock"), rst.getInt("drug_status"), rst.getString("created_at"), rst.getString("updated_at"), category, brand);
        
        }
//        Runtime.getRuntime().runFinalization();
//        Runtime.getRuntime().gc();
//        System.gc();
        rst = null;
        return drug;

    }

}
