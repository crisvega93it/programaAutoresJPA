package com.mycompany.jpa_practica1.vistas;

import com.mycompany.jpa_practica1.controladores.AutorJpaController;
import com.mycompany.jpa_practica1.controladores.CategoriaJpaController;
import com.mycompany.jpa_practica1.controladores.ControladorBusquedas;
import com.mycompany.jpa_practica1.controladores.LibroJpaController;
import com.mycompany.jpa_practica1.modelos.Autor;
import com.mycompany.jpa_practica1.modelos.Categoria;
import com.mycompany.jpa_practica1.modelos.Libro;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DialogAltaAutor extends javax.swing.JDialog {

    private DefaultTableModel dtm;
    private AutorJpaController ajc;
    private EntityManagerFactory emf = null;
    private ArrayList<Libro> listaLibros;
    private ControladorBusquedas cb;
    private DefaultTableModel dtm_cat;
    private VistaAutores va;

    public DialogAltaAutor(java.awt.Frame parent, boolean modal, VistaAutores va) {
        super(parent, modal);
        initComponents();
        this.emf = Persistence.createEntityManagerFactory("miUnidad");
        this.dtm = (DefaultTableModel) this.jtable_librosAñadidos.getModel();
        listaLibros = new ArrayList<Libro>();
        this.dtm_cat = (DefaultTableModel) this.jtable_catAdd.getModel();
        this.va = va;
        rellenarCBO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_nomAutor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable_librosAñadidos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_nomLibro = new javax.swing.JTextField();
        tf_precio = new javax.swing.JTextField();
        jb_addLibro = new javax.swing.JButton();
        tf_fecha = new com.toedter.calendar.JDateChooser();
        jb_modificar = new javax.swing.JButton();
        cbo_categorias = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable_catAdd = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre del autor:");

        jtable_librosAñadidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Precio", "Fecha de publciación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtable_librosAñadidos);
        if (jtable_librosAñadidos.getColumnModel().getColumnCount() > 0) {
            jtable_librosAñadidos.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Libro");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Precio:");

        jLabel5.setText("Fecha Publicación:");

        tf_nomLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nomLibroActionPerformed(evt);
            }
        });

        jb_addLibro.setText("Añadir Libro");
        jb_addLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_addLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_nomLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tf_precio, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(tf_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jb_addLibro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tf_nomLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jb_addLibro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jb_modificar.setText("Añadir Autor");
        jb_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modificarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Categorías");

        jtable_catAdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idCategorías", "Categorías"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtable_catAdd);
        if (jtable_catAdd.getColumnModel().getColumnCount() > 0) {
            jtable_catAdd.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton1.setText("Añadir Categoría");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbo_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tf_nomAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52)
                            .addComponent(jb_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_nomAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_modificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nomLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nomLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nomLibroActionPerformed

    private void jb_addLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_addLibroActionPerformed

        if (dtm_cat.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONA ALGUNA CATEGORÍA");
            return;
        }
        try {
            String nomLibro = tf_nomLibro.getText();
            Double precio = Double.valueOf(tf_precio.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = tf_fecha.getCalendar();
            String fecha = sdf.format(cal.getTime());
            Libro libro = new Libro(nomLibro, cal, precio);
            List<Categoria> listaCategorias = recogerCategoriasTable();
            libro.setCategoriaCollection(listaCategorias);
            listaLibros.add(libro);
            dtm.addRow(new Object[]{libro.getTitulo(), libro.getPrecio(), fecha});
            actulizar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR AL RELLENAR CAMPOS");
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jb_addLibroActionPerformed

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
        if(dtm.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "AÑADE ALGUN LIBRO");
            return;
        }
        try {
            String nomAutor = tf_nomAutor.getText();
            Autor autor = new Autor(nomAutor);
            autor.setLibroCollection(listaLibros);
            ajc = new AutorJpaController(emf);
            Boolean respuesta = ajc.create(autor);
            if (respuesta) {
                JOptionPane.showMessageDialog(this, "AUTOR CREADO");
                this.dtm.setRowCount(0);
                this.dtm.setRowCount(0);
                this.va.rellenarJTable();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "ERROR");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL RELLENAR CAMPOS");
            e.printStackTrace();
        }
    }//GEN-LAST:event_jb_modificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Categoria categoria = (Categoria) cbo_categorias.getSelectedItem();
        if (categoria == null) {
            JOptionPane.showMessageDialog(this, "SELECCIONA UNA CATEGORÍA");
        }
        dtm_cat.addRow(new Object[]{categoria.getIdCategoria(), categoria.getNomCategoria()});

        cbo_categorias.removeItem(categoria);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Categoria> cbo_categorias;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_addLibro;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JTable jtable_catAdd;
    private javax.swing.JTable jtable_librosAñadidos;
    private com.toedter.calendar.JDateChooser tf_fecha;
    private javax.swing.JTextField tf_nomAutor;
    private javax.swing.JTextField tf_nomLibro;
    private javax.swing.JTextField tf_precio;
    // End of variables declaration//GEN-END:variables

    private void rellenarCBO() {
        cbo_categorias.removeAllItems();
        if (this.cb == null) {
            this.cb = new ControladorBusquedas(emf);
        }
        List<Categoria> categorias = cb.allCategorias();

        for (Categoria cat : categorias) {
            cbo_categorias.addItem(cat);
        }

    }

    private List<Categoria> recogerCategoriasTable() {

        List<Categoria> categorias = new ArrayList<Categoria>();
        int numeroFilas = dtm_cat.getRowCount();
        for (int i = 0; i < numeroFilas; i++) {
            int id = Integer.parseInt(dtm_cat.getValueAt(i, 0).toString()); // Columna 0: ID
            String nombre = dtm_cat.getValueAt(i, 1).toString();            // Columna 1: Nombre
            Categoria categoria = new Categoria(id, nombre);
            categorias.add(categoria);
        }

        return categorias;
    }

    private void actulizar() {
        this.rellenarCBO();
        this.dtm_cat.setRowCount(0);
        tf_fecha.setToolTipText("");
        tf_nomLibro.setText("");
        tf_precio.setText("");
    }

}
