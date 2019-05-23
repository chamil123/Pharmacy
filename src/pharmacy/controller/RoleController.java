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
import pharmacy.model.Category;
import pharmacy.model.Role;
import pharmacy.model.User;

/**
 *
 * @author chami
 */
public class RoleController {

    public static Role getRoleById(int role_id) {

        Role r = null;
        String sql = "SELECT* from role WHERE role_id='" + role_id + "'";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                r = new Role();
                r.setRole_id(rs.getInt("role_id"));
                r.setRole_name(rs.getString("role_name"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }
}
