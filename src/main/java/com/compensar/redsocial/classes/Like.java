/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compensar.redsocial.classes;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class Like {
    
    private final int id;
    private final int publicacion;
    private final int usuario;
    private final Date fecha;

    public Like(int id, int publicacion, int usuario, Date fecha) {
        this.id = id;
        this.publicacion = publicacion;
        this.usuario = usuario;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public int getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
    }
    
}
