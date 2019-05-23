/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pharmacy.DB.DB;
import pharmacy.model.Rack;

/**
 *
 * @author chami
 */
public class RackController {
    public static Rack getRackById(int rack_id) {
        Rack r = null;
        String sql = "SELECT* from rack WHERE rack_id=?";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rack_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                r = new Rack();
                r.setRack_id(rs.getInt("rack_id"));
                r.setRack_name(rs.getString("rack_name"));
                r.setRack_status(rs.getInt("rack_status"));
                

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
