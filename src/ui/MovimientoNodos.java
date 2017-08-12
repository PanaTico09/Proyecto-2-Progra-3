package ui;

import java.awt.BorderLayout;

/**
 *
 * @author Johan Herrera
 */
public class MovimientoNodos extends javax.swing.JFrame {

    public static boolean terminarEjecutar = false; //Impide ejecutar otro hasta que no termine de ejecutar el actual.

    /**
     * Creates new form MovimientoNodos
     */
    public MovimientoNodos() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        PanelFondo p = new PanelFondo();
        this.add(p, BorderLayout.CENTER);
        p.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonMergeSort = new javax.swing.JButton();
        gifPanel = new ui.PanelGif();
        botonGenerar = new javax.swing.JButton();
        botonBrickSort = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        botonVolver.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(botonVolver);
        botonVolver.setBounds(160, 580, 140, 40);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Movimiento De Nodos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(840, 50, 280, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/imagenes/Pana Logo ChillTime_opt.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1780, 850, 130, 130);

        botonMergeSort.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonMergeSort.setText("MergeSort");
        botonMergeSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMergeSortActionPerformed(evt);
            }
        });
        getContentPane().add(botonMergeSort);
        botonMergeSort.setBounds(160, 500, 140, 40);

        gifPanel.setAlignmentX(1.0F);
        getContentPane().add(gifPanel);
        gifPanel.setBounds(770, 310, 410, 450);

        botonGenerar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonGenerar.setText("Generar");
        botonGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGenerar);
        botonGenerar.setBounds(160, 350, 140, 40);

        botonBrickSort.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonBrickSort.setText("BrickSort");
        botonBrickSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBrickSortActionPerformed(evt);
            }
        });
        getContentPane().add(botonBrickSort);
        botonBrickSort.setBounds(160, 420, 140, 40);

        botonSalir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir);
        botonSalir.setBounds(160, 660, 140, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonMergeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMergeSortActionPerformed
        if (!terminarEjecutar) {
            gifPanel.ordenarMerge();
        }
    }//GEN-LAST:event_botonMergeSortActionPerformed

    private void botonGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarActionPerformed
        if (!terminarEjecutar) {
            gifPanel.generar();
        }
    }//GEN-LAST:event_botonGenerarActionPerformed

    private void botonBrickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBrickSortActionPerformed
        if (!terminarEjecutar) {
            gifPanel.ordenarBrick();
        }
        
    }//GEN-LAST:event_botonBrickSortActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(MovimientoNodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimientoNodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimientoNodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimientoNodos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MovimientoNodos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBrickSort;
    private javax.swing.JButton botonGenerar;
    private javax.swing.JButton botonMergeSort;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonVolver;
    private ui.PanelGif gifPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
