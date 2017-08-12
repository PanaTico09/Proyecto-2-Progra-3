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

    private final int NUM_BOX = 6;
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
     * <h1>Generar</h1>
     * <p>
     * Genera numeros al azar y asigna la posicion a las casillas en el
     * panel.</p>
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
     * <h1>OrdenarMerge</h1>
     * <p>
     * Comando para ordenar el array de numeros con el metodo merge</p>
     */
    public void ordenarMerge() {
        if (bNumber != null) {
            MovimientoNodos.terminarEjecutar = true;
            new MergeWorker().execute();//inicia worker
        }
    }

    /**
     * <h1>OrdenarBrick</h1>
     * <p>
     * Comando para ordenar el array de numeros con el metodo brick</p>
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

            //Movimiento vertical
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

    public class MergeWorker extends SwingWorker<Void, Void> { //Solo separa la lista (ACTUALMENTE)

        private final int velocidad = 8; //velocidad de animacion (milisegundos)  
        public boolean completado = false;

        @Override
        protected Void doInBackground() throws Exception {
            animar();
            JOptionPane.showMessageDialog(null, "El arreglo ha sido ordenado correctamente.");
            MovimientoNodos.terminarEjecutar = false;
            return null;
        }

        /**
         * <h1>Animar</h1>
         * <p>
         * Reproduce la animacion del Mergesort</p>
         */
        private void animar() {
            merge();
            mergeSort();
        }

        /**
         * <h1>Merge</h1>
         * <p>
         * Divide los rectangulos hasta que queden solos</p>
         */
        private void merge() {
            int cantCajas = bNumber.length - 1;
            int mitad = cantCajas / 2;
            while (cantCajas >= 0) {
                while (mitad >= 0) {
                    for (int i = 0; i < bNumber[0].HEIGHT; i++) {
                        bNumber[mitad].y += 1;
                        try {
                            Thread.sleep(velocidad);
                        } catch (InterruptedException e) {
                        }
                        repaint();
                    }
                    mitad--;
                }
                cantCajas--;
                mitad = cantCajas / 2;
            }

            cantCajas = bNumber.length - 1;
            mitad = cantCajas / 2 + 1;
            int cont = mitad - 1;
            int j = 1;
            while (cont <= cantCajas) {
                while (mitad <= cantCajas) {
                    for (int i = 0; i < bNumber[mitad].HEIGHT; i++) {
                        bNumber[mitad].y -= 2;
                        try {
                            Thread.sleep(velocidad * 2);
                        } catch (InterruptedException e) {
                        }
                        repaint();
                    }
                    mitad++;
                }
                cont++;
                j++;
                mitad = cantCajas / 2 + j;
            }
        }

        /**
         * <h1>MergeSort</h1>
         * <p>
         * Une y ordena los rectangulos.</p>
         */
        private void mergeSort() {
            int a = 0;
            mergeP1(a);
            a += 2;
            mergeP2(a);
            a += 2;
            mergeP3(a);
            a = 0;
            mergeP4(a);
            a = 0;
            mergeP5(a);
        }

        private void mergeP1(int a) {
            movY(a);
            if (bNumber[a].getValue() > bNumber[a + 1].getValue()) {
                movY(a + 1);
                BoxNumber aux = bNumber[a];
                for (int i = 0; i < bNumber[0].HEIGHT; i++) {
                    bNumber[a].y -= 1;
                    bNumber[a + 1].y += 1;
                    try {
                        Thread.sleep(velocidad);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                for (int i = 0; i < bNumber[0].WIDTH; i++) {
                    bNumber[a].x += 1;
                    bNumber[a + 1].x -= 1;

                    try {
                        Thread.sleep(velocidad);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                bNumber[a] = bNumber[a + 1];
                bNumber[a + 1] = aux;
            } else {
                movY(a);
            }
        }

        private void mergeP2(int a) {
            if (bNumber[a].getValue() > bNumber[a + 1].getValue()) {
                BoxNumber aux = bNumber[a];
                primerMovXY(a);
                for (int i = 0; i < bNumber[a].HEIGHT; i++) {
                    bNumber[a + 1].y += 1;
                    bNumber[a].y += 1;
                    try {
                        Thread.sleep(velocidad * 2);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                bNumber[a] = bNumber[a + 1];
                bNumber[a + 1] = aux;
            } else {
                for (int i = 0; i < bNumber[a].HEIGHT; i++) {
                    bNumber[a].y -= 1;
                    bNumber[a + 1].y += 3;
                    try {
                        Thread.sleep(velocidad * 2);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
            }
        }

        private void mergeP3(int a) {
            if (bNumber[a].getValue() > bNumber[a + 1].getValue()) {
                BoxNumber aux = bNumber[a];
                primerMovXY(a);
                for (int i = 0; i < bNumber[a].HEIGHT; i++) {
                    bNumber[a + 1].y += 2;
                    bNumber[a].y += 4;
                    try {
                        Thread.sleep(velocidad * 2);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                bNumber[a] = bNumber[a + 1];
                bNumber[a + 1] = aux;
            } else {
                for (int i = 0; i < bNumber[a].HEIGHT; i++) {
                    bNumber[a + 1].y += 4;
                    bNumber[a].y += 2;
                    try {
                        Thread.sleep(velocidad * 2);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
            }
        }

        private void mergeP4(int a) {
            mov2Y(a);
            if (bNumber[a].getValue() > bNumber[a + 2].getValue()) {
                BoxNumber aux = bNumber[a];
                girar(a, a + 2);
                movX(a, a + 2, 2);
                bNumber[a] = bNumber[a + 2];
                bNumber[a + 2] = aux;
            }
            if (bNumber[a + 1].getValue() > bNumber[a + 2].getValue()) {
                BoxNumber aux = bNumber[a + 1];
                girar(a + 1, a + 2);
                movX(a + 1, a + 2, 1);
                bNumber[a + 1] = bNumber[a + 2];
                bNumber[a + 2] = aux;
            }
            if (bNumber[a + 2].getValue() > bNumber[a + 3].getValue()) {
                BoxNumber aux = bNumber[a + 2];
                girar(a + 2, a + 3);
                movX(a + 2, a + 3, 1);
                bNumber[a + 2] = bNumber[a + 3];
                bNumber[a + 3] = aux;
            }
            if (bNumber[a + 1].getValue() > bNumber[a + 2].getValue()) {
                BoxNumber aux = bNumber[a + 1];
                girar(a + 1, a + 2);
                movX(a + 1, a + 2, 1);
                bNumber[a + 1] = bNumber[a + 2];
                bNumber[a + 2] = aux;
            }
        }

        private void mergeP5(int a) {
            mov4Y(a);
            
        }

        private void movY(int a) {
            for (int i = 0; i < bNumber[a].HEIGHT; i++) {
                bNumber[a].y -= 1;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }
        }

        private void mov2Y(int a) {
            int cont = 0;
            while (cont < 3) {
                for (int i = 0; i < bNumber[a].HEIGHT; i++) {
                    bNumber[a].y -= 1;
                    bNumber[a + 1].y -= 1;
                    try {
                        Thread.sleep(velocidad);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                cont++;
            }
        }

        private void mov4Y(int a) {
            for (int i = 0; i < bNumber[a].HEIGHT; i++) {
                bNumber[a].y -= 1;
                bNumber[a + 1].y -= 1;
                bNumber[a + 2].y -= 1;
                bNumber[a + 3].y -= 1;
                bNumber[a + 4].y += 2;
                bNumber[a + 5].y += 2;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }
        }

        private void primerMovXY(int a) {
            for (int i = 0; i < bNumber[a].HEIGHT; i++) {
                bNumber[a + 1].y += 2;
                bNumber[a].y -= 2;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }
            for (int i = 0; i < bNumber[a].WIDTH; i++) {
                bNumber[a].x += 1;
                bNumber[a + 1].x -= 1;
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                }
                repaint();
            }
        }

        private void movX(int a, int b, int espacios) {
            //Movimiento horizontal
            for (int i = 0; i < bNumber[0].WIDTH; i++) {
                bNumber[a].x += espacios;
                bNumber[b].x -= espacios;
                try {
                    Thread.sleep(velocidad * 2);
                } catch (InterruptedException e) {
                }
                repaint();
            }
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

            //Movimiento vertical
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
