package ui;

import da.Cola;
import da.DatosAlgoritmos;
import da.Lista;
import da.Pila;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Calendar;
import servicios.Conexion;
import servicios.Datos_Servicios;

/**
 *
 * @author Johan Herrera
 */
public class VentanaAlgoritmos extends javax.swing.JFrame {

    private final Datos_Servicios datos_servicio = new Datos_Servicios();
    private DatosAlgoritmos datos;

    /**
     * Creates new form VentanaAlgoritmos
     */
    public VentanaAlgoritmos() {
        initComponents();
        this.datos = new DatosAlgoritmos();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    public VentanaAlgoritmos(DatosAlgoritmos a_datos) {
        this.datos = a_datos;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BotonMergeSortSimple = new javax.swing.JButton();
        BotonMergeSortCircular = new javax.swing.JButton();
        BotonHeapSortPila = new javax.swing.JButton();
        BotonInsertionSortCola = new javax.swing.JButton();
        BotonBrickSortSimple = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        botonConsultar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        botonMovimientoNodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Algoritmos de Ordenamiento");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        BotonMergeSortSimple.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonMergeSortSimple.setText("MergeSort Simple");
        BotonMergeSortSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMergeSortSimpleActionPerformed(evt);
            }
        });

        BotonMergeSortCircular.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonMergeSortCircular.setText("MergeSort Circular");
        BotonMergeSortCircular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMergeSortCircularActionPerformed(evt);
            }
        });

        BotonHeapSortPila.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonHeapSortPila.setText("HeapSort Pila");
        BotonHeapSortPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonHeapSortPilaActionPerformed(evt);
            }
        });

        BotonInsertionSortCola.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonInsertionSortCola.setText("InsertionSort Cola");
        BotonInsertionSortCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonInsertionSortColaActionPerformed(evt);
            }
        });

        BotonBrickSortSimple.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        BotonBrickSortSimple.setText("BrickSort Simple");
        BotonBrickSortSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBrickSortSimpleActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Seleccione el Algoritmo que desea ejecutar:");

        botonConsultar.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        botonConsultar.setText("Consultar Datos ");
        botonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Consultar Historial:");

        botonSalir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonMovimientoNodos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        botonMovimientoNodos.setText("Movimiento Nodos");
        botonMovimientoNodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMovimientoNodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BotonMergeSortCircular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonMergeSortSimple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonHeapSortPila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonInsertionSortCola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonBrickSortSimple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(botonConsultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonMovimientoNodos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(726, 726, 726)
                        .addComponent(jLabel1)))
                .addContainerGap(444, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(BotonMergeSortSimple)
                .addGap(35, 35, 35)
                .addComponent(BotonMergeSortCircular)
                .addGap(35, 35, 35)
                .addComponent(BotonHeapSortPila)
                .addGap(35, 35, 35)
                .addComponent(BotonInsertionSortCola)
                .addGap(35, 35, 35)
                .addComponent(BotonBrickSortSimple)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addComponent(botonConsultar)
                .addGap(35, 35, 35)
                .addComponent(botonMovimientoNodos)
                .addGap(36, 36, 36)
                .addComponent(botonSalir)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    java.sql.Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());

    private void guardar() {
        try {
            this.datos_servicio.guardar(Conexion.obtener(), datos);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        }
    }

    private void BotonMergeSortSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMergeSortSimpleActionPerformed
        long tiempoInicioLS = System.nanoTime();
        Lista ls = new Lista();
        ls.add("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4); //Añade a la Lista
        ls.add("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        ls.add("Mariana", "Castilla", "Arias", "M123785", 20.9);
        ls.add("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        ls.add("Daniela", "Zepeda", "Ramirez", "P985321", 20.9);
        ls.add("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        ls.add("Rogel", "Herrera", "Bellido", "8-0083-0592", 45.5);
        ls.add("Angel", "Barrantes", "Chaves", "e770089", 18.7);
        ls.mergeSort(ls.getCabeza());
        ls.pasaportePrimero();
        long tiempoTotalLS = System.nanoTime() - tiempoInicioLS;
        datos = new DatosAlgoritmos(null, "MergeSort Simple", "Lista Simple", fecha, tiempoTotalLS);
        guardar();
        JOptionPane.showMessageDialog(this, "Se ejecuto el MergeSort Simple.");
    }//GEN-LAST:event_BotonMergeSortSimpleActionPerformed

    private void BotonMergeSortCircularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMergeSortCircularActionPerformed
        long tiempoInicioLC = System.nanoTime(); 
        Lista lc = new Lista();
        lc.addCircular("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4); //Añade a la Lista Circular
        lc.addCircular("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        lc.addCircular("Mariana", "Castilla", "Arias", "M123785", 20.9);
        lc.addCircular("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        lc.addCircular("Daniela", "Zepeda", "Ramirez", "P985321", 20.9);
        lc.addCircular("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        lc.addCircular("Rogel", "Herrera", "Bellido", "8-0083-0592", 45.5);
        lc.addCircular("Angel", "Barrantes", "Chaves", "e770089", 18.7);
        lc.mergeSortC(lc.getCabeza());
        long tiempoTotalLC = System.nanoTime() - tiempoInicioLC; 
        datos = new DatosAlgoritmos(null, "MergeSort Circular", "Lista Circular", fecha, tiempoTotalLC);
        guardar();        
        JOptionPane.showMessageDialog(this, "Se ejecuto el MergeSort Circular.");
    }//GEN-LAST:event_BotonMergeSortCircularActionPerformed

    private void BotonHeapSortPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonHeapSortPilaActionPerformed
        long tiempoInicioHS = System.nanoTime();
        Pila p = new Pila();
        p.push("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4); //Añade a la Pila
        p.push("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        p.push("Mariana", "Castilla", "Arias", "M123785", 20.9);
        p.push("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        p.push("Daniela", "Zepeda", "Ramirez", "P985321", 20.9);
        p.push("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        p.push("Rogel", "Herrera", "Bellido", "8-0083-0592", 45.5);
        p.push("Angel", "Barrantes", "Chaves", "e770089", 18.7);
        p.heapSort(p);
        long tiempoTotalHS = System.nanoTime() - tiempoInicioHS;
        datos = new DatosAlgoritmos(null, "HeapSort", "Pila", fecha, tiempoTotalHS);
        guardar();
        JOptionPane.showMessageDialog(this, "Se ejecuto el HeapSort.");
    }//GEN-LAST:event_BotonHeapSortPilaActionPerformed

    private void BotonInsertionSortColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonInsertionSortColaActionPerformed
        long tiempoInicioIS = System.nanoTime();
        Cola c = new Cola();
        c.queue("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4);   //Añade a la Cola
        c.queue("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        c.queue("Mariana", "Castilla", "Arias", "M123785", 20.9);
        c.queue("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        c.queue("Daniela", "Zepeda", "Ramirez", "P557905", 20.9);
        c.queue("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        c.queue("Rogel", "Herrera", "Bellido", "8-0083-0592", 41.5);
        c.queue("Angel", "Barrantes", "Chaves", "e770089", 18.7);
        c.insertionSort();
        long tiempoTotalIS = System.nanoTime() - tiempoInicioIS;
        datos = new DatosAlgoritmos(null, "InsertionSort", "Cola", fecha, tiempoTotalIS);
        guardar();
        JOptionPane.showMessageDialog(this, "Se ejecuto el InsertionSort.");
    }//GEN-LAST:event_BotonInsertionSortColaActionPerformed

    private void BotonBrickSortSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBrickSortSimpleActionPerformed
        long tiempoInicioBS = System.nanoTime();
        Lista bs = new Lista();
        bs.add("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4); //Añade a la Lista
        bs.add("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        bs.add("Mariana", "Castilla", "Arias", "M123785", 20.9);
        bs.add("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        bs.add("Daniela", "Zepeda", "Ramirez", "P985321", 20.9);
        bs.add("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        bs.add("Rogel", "Herrera", "Bellido", "8-0083-0592", 45.5);
        bs.add("Angel", "Barrantes", "Chaves", "e770089", 18.7);
        bs.brickSort(bs);
        long tiempoTotalBS = System.nanoTime() - tiempoInicioBS;
        datos = new DatosAlgoritmos(null, "BrickSort Simple", "Lista Simple", fecha, tiempoTotalBS);
        guardar();
        JOptionPane.showMessageDialog(this, "Se ejecuto el BrickSort Simple.");
    }//GEN-LAST:event_BotonBrickSortSimpleActionPerformed

    private void botonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarActionPerformed
        VentanaConsultar vCons = new VentanaConsultar();
        vCons.setVisible(true);
    }//GEN-LAST:event_botonConsultarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonMovimientoNodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMovimientoNodosActionPerformed
        MovimientoNodos venNodos = new MovimientoNodos();
        venNodos.setVisible(true);
    }//GEN-LAST:event_botonMovimientoNodosActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAlgoritmos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAlgoritmos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAlgoritmos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAlgoritmos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaAlgoritmos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBrickSortSimple;
    private javax.swing.JButton BotonHeapSortPila;
    private javax.swing.JButton BotonInsertionSortCola;
    private javax.swing.JButton BotonMergeSortCircular;
    private javax.swing.JButton BotonMergeSortSimple;
    private javax.swing.JButton botonConsultar;
    private javax.swing.JButton botonMovimientoNodos;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
