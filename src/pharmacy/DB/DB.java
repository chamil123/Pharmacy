/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacy.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chami
 */
public class DB {

    static Connection con = null;
    static String url = "jdbc:mysql://localhost:3306/pharmacy";

    public static Connection getCon() throws SQLException, ClassNotFoundException {
        if (con == null) {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "");

        }
        return con;
    }
}
