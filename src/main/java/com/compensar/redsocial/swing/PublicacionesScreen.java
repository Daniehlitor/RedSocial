/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.compensar.redsocial.swing;

import com.compensar.redsocial.RedSocial;
import com.compensar.redsocial.classes.Usuario;
import com.compensar.redsocial.classes.Publicacion;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class PublicacionesScreen extends javax.swing.JFrame {

    /**
     * Creates new form pantallaInicial
     */
    public PublicacionesScreen() {
        try {
            initComponents();
            BienvenidaLable.setText("¡Bienvenido " + RedSocial.getLoggedUser().getNombre() + "!");
            setPublicaciones();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void setPublicaciones() {
        try {
            ArrayList<Publicacion> publicaciones = Publicacion.getPublicaciones();

            for (Publicacion publicacion : publicaciones) {
                System.out.println(publicacion.getContenido());
                PublicacionComponent component = new PublicacionComponent(publicacion);
                component.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
                PublicacionesPanel.add(component);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Body = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        TituloLable = new javax.swing.JLabel();
        BienvenidaLable = new javax.swing.JLabel();
        LogOutButton = new javax.swing.JButton();
        ScrollContent = new javax.swing.JScrollPane();
        Content = new javax.swing.JPanel();
        NuevaPublicacion = new javax.swing.JPanel();
        BotonPublicar = new javax.swing.JButton();
        ScrollTextArea = new javax.swing.JScrollPane();
        PublicacionTextArea = new javax.swing.JTextArea();
        PublicacionesPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Body.setBackground(new java.awt.Color(255, 255, 255));

        Header.setBackground(new java.awt.Color(107, 20, 166));

        TituloLable.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        TituloLable.setForeground(new java.awt.Color(255, 255, 255));
        TituloLable.setText("ChirpHub");

        BienvenidaLable.setForeground(new java.awt.Color(255, 255, 255));
        BienvenidaLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BienvenidaLable.setText("¡Bienvenido Usuario!");

        LogOutButton.setText("Cerrar Sesión");
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLable, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BienvenidaLable, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogOutButton)
                .addGap(14, 14, 14))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BienvenidaLable, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogOutButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BotonPublicar.setBackground(new java.awt.Color(107, 20, 166));
        BotonPublicar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        BotonPublicar.setForeground(new java.awt.Color(255, 255, 255));
        BotonPublicar.setText("Publicar");
        BotonPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPublicarActionPerformed(evt);
            }
        });

        PublicacionTextArea.setColumns(20);
        PublicacionTextArea.setRows(5);
        ScrollTextArea.setViewportView(PublicacionTextArea);

        PublicacionesPanel.setLayout(new javax.swing.BoxLayout(PublicacionesPanel, javax.swing.BoxLayout.Y_AXIS));

        javax.swing.GroupLayout NuevaPublicacionLayout = new javax.swing.GroupLayout(NuevaPublicacion);
        NuevaPublicacion.setLayout(NuevaPublicacionLayout);
        NuevaPublicacionLayout.setHorizontalGroup(
            NuevaPublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NuevaPublicacionLayout.createSequentialGroup()
                .addGroup(NuevaPublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(NuevaPublicacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PublicacionesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, NuevaPublicacionLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(NuevaPublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotonPublicar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ScrollTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );
        NuevaPublicacionLayout.setVerticalGroup(
            NuevaPublicacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NuevaPublicacionLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(ScrollTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(BotonPublicar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PublicacionesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(NuevaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NuevaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        ScrollContent.setViewportView(Content);

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BodyLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(ScrollContent, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ScrollContent, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPublicarActionPerformed
        // TODO add your handling code here:
        try {
            String contenido = PublicacionTextArea.getText();
            if (RedSocial.validateEmptyString(new String[]{contenido})) {
                PublicacionesPanel.removeAll();
                Publicacion.crearPublicacion(contenido);
                PublicacionTextArea.setText("");
                this.setPublicaciones();
            } else {
                RedSocial.showMessage(
                        "Error",
                        "La publicacion no tiene contenido",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_BotonPublicarActionPerformed

    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButtonActionPerformed
        try {
            // TODO add your handling code here:
            Usuario.logout();
            new InicioSesionScreen().setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_LogOutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PublicacionesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PublicacionesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PublicacionesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PublicacionesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PublicacionesScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BienvenidaLable;
    private javax.swing.JPanel Body;
    private javax.swing.JButton BotonPublicar;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Header;
    private javax.swing.JButton LogOutButton;
    private javax.swing.JPanel NuevaPublicacion;
    private javax.swing.JTextArea PublicacionTextArea;
    private javax.swing.JPanel PublicacionesPanel;
    private javax.swing.JScrollPane ScrollContent;
    private javax.swing.JScrollPane ScrollTextArea;
    private javax.swing.JLabel TituloLable;
    // End of variables declaration//GEN-END:variables
}
