/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compensar.redsocial.swing;

import javax.swing.JPanel;
import com.compensar.redsocial.classes.Publicacion;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Daniel
 */
public class PublicacionComponent extends JPanel {

    public PublicacionComponent(Publicacion publicacion) {

        JLabel PublicacionText = new javax.swing.JLabel();
        JLabel PublicacionDate = new javax.swing.JLabel();
        JLabel PublicacionLikes = new javax.swing.JLabel();
        JLabel PublicacionUsuario = new javax.swing.JLabel();

        this.setBackground(new java.awt.Color(255, 255, 255));

        PublicacionText.setBackground(new java.awt.Color(255, 255, 255));
        PublicacionText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PublicacionText.setText(publicacion.getContenido());

        PublicacionDate.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PublicacionDate.setText("Publicado en " + publicacion.getDate());

        PublicacionLikes.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        PublicacionLikes.setText("");

        PublicacionUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PublicacionUsuario.setText(publicacion.getUsuario().getNombre());

        javax.swing.GroupLayout PublicacionLayout = new javax.swing.GroupLayout(this);
        this.setLayout(PublicacionLayout);
        PublicacionLayout.setHorizontalGroup(
                PublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PublicacionLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(PublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PublicacionLayout.createSequentialGroup()
                                                .addComponent(PublicacionUsuario)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(PublicacionLayout.createSequentialGroup()
                                                .addGroup(PublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(PublicacionText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(PublicacionLayout.createSequentialGroup()
                                                                .addComponent(PublicacionDate)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                                                                .addComponent(PublicacionLikes)))
                                                .addGap(15, 15, 15))))
        );
        PublicacionLayout.setVerticalGroup(
                PublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PublicacionLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(PublicacionUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PublicacionText, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(PublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PublicacionDate)
                                        .addComponent(PublicacionLikes))
                                .addGap(10, 10, 10))
        );
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

}
