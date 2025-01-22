package com.mycompany.jpa_practica1.vistas;

import com.mycompany.jpa_practica1.controladores.CategoriaJpaController;
import com.mycompany.jpa_practica1.controladores.ControladorBusquedas;
import com.mycompany.jpa_practica1.modelos.Categoria;
import com.mycompany.jpa_practica1.modelos.Libro;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VistaCategorias extends javax.swing.JFrame {

    private DefaultTableModel dtm_cat;
    private DefaultTableModel dtm_libros;
    private ControladorBusquedas controladorBusquedas;
    private CategoriaJpaController cjc;
    private EntityManagerFactory emf;
    private int casillaSeleccionada;
    private int idCategoria;
    private Boolean respuesta;

    public VistaCategorias() {
        initComponents();
        emf = Persistence.createEntityManagerFactory("miUnidad");
        controladorBusquedas = new ControladorBusquedas(emf);
        dtm_cat = (DefaultTableModel) this.jtable_cat.getModel();
        dtm_libros = (DefaultTableModel) this.jtable_libros.getModel();
        rellenarTableCat();

        jtable_cat.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                casillaSeleccionada = jtable_cat.getSelectedRow();
                if (casillaSeleccionada != -1) {
                    idCategoria = Integer.parseInt(jtable_cat.getValueAt(casillaSeleccionada, 0).toString());
                    rellenarTableLibros();
                }
            }
        });
        this.jtable_cat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_cat = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable_libros = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        jbalta = new javax.swing.JButton();
        jbBaja = new javax.swing.JButton();
        jbMod = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf_categoria = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtable_cat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idCategoria", "Categorías"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtable_cat);
        if (jtable_cat.getColumnModel().getColumnCount() > 0) {
            jtable_cat.getColumnModel().getColumn(0).setMinWidth(0);
            jtable_cat.getColumnModel().getColumn(0).setPreferredWidth(0);
            jtable_cat.getColumnModel().getColumn(0).setMaxWidth(0);
            jtable_cat.getColumnModel().getColumn(1).setResizable(false);
        }

        jtable_libros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idLibro", "Titulo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtable_libros);
        if (jtable_libros.getColumnModel().getColumnCount() > 0) {
            jtable_libros.getColumnModel().getColumn(0).setResizable(false);
            jtable_libros.getColumnModel().getColumn(1).setResizable(false);
        }

        jToolBar3.setRollover(true);

        jbalta.setText("ALTA");
        jbalta.setFocusable(false);
        jbalta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbalta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbaltaActionPerformed(evt);
            }
        });
        jToolBar3.add(jbalta);

        jbBaja.setText("BAJA");
        jbBaja.setFocusable(false);
        jbBaja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbBaja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBajaActionPerformed(evt);
            }
        });
        jToolBar3.add(jbBaja);

        jbMod.setText("MODIFICAR");
        jbMod.setFocusable(false);
        jbMod.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbMod.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModActionPerformed(evt);
            }
        });
        jToolBar3.add(jbMod);

        jLabel1.setText("Nueva categoría:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbaltaActionPerformed
        String categoria = this.tf_categoria.getText();
        if (categoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ESCRIBE UNA CATEGORIA");
            return;
        }
        if (this.cjc == null) {
            this.cjc = new CategoriaJpaController(emf);
        }
        Categoria cat = new Categoria(categoria);
        respuesta = cjc.create(cat);
        if (respuesta) {
            JOptionPane.showMessageDialog(this, "CATEGORIA CREADA");
            rellenarTableCat();
        } else {
            JOptionPane.showMessageDialog(this, "ERROR");
        }
    }//GEN-LAST:event_jbaltaActionPerformed

    private void jbBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaActionPerformed
        if (this.cjc == null) {
            this.cjc = new CategoriaJpaController(emf);
        }
        respuesta = cjc.destroy(idCategoria);
        if (respuesta) {
            JOptionPane.showMessageDialog(this, "CATEGORIA BORRADA");
            rellenarTableCat();
        } else {
            JOptionPane.showMessageDialog(this, "NO SE PUEDE BORRAR CATEGORÍAS CON LIBROS ASIGNADOS");
        }
    }//GEN-LAST:event_jbBajaActionPerformed

    private void jbModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModActionPerformed
        String categoria = this.tf_categoria.getText();
        if (categoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ESCRIBE UNA CATEGORIA");
            return;
        }else if(idCategoria <= 0){
            JOptionPane.showMessageDialog(this, "SELECCIONA UNA CATEGORIA");
            return;
        }
        if (this.cjc == null) {
            this.cjc = new CategoriaJpaController(emf);
        }
        Categoria cat = new Categoria(idCategoria,categoria);
        respuesta = cjc.edit(cat);
        if (respuesta) {
            JOptionPane.showMessageDialog(this, "CATEGORIA MODIFICADA");
            rellenarTableCat();
        } else {
            JOptionPane.showMessageDialog(this, "ERROR");
        }
    }//GEN-LAST:event_jbModActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JButton jbBaja;
    private javax.swing.JButton jbMod;
    private javax.swing.JButton jb_alta;
    private javax.swing.JButton jb_alta1;
    private javax.swing.JButton jbalta;
    private javax.swing.JTable jtable_cat;
    private javax.swing.JTable jtable_libros;
    private javax.swing.JTextField tf_categoria;
    // End of variables declaration//GEN-END:variables

    private void rellenarTableCat() {
        dtm_cat.setRowCount(0);
        List<Categoria> categorias = controladorBusquedas.allCategorias();
        for (Categoria cat : categorias) {
            dtm_cat.addRow(new Object[]{cat.getIdCategoria(), cat.getNomCategoria()});
        }
    }

    private void rellenarTableLibros() {
        dtm_libros.setRowCount(0);
        Categoria categoria = controladorBusquedas.encontrarLibros(idCategoria);
        List<Libro> libros = (List<Libro>) categoria.getLibroCollection();
        for (Libro libro : libros) {
            dtm_libros.addRow(new Object[]{libro.getIdLibros(), libro.getTitulo()});
        }
    }
}
