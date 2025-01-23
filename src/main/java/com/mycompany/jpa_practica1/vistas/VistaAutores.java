package com.mycompany.jpa_practica1.vistas;

import com.mycompany.jpa_practica1.controladores.ControladorBusquedas;
import com.mycompany.jpa_practica1.controladores.LibroJpaController;
import com.mycompany.jpa_practica1.modelos.Autor;
import com.mycompany.jpa_practica1.modelos.Autor;
import com.mycompany.jpa_practica1.modelos.Categoria;
import com.mycompany.jpa_practica1.modelos.Categoria;
import com.mycompany.jpa_practica1.modelos.Libro;
import com.mycompany.jpa_practica1.modelos.Libro;
import com.mycompany.jpa_practica1.vistas.DialogAltaAutor;
import com.mycompany.jpa_practica1.vistas.DialogBajaAutor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VistaAutores extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private DefaultTableModel dtm_libros;
    private DefaultTableModel dtm_categorias;
    private int casillaSeleccioanda;
    private int casillaLibro;
    private Libro libroSeleccionado;
    private int idLibro;
    private int idSeleccionado;
    private LibroJpaController ljc;
    private ControladorBusquedas controladorBusquedas;
    private EntityManagerFactory emf;

    public VistaAutores() {
        initComponents();
        emf = Persistence.createEntityManagerFactory("miUnidad");
        controladorBusquedas = new ControladorBusquedas(emf);
        this.dtm = (DefaultTableModel) this.jTable_autores1.getModel();
        this.dtm_libros = (DefaultTableModel) this.jTable_libros.getModel();
        this.dtm_categorias = (DefaultTableModel) this.jTable_categorias.getModel();

        this.jTable_autores1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.jTable_libros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.jTable_autores1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                casillaSeleccioanda = jTable_autores1.getSelectedRow();
                if (casillaSeleccioanda != -1) {
                    idSeleccionado = Integer.parseInt(jTable_autores1.getValueAt(jTable_autores1.getSelectedRow(), 0).toString());
                    rellenarTableLibros();
                }
            }

        });

        this.jTable_libros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                casillaLibro = jTable_libros.getSelectedRow();
                if (casillaLibro != -1) {
                    if (ljc == null) {
                        ljc = new LibroJpaController();
                    }
                    idLibro = Integer.parseInt(jTable_libros.getValueAt(casillaLibro, 0).toString());
                    libroSeleccionado = ljc.findLibro(idLibro);
                    rellenarTableCategorias();
                }
            }

        });

        rellenarJTable();
        rellenarTableLibros();
        rellenarCBOCategorias();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_libros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jCB_categorias = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_autores1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_categorias = new javax.swing.JTable();
        jButton_filtrar = new javax.swing.JButton();
        jButton_refrescar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jb_alta = new javax.swing.JButton();
        jb_baja = new javax.swing.JButton();
        jb_modificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_buscarAutor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTable_libros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idLibro", "Titulo", "Fecha Publicación", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_libros.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable_libros);
        jTable_libros.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable_libros.getColumnModel().getColumnCount() > 0) {
            jTable_libros.getColumnModel().getColumn(0).setMinWidth(0);
            jTable_libros.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable_libros.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable_libros.getColumnModel().getColumn(1).setResizable(false);
            jTable_libros.getColumnModel().getColumn(2).setResizable(false);
            jTable_libros.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("Autores con libros de la categoría:");

        jCB_categorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCB_categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_categoriasActionPerformed(evt);
            }
        });

        jTable_autores1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idAutor", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_autores1.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable_autores1);
        jTable_autores1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable_autores1.getColumnModel().getColumnCount() > 0) {
            jTable_autores1.getColumnModel().getColumn(0).setResizable(false);
            jTable_autores1.getColumnModel().getColumn(1).setResizable(false);
        }

        jTable_categorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable_categorias);
        jTable_categorias.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable_categorias.getColumnModel().getColumnCount() > 0) {
            jTable_categorias.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton_filtrar.setText("FILTRAR");
        jButton_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_filtrarActionPerformed(evt);
            }
        });

        jButton_refrescar.setText("REFRESCAR");
        jButton_refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refrescarActionPerformed(evt);
            }
        });

        jToolBar1.setRollover(true);

        jb_alta.setText("Alta");
        jb_alta.setFocusable(false);
        jb_alta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_alta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_altaActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_alta);

        jb_baja.setText("Baja");
        jb_baja.setFocusable(false);
        jb_baja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_baja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_bajaActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_baja);

        jb_modificar.setText("Modificar");
        jb_modificar.setFocusable(false);
        jb_modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jb_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_modificarActionPerformed(evt);
            }
        });
        jToolBar1.add(jb_modificar);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("AUTORES CON LIBROS");

        jLabel3.setText("BUSCAR AUTOR");

        jButton1.setText("BUSCAR");
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
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCB_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_buscarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton_refrescar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(170, 170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jCB_categorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_filtrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_refrescar)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_buscarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCB_categoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_categoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCB_categoriasActionPerformed

    private void jButton_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_filtrarActionPerformed
        rellenarJtableAutores(this.jCB_categorias.getSelectedItem().toString());
    }//GEN-LAST:event_jButton_filtrarActionPerformed

    private void jButton_refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refrescarActionPerformed
        this.rellenarJTable();
    }//GEN-LAST:event_jButton_refrescarActionPerformed

    private void jb_altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_altaActionPerformed
        DialogAltaAutor daa = new DialogAltaAutor(this, rootPaneCheckingEnabled, this);
        daa.setLocationRelativeTo(null);
        daa.setVisible(true);
    }//GEN-LAST:event_jb_altaActionPerformed

    private void jb_bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_bajaActionPerformed
        DialogBajaAutor dba = new DialogBajaAutor(this, rootPaneCheckingEnabled);
        dba.setLocationRelativeTo(null);
        dba.setVisible(true);
    }//GEN-LAST:event_jb_bajaActionPerformed

    private void jb_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_modificarActionPerformed
        if(idSeleccionado <= 0){
            JOptionPane.showMessageDialog(this, "SELECCIONA UN AUTOR");
            return;
        }
        DialogModificarAutor dma = new DialogModificarAutor(this, rootPaneCheckingEnabled,idSeleccionado);
        dma.setLocationRelativeTo(null);
        dma.setVisible(true);
    }//GEN-LAST:event_jb_modificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nom = tf_buscarAutor.getText();
        if(nom.isEmpty()){
            JOptionPane.showMessageDialog(this, "ESCRIBE UN NOMBRE");
            return;
        }
        rellenarTablePorNombre(nom);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_filtrar;
    private javax.swing.JButton jButton_refrescar;
    private javax.swing.JComboBox<String> jCB_categorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_autores1;
    private javax.swing.JTable jTable_categorias;
    private javax.swing.JTable jTable_libros;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jb_alta;
    private javax.swing.JButton jb_baja;
    private javax.swing.JButton jb_modificar;
    private javax.swing.JTextField tf_buscarAutor;
    // End of variables declaration//GEN-END:variables

    public void rellenarJTable() {

        dtm.setRowCount(0);
        List<Autor> autores = controladorBusquedas.allAutores();
        Collections.sort(autores);

        for (Autor autor : autores) {
            dtm.addRow(new Object[]{autor.getIdAutor(), autor.getNomAutor()});
        }

    }

    private void rellenarTableLibros() {

        if (dtm_libros.getRowCount() != 0) {
            dtm_libros.setRowCount(0);
        }
        List<Libro> libros = controladorBusquedas.librosByAutor(idSeleccionado);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Libro libro : libros) {
            libro.toString();
            Calendar cal = libro.getFechaPublicacion();
            String fecha = sdf.format(cal.getTime());
            dtm_libros.addRow(new Object[]{libro.getIdLibros(), libro.getTitulo(), fecha, libro.getPrecio()});
        }

    }

    private void rellenarCBOCategorias() {
        this.jCB_categorias.removeAllItems();

        List<Categoria> categorias = controladorBusquedas.allCategorias();

        for (Categoria cat : categorias) {
            jCB_categorias.addItem(cat.getNomCategoria());
        }
    }

    private void rellenarTableCategorias() {
        dtm_categorias.setRowCount(0);
        List<Categoria> categorias = (List) libroSeleccionado.getCategoriaCollection();
        for (Categoria cat : categorias) {
            dtm_categorias.addRow(new Object[]{cat.getNomCategoria()});
        }
    }

    private void rellenarJtableAutores(String categoria) {
        dtm.setRowCount(0);
        List<Autor> autores = controladorBusquedas.autoresByCategoria(categoria);
        Collections.sort(autores);

        for (Autor autor : autores) {
            dtm.addRow(new Object[]{autor.getIdAutor(), autor.getNomAutor()});
        }
    }

    private void rellenarTablePorNombre(String nom) {
        dtm.setRowCount(0);
        if(controladorBusquedas == null){
            controladorBusquedas = new ControladorBusquedas(emf);
        }
        List<Autor> autores = controladorBusquedas.buscarPorNombre(nom);
        Collections.sort(autores);

        for (Autor autor : autores) {
            dtm.addRow(new Object[]{autor.getIdAutor(), autor.getNomAutor()});
        }
    }

}
