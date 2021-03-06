package main;

import da.Cola;
import da.Lista;
import da.Pila;
import ui.VentanaAlgoritmos;

/**
 *
 * @author Johan Herrera
 */
public class Proyecto2Progra3 {

    public static void main(String[] args) {
        Cola c = new Cola(); //Cola Vacia
        Pila p = new Pila(); //Pila Vacia
        Lista l = new Lista(); //Lista Vacia
        Lista lc = new Lista();//Lista Circular Vacia
        Lista b = new Lista();//Lista BrickSort Vacia

        //Merge Sort Simple
        l.add("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4); //Añade a la Lista
        l.add("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        l.add("Mariana", "Castilla", "Arias", "M123785", 20.9);
        l.add("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        l.add("Daniela", "Zepeda", "Ramirez", "P985321", 20.9);
        l.add("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        l.add("Rogel", "Herrera", "Bellido", "8-0083-0592", 45.5);
        l.add("Angel", "Barrantes", "Chaves", "e770089", 18.7);

        System.out.println("MergeSort Simple \nLista Original: \n" + l.toString());//Imprime lista Original
        l.mergeSort(l.getCabeza());                                //Ordenamiento por mezcla 
        l.pasaportePrimero();                                     //Si hay pasaportes los coloca en primera posicion.
        System.out.println("Lista Ordenada: - Luego del MergeSort \n" + l.toString()); //Imprime lista Ordenada

        //Merge Sort Circular
        lc.addCircular("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4); //Añade a la Lista Circular
        lc.addCircular("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        lc.addCircular("Mariana", "Castilla", "Arias", "M123785", 20.9);
        lc.addCircular("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        lc.addCircular("Daniela", "Zepeda", "Ramirez", "P985321", 20.9);
        lc.addCircular("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        lc.addCircular("Rogel", "Herrera", "Bellido", "8-0083-0592", 45.5);
        lc.addCircular("Angel", "Barrantes", "Chaves", "e770089", 18.7);

        System.out.println("MergeSort Circular \nLista Original: \n" + lc.toString());//Imprime listaCircular Original
        lc.mergeSortC(lc.getCabeza());                            //Ordenamiento por mezcla ListaCircular
        System.out.println("\nLista Ordenada: - Luego del MergeSort \n" + lc.toString()); //Imprime listaCircular Ordenada

        //Heap Sort
        p.push("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4); //Añade a la Pila
        p.push("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        p.push("Mariana", "Castilla", "Arias", "M123785", 20.9);
        p.push("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        p.push("Daniela", "Zepeda", "Ramirez", "P985321", 20.9);
        p.push("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        p.push("Rogel", "Herrera", "Bellido", "8-0083-0592", 45.5);
        p.push("Angel", "Barrantes", "Chaves", "e770089", 18.7);

        System.out.println("HeapSort \nPila Original: \n" + p.toString());//Imprime Pila Original
        p.heapSort(p);                                              //Ordena la pila.
        System.out.println("Pila Ordenada: - Luego del HeapSort \n" + p.toString()); //Imprime Pila Ordenada

        //Insertion Sort 
        c.queue("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4);   //Añade a la Cola
        c.queue("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        c.queue("Mariana", "Castilla", "Arias", "M123785", 20.9);
        c.queue("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        c.queue("Daniela", "Zepeda", "Ramirez", "P557905", 20.9);
        c.queue("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        c.queue("Rogel", "Herrera", "Bellido", "8-0083-0592", 41.5);
        c.queue("Angel", "Barrantes", "Chaves", "e770089", 18.7);

        System.out.println("InsertionSort \nCola Original: \n" + c.toString());//Imprime Cola Original
        c.insertionSort();                                       //Ordenadimiento por Insercion
        System.out.println("Cola Ordenada: - Luego del InsertionSort\n" + c.toString()); //Imprime Cola Ordenada

        //Brick Sort
        b.add("Nitzia", "Chi", "Yaslin", "7-0126-0769", 39.4); //Añade a la Lista
        b.add("Johan", "Herrera", "Araya", "1-1711-0507", 19.1);
        b.add("Mariana", "Castilla", "Arias", "M123785", 20.9);
        b.add("Gimenha", "Sanchez", "Chi", "7-2750-0404", 17.5);
        b.add("Daniela", "Zepeda", "Ramirez", "P985321", 20.9);
        b.add("Karla", "Araya", "Chaves", "1-0929-0463", 41.5);
        b.add("Rogel", "Herrera", "Bellido", "8-0083-0592", 45.5);
        b.add("Angel", "Barrantes", "Chaves", "e770089", 18.7);

        System.out.println("BrickSort \nLista Original: \n" + b.toString());//Imprime lista Original
        b.brickSort(b); //Ordenamiento por ladrillos
        System.out.println("Lista Ordenada: - Luego del BrickSort\n" + b.toString());//Imprime lista Ordenada

        //II PARTE y III PARTE VENTANA ALGORITMO
        boolean verVentanas = true; //True = Despliega la Ventana - False = No despliega la ventana.
        if (verVentanas) {
            VentanaAlgoritmos vAlg = new VentanaAlgoritmos();
            vAlg.setVisible(true);
        } else {
            System.out.println("Para ver la Ventana Algoritmos cambie la variable verVentanas a true "
                    + "\nIR AL MAIN!!!");
        }
    }
}
