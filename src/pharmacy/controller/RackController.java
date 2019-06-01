/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public static List<Rack> list() {
        List<Rack> list = new ArrayList<Rack>();
        String sql = "SELECT* from rack WHERE rack_status=0";
        Rack r;
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                 r = new Rack();
                 r.setRack_id(rs.getInt("rack_id"));
                 r.setRack_name(rs.getString("rack_name"));
                 r.setRack_status(rs.getInt("rack_status"));

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static Rack getRack_id_byName(String rackName) {
       Rack b = null ;
        String sql = "SELECT* from rack WHERE rack_name='"+rackName+"'";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("rack_id");
                String name = rs.getString("rack_name");
                int status = rs.getInt("rack_status");


                b= new Rack();
                b.setRack_id(id);
                b.setRack_name(name);
                b.setRack_status(status);
               
               
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
  
}
