/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import da.BoxNumber;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author Johan Herrera
 */
public class PanelGif extends JPanel {

    private final int NUM_BOX = 8;
    private final Dimension dimension = new Dimension(320, 128);
    private final int max = 12;
    private final int min = 1;
    private BoxNumber[] bNumber;

    public PanelGif() {
        setSize(dimension);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        //pinta numeros y casillas
        if (bNumber != null) {
            for (BoxNumber b : bNumber) {
                b.draw(g2);
            }
        }
    }

    /**
     * Genera 5 numeros al azar y asigna a casillas posicion las casillas en el
     * panel
     */
    public void generar() {
        bNumber = new BoxNumber[NUM_BOX];
        Random rn = new Random();
        for (int i = 0; i < NUM_BOX; i++) {
            bNumber[i] = new BoxNumber();
            bNumber[i].x = 10 + bNumber[i].WIDTH * i;
            bNumber[i].y = getHeight() / 2 - bNumber[i].HEIGHT / 2;
            int num = rn.nextInt(max - min + 1) + min;
            bNumber[i].setNumber(String.valueOf(num));
        }
        repaint();
    }

    /**
     * Comando para ordenar el array de numeros con el metodo merge
     */
    public void ordenarMerge() {
        if (bNumber != null) {
            MovimientoNodos.terminarEjecutar = true;
            new MergeWorker().execute();//inicia worker
        }
    }

    /**
     * Comando para ordenar el array de numeros con el metodo brick
     */
    public void ordenarBrick() {
        if (bNumber != null) {
            MovimientoNodos.terminarEjecutar = true;
            new BrickWorker().execute();//inicia worker        
        }
    }

    public class BrickWorker extends SwingWorker<Void, Void> {

        private final int velocidad = 8; //velocidad de animacion (msegundos)  

        @Override
        protected Void doInBackground() throws Exception {
            int i, j;
            BoxNumber aux;
            int cont = 0;
            while (cont < bNumber.length - 1) {
                for (i = 0; i < bNumber.length / 2; i++) {
                    for (j = 0; j + 1 < bNumber.length; j += 2) {
                        if (bNumber[j].getValue() > bNumber[j + 1].getValue()) {

                            aux = bNumber[j];
                            girar(j, j + 1);
                            bNumber[j] = bNumber[j + 1];
                            bNumber[j + 1] = aux;
                        }
                    }
                    for (j = 1; j + 1 < bNumber.length; j += 2) {
                        if (bNumber[j].getValue() > bNumber[j + 1].getValue()) {
                            aux = bNumber[j];
                            girar(j, j + 1);
                            bNumber[j] = bNumber[j + 1];
                            bNumber[j + 1] = aux;
                        }
                    }
                }
                cont++;
            }
            JOptionPane.showMessageDialog(null, "El arreglo ha sido ordenado correctamente.");
            MovimientoNodos.terminarEjecutar = false;
            return null;
        }

        private void girar(int a, int b) {
            //Movimiento vertical
            for (int i = 0; i < bNumber[0].HEIGHT; i++) {
                bNumber[a].y -= 1;
                bNumber[b].y += 1;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }

            //Movimiento horizontal
            for (int i = 0; i < bNumber[0].WIDTH; i++) {
                bNumber[a].x += 1;
                bNumber[b].x -= 1;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }

            //movimiento vertical
            for (int i = 0; i < bNumber[0].HEIGHT; i++) {
                bNumber[a].y += 1;
                bNumber[b].y -= 1;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }
        }
    }

    public class MergeWorker extends SwingWorker<Void, Void> { //Aun no funciona como Merge

        private final int velocidad = 8; //velocidad de animacion (milisegundos)  
        public boolean completado = false;

        @Override
        protected Void doInBackground() throws Exception {
            merges(bNumber);
            
            JOptionPane.showMessageDialog(null, "El arreglo ha sido ordenado correctamente.");
            MovimientoNodos.terminarEjecutar = false;
            return null;
        }

        private void merges(BoxNumber[] a) {
            BoxNumber[] aux = new BoxNumber[a.length];
            mergeSort(a, aux, 0, a.length - 1);

        }

        private void mergeSort(BoxNumber[] a, BoxNumber[] aux, int left, int right) {
            if (left < right) {
                int center = (left + right) / 2;
                separar(center);
//                JOptionPane.showMessageDialog(null, "");
                mergeSort(a, aux, left, center);
                
                mergeSort(a, aux, center + 1, right);
                merge(a, aux, left, center + 1, right);
            }
        }

        private void merge(BoxNumber[] a, BoxNumber[] tmp, int left, int right, int rightEnd) {
            int leftEnd = right - 1;
            int k = left;
            int num = rightEnd - left + 1;

            while (left <= leftEnd && right <= rightEnd) {
                if (a[left].getValue() <= a[right].getValue()) {
                    tmp[k++] = a[left++];

                } else {
                    tmp[k++] = a[right++];
                }
            }

            while (left <= leftEnd) // Copy rest of first half
            {
                tmp[k++] = a[left++];
            }

            while (right <= rightEnd) // Copy rest of right half
            {
                tmp[k++] = a[right++];
            }

            // Copy tmp back
            for (int i = 0; i < num; i++, rightEnd--) {
                a[rightEnd] = tmp[rightEnd];

            }
        }

        private void separar(int mitad) {
            int cantCajas = mitad;
            while (cantCajas >= 0) {
                for (int i = 0; i < bNumber[0].HEIGHT; i++) {
                    bNumber[cantCajas].y += 1;
                    try {
                        Thread.sleep(velocidad);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                cantCajas--;
            }
        }

        private void unir() {
            int a = 0;
            for (int i = 0; i < bNumber[0].HEIGHT; i++) {
                bNumber[a].y -= 1;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }
            if (bNumber[a].getValue() > bNumber[a + 1].getValue()) {
                girar(a, a + 1);
            }
        }

        private void girar(int a, int b) {
//            Movimiento Vertical
            for (int i = 0; i < bNumber[0].HEIGHT; i++) {
                bNumber[a].y -= 1;
                bNumber[b].y += 1;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }

            //Movimiento horizontal
            for (int i = 0; i < bNumber[0].WIDTH; i++) {
                bNumber[a].x += 1;
                bNumber[b].x -= 1;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }

            //movimiento vertical
            for (int i = 0; i < bNumber[0].HEIGHT; i++) {
                bNumber[a].y += 1;
                bNumber[b].y -= 1;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }
        }
    }
}
