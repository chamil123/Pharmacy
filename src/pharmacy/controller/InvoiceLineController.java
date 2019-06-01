/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pharmacy.DB.DB;
import pharmacy.model.Invoice;
import pharmacy.model.InvoiceLine;

/**
 *
 * @author chami
 */
public class InvoiceLineController {

    public static int save(InvoiceLine i) {
        String sql = "INSERT into invoice_line (inv_line_qty,inv_line_price,inv_line_discount,inv_lineAmount,inv_id,drug_id) Values(?,?,?,?,?,?)";

        System.out.println("asdas : "+sql);
        System.out.println("ds: "+i.getInv_line_qty()+" "+i.getInv_line_price()+" "+i.getInv_line_discount()+" "+i.getInv_lineAmount()+" "+i.getInv_id()+" "+i.getDrug_id());
        try {
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, i.getInv_line_qty());
            ps.setDouble(2, i.getInv_line_price());
            ps.setDouble(3, i.getInv_line_discount());
            ps.setDouble(4, i.getInv_lineAmount());
            ps.setInt(5, i.getInv_id());
            ps.setInt(6, i.getDrug_id());

            ps.executeUpdate();

            return 1;

        } catch (Exception e) {
            return 0;
        }
    }

}
