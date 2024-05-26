/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.compensar.redsocial;

import com.compensar.redsocial.classes.Estado;
import com.compensar.redsocial.classes.Usuario;
import com.compensar.redsocial.swing.InicioSesionScreen;
import com.compensar.redsocial.swing.PublicacionesScreen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class RedSocial {

    private static Usuario logged_user;

    public static void main(String[] args) {
        try {

            DBConnection.connect();

            if (getLoggedUser() == null) {
                InicioSesionScreen.main(args);
            } else {
                PublicacionesScreen.main(args);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static Usuario getLoggedUser() throws SQLException {
        ResultSet result = DBConnection.getStatement().executeQuery("SELECT * FROM usuarios WHERE usuarios_logged = 1");
        if (result.next()) {
            logged_user = new Usuario(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getDate(5)
            );
        } else {
            logged_user = null;
        }
        return logged_user;
    }

    public static void showMessage(String title, String message, int type) {
        JOptionPane.showMessageDialog(
                null,
                message,
                title,
                type
        );
    }

    public static boolean validateEmptyString(String[] fields) {
        boolean val = true;
        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) {
                val = false;
            }
        }
        return val;
    }

    public static String getDateStr(Date date) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
