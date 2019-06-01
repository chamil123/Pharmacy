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
import pharmacy.DB.DB;
import pharmacy.model.Invoice;

/**
 *
 * @author chami
 */
public class InvoiceController {

    public static int getMaxId() throws ClassNotFoundException, SQLException {
        String quary = "SELECT MAX(inv_id)FROM  invoice";
        Connection con = DB.getCon();
        PreparedStatement ps = con.prepareStatement(quary);
        ResultSet res = ps.executeQuery();

        int max = 1;
        while (res.next()) {
            max = res.getInt("MAX(inv_id)");
            max++;
        }
        return max;
    }

    public static int save(Invoice i) {
        String sql = "INSERT into invoice (Inv_date,inv_number,Inv_discount,inv_total,inv_pay_method,inv_lineDiscount,inv_lineDisAmount,inv_status,created_at,updated_at,user_id,cus_id) Values(?,?,?,?,?,?,?,?,?,?,?,?)";
       
//        System.out.println(""+sql);
//        System.out.println(""+i.getInv_date()+","+i.getInv_number()+","+i.getInv_discount()+","+i.getInv_total()+","+i.getInv_pay_method()+","+ i.getInv_lineDiscount()+","+i.getInv_lineDisAmount()+","+i.getInv_status()+","+i.getCreated_at()+","+i.getUpdated_at()+","+i.getUser_id().getUser_id()+","+i.getCus_id().getCus_id());
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, i.getInv_date());
            ps.setString(2, i.getInv_number());
            ps.setDouble(3, i.getInv_discount());
            ps.setDouble(4, i.getInv_total());
            ps.setString(5, i.getInv_pay_method());
            ps.setDouble(6, i.getInv_lineDiscount());
            ps.setDouble(7, i.getInv_lineDisAmount());
            ps.setInt(8, i.getInv_status());
            ps.setString(9, i.getCreated_at());
            ps.setString(10, i.getUpdated_at());
            ps.setInt(11, i.getUser_id().getUser_id());
            ps.setInt(12, i.getCus_id().getCus_id());
            ps.executeUpdate();

           
            return 1;
           
        } catch (Exception e) {
            return 0;
        }
    }
}
