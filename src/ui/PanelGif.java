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
            //BrickSort
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
            JOptionPane.showMessageDialog(null, "El ordenamiento a finalizado correctamente.");
            MovimientoNodos.terminarEjecutar = false;
            return null;
        }

        /**
         * <h1>Girar</h1>
         * <p>
         * Gira los rectangulos para ubicarlos en la posicion debida.</p>
         *
         * @param a posicion en el array
         * @param b posicion en el array
         */
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

        @Override
        protected Void doInBackground() throws Exception {
            animar();
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
            int cont = 0;
            while (cont < bNumber.length - 1) {
                if (bNumber[cont].getValue() > bNumber[cont + 1].getValue()) {
                    JOptionPane.showMessageDialog(null, "No se ha ordenado correctamente.");
                }
                cont++;
                if (cont == bNumber.length - 1) {
                    JOptionPane.showMessageDialog(null, "El ordenamiento a finalizado correctamente.");
                }
            }
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
         * Ordenamiento por mezcla.</p>
         */
        private void mergeSort() {
            int a = 0;
            mergeP1(a);
            a += 2;
            mergeP2(a);
            a += 2;
            mergeP3(a);
            a = 0;
            mov2Y(a);
            mergeP4(a);
            a = 0;
            mov4Y(a);
            mergeP5(a);
        }

        /**
         * <h1>MergeP1<h1>
         * <p>
         * Merge parte 1.</p>
         *
         * @param a posicion en el array.
         */
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

        /**
         * <h1>MergeP2<h1>
         * <p>
         * Merge parte 2.</p>
         *
         * @param a posicion en el array.
         */
        private void mergeP2(int a) {
            if (bNumber[a].getValue() > bNumber[a + 1].getValue()) {
                BoxNumber aux = bNumber[a];
                movXY(a);
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

        /**
         * <h1>MergeP3<h1>
         * <p>
         * Merge parte 3.</p>
         *
         * @param a posicion en el array.
         */
        private void mergeP3(int a) {
            if (bNumber[a].getValue() > bNumber[a + 1].getValue()) {
                BoxNumber aux = bNumber[a];
                movXY(a);
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

        /**
         * <h1>MergeP4<h1>
         * <p>
         * Merge parte 4.</p>
         *
         * @param a posicion en el array.
         */
        private void mergeP4(int a) {
            if (bNumber[a + 2].getValue() <= bNumber[a].getValue() && bNumber[a + 3].getValue() <= bNumber[a].getValue()) { //Si la segunda sublista es menor a la primera sub lista
                BoxNumber aux = bNumber[a];
                BoxNumber aux2 = bNumber[a + 1];
                for (int i = 0; i < bNumber[0].WIDTH; i++) {
                    bNumber[a].x += 2;
                    bNumber[a + 1].x += 2;
                    bNumber[a + 2].x -= 2;
                    bNumber[a + 3].x -= 2;
                    try {
                        Thread.sleep(velocidad * 2);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                bNumber[a] = bNumber[a + 2];
                bNumber[a + 2] = aux;
                bNumber[a + 1] = bNumber[a + 3];
                bNumber[a + 3] = aux2;
            } else if (bNumber[a + 2].getValue() <= bNumber[a].getValue() && bNumber[a + 3].getValue() > bNumber[a + 1].getValue()) { //Primero seg sublista es menor a primero pri sub lista 
                BoxNumber aux = bNumber[a];                                                                                          //Y Segundo seg sublista es mayor a segundo pri sublista.   
                BoxNumber aux2 = bNumber[a + 1];
                for (int i = 0; i < bNumber[0].WIDTH; i++) {
                    bNumber[a].x += 1;
                    bNumber[a + 1].x += 1;
                    bNumber[a + 2].x -= 2;
                    try {
                        Thread.sleep(velocidad * 2);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                bNumber[a] = bNumber[a + 2];
                bNumber[a + 1] = aux;
                bNumber[a + 2] = aux2;
            } else if (bNumber[a + 2].getValue() >= bNumber[a].getValue() && bNumber[a + 3].getValue() < bNumber[a + 1].getValue()) { //Primero seg sublista mayor a primero pri sub lista
                BoxNumber aux = bNumber[a + 1];                                                                                      //Y Segundo seg sublista menor a segundo pri sub lista
                for (int i = 0; i < bNumber[0].WIDTH; i++) {
                    bNumber[a + 1].x += 2;
                    bNumber[a + 2].x -= 1;
                    bNumber[a + 3].x -= 1;
                    try {
                        Thread.sleep(velocidad * 2);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                bNumber[a + 1] = bNumber[a + 2];
                bNumber[a + 2] = bNumber[a + 3];
                bNumber[a + 3] = aux;
            } else if (bNumber[a + 2].getValue() < bNumber[a].getValue() && bNumber[a + 3].getValue() >= bNumber[a].getValue()) {
                BoxNumber aux = bNumber[a];
                BoxNumber aux2 = bNumber[a + 1];
                for (int i = 0; i < bNumber[0].WIDTH; i++) {
                    bNumber[a].x += 1;
                    bNumber[a + 1].x += 2;
                    bNumber[a + 2].x -= 2;
                    bNumber[a + 3].x -= 1;
                    try {
                        Thread.sleep(velocidad * 2);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                bNumber[a] = bNumber[a + 2];
                bNumber[a + 1] = aux;
                bNumber[a + 2] = bNumber[a + 3];
                bNumber[a + 3] = aux2;
            } else {
                ordenar(a, a + 2, 2);
                ordenar(a + 1, a + 2, 1);
                ordenar(a + 2, a + 3, 1);
                ordenar(a + 1, a + 2, 1);
            }
        }

        /**
         * <h1>MergeP5<h1>
         * <p>
         * Merge parte 5.</p>
         *
         * @param a posicion en el array.
         */
        private void mergeP5(int a) {
            if (bNumber[a + 4].getValue() <= bNumber[a].getValue() && bNumber[a + 5].getValue() <= bNumber[a].getValue()) {
                BoxNumber aux = bNumber[a];
                BoxNumber aux2 = bNumber[a + 1];
                BoxNumber aux3 = bNumber[a + 2];
                BoxNumber aux4 = bNumber[a + 3];
                for (int i = 0; i < bNumber[0].WIDTH; i++) {
                    bNumber[a].x += 2;
                    bNumber[a + 1].x += 2;
                    bNumber[a + 2].x += 2;
                    bNumber[a + 3].x += 2;
                    bNumber[a + 4].x -= 4;
                    bNumber[a + 5].x -= 4;
                    try {
                        Thread.sleep(velocidad * 2);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                bNumber[a] = bNumber[a + 4];
                bNumber[a + 1] = bNumber[a + 5];
                bNumber[a + 2] = aux;
                bNumber[a + 3] = aux2;
                bNumber[a + 4] = aux3;
                bNumber[a + 5] = aux4;
            } else if (bNumber[a + 4].getValue() <= bNumber[a].getValue() && bNumber[a + 5].getValue() > bNumber[a + 3].getValue()) {
                BoxNumber aux = bNumber[a];
                BoxNumber aux2 = bNumber[a + 1];
                BoxNumber aux3 = bNumber[a + 2];
                BoxNumber aux4 = bNumber[a + 3];
                for (int i = 0; i < bNumber[0].WIDTH; i++) {
                    bNumber[a].x += 1;
                    bNumber[a + 1].x += 1;
                    bNumber[a + 2].x += 1;
                    bNumber[a + 3].x += 1;
                    bNumber[a + 4].x -= 4;
                    try {
                        Thread.sleep(velocidad * 2);
                    } catch (InterruptedException e) {
                    }
                    repaint();
                }
                bNumber[a] = bNumber[a + 4];
                bNumber[a + 1] = aux;
                bNumber[a + 2] = aux2;
                bNumber[a + 3] = aux3;
                bNumber[a + 4] = aux4;
            } else {
                ordenar(a, a + 4, 4);
                ordenar(a + 1, a + 4, 3);
                ordenar(a + 2, a + 4, 2);
                ordenar(a + 3, a + 4, 1);
                ordenar(a + 4, a + 5, 1);
                ordenar(a + 3, a + 4, 1);
                ordenar(a + 2, a + 3, 1);
                ordenar(a + 1, a + 2, 1);
            }
        }

        /**
         * <h1>Ordenar</h1>
         * <p>
         * Ordena los rectangulos de menor a mayor.</p>
         *
         * @param a posicion en el array
         * @param b posicion en el array
         * @param espacios cant. de espacios que se debe mover para quedar
         * ordenado.
         */
        public void ordenar(int a, int b, int espacios) {
            if (bNumber[a].getValue() > bNumber[b].getValue()) {
                BoxNumber aux = bNumber[a];
                girar(a, b);
                movX(a, b, espacios);
                bNumber[a] = bNumber[b];
                bNumber[b] = aux;
            }
        }

        /**
         * <h1>MovY<h1>
         * <p>
         * Mueve el rectangulo en Y</p>
         *
         * @param a posicion en el array.
         */
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

        /**
         * <h1>Mov2Y<h1>
         * <p>
         * Mueve dos rectangulos en Y</p>
         *
         * @param a posicion en el array.
         */
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

        /**
         * <h1>Mov4Y<h1>
         * <p>
         * Mueve cuatro rectangulos en Y</p>
         *
         * @param a posicion en el array.
         */
        private void mov4Y(int a) {
            for (int i = 0; i < bNumber[a].HEIGHT; i++) {
                bNumber[a].y -= 1;
                bNumber[a + 1].y -= 1;
                bNumber[a + 2].y -= 1;
                bNumber[a + 3].y -= 1;
                bNumber[a + 4].y += 2;
                bNumber[a + 5].y += 2;
                try {
                    Thread.sleep(velocidad * 2);
                } catch (InterruptedException e) {
                }
                repaint();
            }
        }

        /**
         * <h1>MovXY<h1>
         * <p>
         * Mueve dos rectangulos en X y Y</p>
         *
         * @param a posicion en el array.
         */
        private void movXY(int a) {
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

        /**
         * <h1>MovX<h1>
         * <p>
         * Mueve el rectangulo en X</p>
         *
         * @param a posicion en el array.
         */
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

        /**
         * <h1>Girar</h1>
         * <p>
         * Gira los rectangulos para ubicarlos en la posicion debida.</p>
         *
         * @param a posicion en el array
         * @param b posicion en el array
         */
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
