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
import pharmacy.model.Batch;
import pharmacy.model.Drug;
import pharmacy.model.Rack;

/**
 *
 * @author chami
 */
public class BatchController {

    public static Batch getOldBatch(int drug_id) {
        Batch b = null;
        String sql = "SELECT* from batch WHERE drug_id=? LIMIT 1";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, drug_id);
            ResultSet rs = ps.executeQuery();
            Drug drug;
//            Rack rack;
            if (rs.next()) {
                drug = DrugController.searchByDrugId("" + rs.getInt("drug_id"));
//                rack = RackController.getRackById(rs.getInt("rack_id"));
                b = new Batch();
                b.setBatch_id(rs.getInt("batch_id"));
                b.setBatch_no(rs.getString("batch_no"));
                b.setBatch_exp_date(rs.getString("batch_exp_date"));
                b.setBatch_unit_cost(rs.getDouble("batch_unit_cost"));
                b.setBatch_unit_price(rs.getDouble("batch_unit_price"));
                b.setBatch_status(rs.getInt("batch_status"));
                b.setCreated_at(rs.getString("created_at"));
                b.setUpdated_at(rs.getString("updated_at"));
                b.setDrug_id(drug);
//                b.setRack_id(rack);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public static List<Batch> getAllBatch(String drug_id) {
        List<Batch> list = new ArrayList<Batch>();
        Batch b = null;
        String sql = "SELECT* from batch WHERE drug_id=?";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, drug_id);
            ResultSet rs = ps.executeQuery();

            Drug drug;
//            Rack rack;
            while (rs.next()) {
                drug = DrugController.searchByDrugId("" + rs.getInt("drug_id"));
//                rack = RackController.getRackById(rs.getInt("rack_id"));
                b = new Batch();
                b.setBatch_id(rs.getInt("batch_id"));
                b.setBatch_no(rs.getString("batch_no"));
                b.setBatch_exp_date(rs.getString("batch_exp_date"));
                b.setBatch_unit_cost(rs.getDouble("batch_unit_cost"));
                b.setBatch_unit_price(rs.getDouble("batch_unit_price"));
                b.setBatch_status(rs.getInt("batch_status"));
                b.setCreated_at(rs.getString("created_at"));
                b.setUpdated_at(rs.getString("updated_at"));
                b.setDrug_id(drug);
//                b.setRack_id(rack);
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
