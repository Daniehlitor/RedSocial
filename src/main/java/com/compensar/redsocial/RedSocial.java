/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.compensar.redsocial;

import com.compensar.redsocial.classes.Estado;
import com.compensar.redsocial.swing.InicioSesionScreen;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class RedSocial {

    public static void main(String[] args) {
        DBConnection.connect();
        try {
            ArrayList<Estado> estados = Estado.getEstados();
            for (Estado estado : estados) {
                System.out.println("------------------------------------------------");
                System.out.println("id: " + estado.getId());
                System.out.println("nombre: " + estado.getName());
                System.out.println("avreviatura: " + estado.getShortName());
                System.out.println("descripcion: " + estado.getDescription());
            }
            System.out.println("------------------------------------------------");
            InicioSesionScreen.main(args);
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
