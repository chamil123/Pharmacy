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
import pharmacy.DB.DB;
import pharmacy.model.Category;
import pharmacy.model.Role;
import pharmacy.model.User;

/**
 *
 * @author chami
 */
public class UserController {

    public static User getUserById(int user_id) {
        User u = null;
        Role role = null;
        String sql = "SELECT* from user WHERE user_id='" + user_id + "'";
        //2.get connection
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                role = RoleController.getRoleById(rs.getInt("role_id"));

                u = new User();
                u.setUser_id(rs.getInt("user_id"));
                u.setUser_firstName(rs.getString("user_firstName"));
                u.setUser_lastName(rs.getString("user_lastName"));
                u.setUser_email(rs.getString("user_email"));
                u.setUser_NIC(rs.getString("user_NIC"));
                u.setUser_DOB(rs.getString("user_DOB"));
                u.setUser_phoneNumber(rs.getString("user_phoneNumber"));
                u.setUser_gender(rs.getString("user_gender"));
                u.setUser_addess(rs.getString("user_addess"));
                u.setUser_image(rs.getString("user_image"));
                u.setUser_status(rs.getInt("user_status"));
                u.setCreated_at(rs.getString("created_at"));
                u.setUpdaated_at(rs.getString("updaated_at"));
                u.setRole_id(role);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }
}
