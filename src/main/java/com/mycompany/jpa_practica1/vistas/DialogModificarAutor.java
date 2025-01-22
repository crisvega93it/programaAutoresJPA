package com.mycompany.jpa_practica1.vistas;

import com.mycompany.jpa_practica1.controladores.AutorJpaController;
import com.mycompany.jpa_practica1.modelos.Autor;
import com.mycompany.jpa_practica1.modelos.Libro;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogModificarAutor extends javax.swing.JDialog {
    
    private int id;
    private AutorJpaController ajc;
    private EntityManagerFactory emf = null;

    public DialogModificarAutor(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        this.id = id;
        this.emf = Persistence.createEntityManagerFactory("miUnidad");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_modificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_nomAutor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jb_modificar.setText("Modificar Autor");
        jb_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modificarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre del autor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_nomAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jb_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_nomAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_modificar))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed

        try {
            String nomAutor = tf_nomAutor.getText();
            Autor autor = new Autor(nomAutor);
            autor.setIdAutor(id);
            ajc = new AutorJpaController(emf);
            Boolean respuesta = ajc.edit(autor);
            if (respuesta) {
                JOptionPane.showMessageDialog(this, "AUTOR MODIFICADO");
            } else {
                JOptionPane.showMessageDialog(this, "ERROR");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL RELLENAR CAMPOS");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jb_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JTextField tf_nomAutor;
    // End of variables declaration//GEN-END:variables
}
