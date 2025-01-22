package com.mycompany.jpa_practica1.vistas;

import javax.swing.JFrame;

public class VistaPrincipal extends javax.swing.JFrame {
    
    private VistaAutores va;
    private VistaCategorias vc;
    private VistaLibros vl;

    public VistaPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jb_autores = new javax.swing.JButton();
        jb_categorias = new javax.swing.JButton();
        jb_libros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        jb_autores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jb_autores.setText("Autores");
        jb_autores.setFocusable(false);
        jb_autores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_autores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_autores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_autoresActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_autores);

        jb_categorias.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jb_categorias.setText("Categorías");
        jb_categorias.setFocusable(false);
        jb_categorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_categorias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_categoriasActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_categorias);

        jb_libros.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jb_libros.setText("Libros");
        jb_libros.setFocusable(false);
        jb_libros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_libros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_libros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_librosActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_libros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 488, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_autoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_autoresActionPerformed
        va = new VistaAutores();
            va.setLocationRelativeTo(null);
            va.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            va.setVisible(true); 
    }//GEN-LAST:event_jb_autoresActionPerformed

    private void jb_categoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_categoriasActionPerformed
        vc = new VistaCategorias();
        vc.setLocationRelativeTo(null);
        vc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vc.setVisible(true);
    }//GEN-LAST:event_jb_categoriasActionPerformed

    private void jb_librosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_librosActionPerformed
        vl = new VistaLibros();
        vl.setLocationRelativeTo(null);
        vl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vl.setVisible(true);
    }//GEN-LAST:event_jb_librosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jb_autores;
    private javax.swing.JButton jb_categorias;
    private javax.swing.JButton jb_libros;
    // End of variables declaration//GEN-END:variables
}
