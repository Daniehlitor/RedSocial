/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compensar.redsocial.classes;

import com.compensar.redsocial.DBConnection;
import com.compensar.redsocial.RedSocial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Usuario {

    private final int id;
    private final String nombre;
    private final String email;
    private final String contrasena;
    private final Date fecha;

    public Usuario(int id, String nombre, String email, String contrasena, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Date getFecha() {
        return fecha;
    }

    public static void crearUsuario(String nombre, String email, String contrasena) throws SQLException {

        String fecha = RedSocial.getDateStr(new Date());

        String query = "INSERT INTO usuarios (usuarios_displayname, usuarios_email, usuarios_password, usuarios_date) VALUES ('" + nombre.toLowerCase() + "','" + email.toLowerCase() + "','" + contrasena + "', '" + fecha + "')";
        int result_insert = DBConnection.getStatement().executeUpdate(query);
        System.out.println(result_insert);

        if (result_insert > 0) {
            login(email, contrasena);
        }

    }

    public static boolean emailExist(String email) throws SQLException {
        ResultSet result = DBConnection.getStatement().executeQuery("SELECT * FROM usuarios WHERE usuarios_email = '" + email.toLowerCase() + "'");
        return result.next();
    }

    public static boolean usernameExist(String name) throws SQLException {
        ResultSet result = DBConnection.getStatement().executeQuery("SELECT * FROM usuarios WHERE usuarios_displayname = '" + name.toLowerCase() + "'");
        return result.next();
    }

    public static boolean login(String correo, String contrasena) throws SQLException {
        logout();
        ResultSet result = DBConnection.getStatement().executeQuery("SELECT * FROM usuarios WHERE usuarios_email = '" + correo.toLowerCase() + "' AND usuarios_password = '" + contrasena + "'");
        if (result.next()) {
            String query = "UPDATE usuarios SET usuarios_logged = 1 WHERE usuarios_id = " + result.getInt(1);
            int result_update = DBConnection.getStatement().executeUpdate(query);
            System.out.println(result_update);
            return true;
        } else {
            RedSocial.showMessage(
                    "Error",
                    "Correo electrónico o contraseña incorrecta",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    public static void logout() throws SQLException {
        String query = "UPDATE usuarios SET usuarios_logged = 0 WHERE usuarios_logged = 1";
        int result_update = DBConnection.getStatement().executeUpdate(query);
        System.out.println(result_update);
    }

}
