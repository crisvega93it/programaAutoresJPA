package com.mycompany.jpa_practica1.vistas;

import com.mycompany.jpa_practica1.controladores.ControladorBusquedas;
import com.mycompany.jpa_practica1.controladores.LibroJpaController;
import com.mycompany.jpa_practica1.modelos.Autor;
import com.mycompany.jpa_practica1.modelos.Libro;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VistaLibros extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private ControladorBusquedas cb;
    private LibroJpaController ljc;
    private int casillaSeleccionada;
    private int idLibro;
    private EntityManagerFactory emf;

    public VistaLibros() {
        initComponents();
        dtm = (DefaultTableModel) jt_libros.getModel();
        this.emf = emf = Persistence.createEntityManagerFactory("miUnidad");
        rellenarLibros();
        this.jt_libros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jt_libros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                casillaSeleccionada = jt_libros.getSelectedRow();
                if (casillaSeleccionada != -1) {
                    idLibro = Integer.parseInt(jt_libros.getValueAt(casillaSeleccionada, 0).toString());
                }
            }
        });
        rellenarcbo();
        rellenarcboAlta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt_libros = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        bt_alta = new javax.swing.JButton();
        bt_baja = new javax.swing.JButton();
        bt_mod = new javax.swing.JButton();
        cbo_autores = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jbFiltrar = new javax.swing.JButton();
        jbRefrescar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_nomLibro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbo_autoresAlta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tf_precio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jdc_fecha = new com.toedter.calendar.JDateChooser();
        tf_idAutor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jt_libros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idLibro", "Titulo"
            }
        ));
        jScrollPane1.setViewportView(jt_libros);
        if (jt_libros.getColumnModel().getColumnCount() > 0) {
            jt_libros.getColumnModel().getColumn(0).setMinWidth(0);
            jt_libros.getColumnModel().getColumn(0).setPreferredWidth(0);
            jt_libros.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jToolBar1.setRollover(true);

        bt_alta.setText("Alta");
        bt_alta.setFocusable(false);
        bt_alta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_alta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_altaActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_alta);

        bt_baja.setText("Baja");
        bt_baja.setFocusable(false);
        bt_baja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_baja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_bajaActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_baja);

        bt_mod.setText("Modificar");
        bt_mod.setFocusable(false);
        bt_mod.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_mod.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_modActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_mod);

        cbo_autores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Nuevo libro:");

        jbFiltrar.setText("FILTRAR");
        jbFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFiltrarActionPerformed(evt);
            }
        });

        jbRefrescar.setText("REFRESCAR");
        jbRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefrescarActionPerformed(evt);
            }
        });

        jLabel2.setText("AUTORES");

        jLabel3.setText("idAutor:");

        cbo_autoresAlta.setModel(new javax.swing.DefaultComboBoxModel<>());

        jLabel4.setText("Precio:");

        jLabel5.setText("Fecha:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("LIBROS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbo_autores, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbRefrescar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_nomLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jdc_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tf_idAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbo_autoresAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbFiltrar)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_autores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbRefrescar))
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tf_nomLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbo_autoresAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_idAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jdc_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFiltrarActionPerformed
        String nomAutor = cbo_autores.getSelectedItem().toString();
        if (nomAutor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "SELECCIONA UN AUTOR");
        }
        dtm.setRowCount(0);
        if (cb == null) {
            cb = new ControladorBusquedas(emf);
        }
        List<Libro> libros = cb.librosByNomAutor(nomAutor);
        for (Libro libro : libros) {
            dtm.addRow(new Object[]{libro.getIdLibros(), libro.getTitulo()});
        }
    }//GEN-LAST:event_jbFiltrarActionPerformed

    private void jbRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefrescarActionPerformed
        this.rellenarLibros();
    }//GEN-LAST:event_jbRefrescarActionPerformed

    private void bt_altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_altaActionPerformed
        try {
            String nomLibro = tf_nomLibro.getText();
            Double precio = Double.valueOf(tf_precio.getText());
            Calendar cal = jdc_fecha.getCalendar();
            int idAutor = Integer.parseInt(tf_idAutor.getText().toString());
            if (nomLibro.isEmpty()) {
                JOptionPane.showMessageDialog(this, "RELLLENA EL NOMBRE");
                return;
            }
            if (ljc == null) {
                ljc = new LibroJpaController(emf);
            }
            Libro libro = new Libro();
            libro.setTitulo(nomLibro);
            libro.setPrecio(precio);
            libro.setFechaPublicacion(cal);
            Autor autor = new Autor(idAutor);
            libro.setAutor(autor);
            Boolean respuesta = ljc.create(libro);
            if (respuesta) {
                JOptionPane.showMessageDialog(this, "LIBRO CREADO");
                this.rellenarLibros();
            } else {
                JOptionPane.showMessageDialog(this, "ERROR");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "PARÁMETROS MAL RELLENADOS");
        }
    }//GEN-LAST:event_bt_altaActionPerformed

    private void bt_bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_bajaActionPerformed
        if (idLibro <= 0) {
            JOptionPane.showMessageDialog(this, "SELECCIONA UN LIBRO");
            return;
        }
        if (ljc == null) {
            ljc = new LibroJpaController(emf);
        }
        Boolean respuesta = ljc.destroy(idLibro);
        if(respuesta){
            JOptionPane.showMessageDialog(this, "LIBRO BORRADO");
            this.rellenarLibros();
        }else{
            JOptionPane.showMessageDialog(this, "ERROR");
        }
    }//GEN-LAST:event_bt_bajaActionPerformed

    private void bt_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_modActionPerformed
        if(idLibro <= 0){
            JOptionPane.showMessageDialog(this, "SELECCIONA UN LIBRO");
            return;
        }
        DialogModificarLibro dma = new DialogModificarLibro(this, rootPaneCheckingEnabled, idLibro);
        dma.setLocationRelativeTo(null);
        dma.setVisible(true);
    }//GEN-LAST:event_bt_modActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alta;
    private javax.swing.JButton bt_baja;
    private javax.swing.JButton bt_mod;
    private javax.swing.JComboBox<String> cbo_autores;
    private javax.swing.JComboBox<String> cbo_autoresAlta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbFiltrar;
    private javax.swing.JButton jbRefrescar;
    private com.toedter.calendar.JDateChooser jdc_fecha;
    private javax.swing.JTable jt_libros;
    private javax.swing.JTextField tf_idAutor;
    private javax.swing.JTextField tf_nomLibro;
    private javax.swing.JTextField tf_precio;
    // End of variables declaration//GEN-END:variables

    private void rellenarLibros() {
        dtm.setRowCount(0);
        if (cb == null) {
            cb = new ControladorBusquedas(emf);
        }
        List<Libro> libros = cb.allLibros();
        for (Libro libro : libros) {
            dtm.addRow(new Object[]{libro.getIdLibros(), libro.getTitulo()});
        }
    }

    private void rellenarcbo() {
        cbo_autores.removeAllItems();
        if (cb == null) {
            cb = new ControladorBusquedas(emf);
        }
        List<Autor> autores = cb.allAutores();
        Collections.sort(autores);
        for (Autor autor : autores) {
            cbo_autores.addItem(autor.getNomAutor());
        }
    }

    private void rellenarcboAlta() {
        cbo_autoresAlta.removeAllItems();
        if (cb == null) {
            cb = new ControladorBusquedas(emf);
        }
        List<Autor> autores = cb.allAutores();
        Collections.sort(autores);
        for (Autor autor : autores) {
            cbo_autoresAlta.addItem(autor.toString());
        }
    }
}
