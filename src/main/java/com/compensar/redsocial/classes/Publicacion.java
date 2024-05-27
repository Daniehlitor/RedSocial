/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compensar.redsocial.classes;

import com.compensar.redsocial.DBConnection;
import com.compensar.redsocial.RedSocial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Publicacion {

    private int id;
    private Usuario usuario;
    private ArrayList<Like> likes;
    private String contenido;
    private Date fecha;

    public Publicacion(int id, int id_usuario, String contenido, Date fecha) {
        this.id = id;
        this.contenido = contenido;
        this.fecha = fecha;
        try {
            setUsuario(id_usuario);
            setLikes();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public String getContenido() {
        return this.contenido;
    }

    public String getDate() {
        return RedSocial.getDateStr(this.fecha);
    }

    public int getLikes() {
        return this.likes.size();
    }

    private void setUsuario(int id_usuario) throws SQLException {
        ResultSet result = DBConnection.getStatement().executeQuery("SELECT * FROM usuarios WHERE usuarios_id = " + id_usuario);
        result.next();
        this.usuario = new Usuario(
                result.getInt(1),
                result.getString(2),
                result.getString(3),
                result.getString(4),
                result.getDate(5)
        );
    }

    private void setLikes() throws SQLException {
        ResultSet result = DBConnection.getStatement().executeQuery("SELECT * FROM likes WHERE likes_publicacion = " + this.id);
        ArrayList<Like> array_result = new ArrayList<>();
        while (result.next()) {
            array_result.add(
                    new Like(
                            result.getInt(1),
                            result.getInt(2),
                            result.getInt(3),
                            result.getDate(4)
                    )
            );
        }
        this.likes = array_result;
    }

    public static ArrayList<Publicacion> getPublicaciones() throws SQLException {
        ResultSet result = DBConnection.getStatement().executeQuery("SELECT * FROM publicaciones ORDER BY publicaciones_id DESC");
        ArrayList<Publicacion> array_result = new ArrayList<>();
        while (result.next()) {
            array_result.add(
                    new Publicacion(
                            result.getInt(1),
                            result.getInt(2),
                            result.getString(4),
                            result.getDate(6)
                    )
            );
        }
        return array_result;
    }

    public static void crearPublicacion(String content) throws SQLException {
        String fecha = RedSocial.getDateStr(new Date());
        Usuario usuario = RedSocial.getLoggedUser();
        String query = "INSERT INTO publicaciones (publicaciones_usuario, publicaciones_text, publicaciones_date) VALUES (" + usuario.getId() + ",'" + content + "','" + fecha + "')";
        int result_insert = DBConnection.getStatement().executeUpdate(query);
        System.out.println(result_insert);
    }
}
