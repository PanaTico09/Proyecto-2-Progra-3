package da;

/**
 *
 * @author Johan Herrera
 * @param <T>
 */
public class Cola<T extends Comparable<T>> {

    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    private int size;

    public Cola() {
        this.cabeza = null;
        this.ultimo = null;
        this.size = 0;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    /**
     * <h1>Queue</h1>
     * <p>
     * Añade una persona a la cola.</p>
     *
     * @param nombre Nombre de la Persona
     * @param apellido Primer Apellido de la Persona
     * @param apellido2 Segundo Apellido de la Persona
     * @param documento Documento de la Persona
     * @param edad Edad de la Persona
     */
    public void queue(String nombre, String apellido, String apellido2, String documento, double edad) {
        if (!validarCedulaPasaporte(documento)) {
            if (pasaporteCedula(documento)) {
                documento = documento.toUpperCase();
            }
            Persona persona = new Persona(nombre, apellido, apellido2, documento, edad);
            Nodo nuevo = new Nodo(persona);
            if (isEmpty()) {
                cabeza = nuevo;
                ultimo = nuevo;
            } else {
                ultimo.setSiguiente(nuevo);
                nuevo.setAnterior(ultimo);
                ultimo = nuevo;
            }
            nuevo.setPersona(persona);
            size++;
        }
    }

    /**
     * <h1>Dequeue</h1>
     * <p>
     * Remueve de la cola a la primer persona de la cola.</p>
     *
     * @return Nodo removido.
     */
    public Nodo dequeue() {
        Nodo<T> aux = cabeza;
        if (!isEmpty()) {
            cabeza = cabeza.getSiguiente();
            size--;
            if (size == 0) {
                cabeza = null;
            }
            return aux;
        } else {
            return null;
        }
    }

    /**
     * <h1>Top</h1>
     * <p>
     * Devuelve a la primer persona de la cola. Pero no la elimina.</p>
     *
     * @return Nodo: Cabeza.
     */
    public Nodo top() {
        if (!isEmpty()) {
            return cabeza;
        } else {
            return null;
        }
    }

    /**
     * <h1>Validar Cedula Pasaporte</h1>
     * <p>
     * Comprueba si la Cedula o el Pasaporte introducido cumple con los
     * requerimientos necesarios.</p>
     *
     * @param documento String que se desea validar.
     * @return boolean: Con el resultado de la operacion.
     */
    public boolean validarCedulaPasaporte(String documento) {
        boolean bandera = false;
        Nodo aux = cabeza;
        int cont = 0;
        if ((documento.length() != 11 && documento.length() != 7) || (documento.length() == 7 && pasaporteFormato(documento)) || (documento.length() == 11 && cedulaFormato(documento))) {
            bandera = true;
            System.err.println("La Cedula debe incluir 11 digitos incluyendo los guiones,"
                    + " ademas de que no puede iniciar con 0 y el Pasaporte debe incluir una Letra y seis digitos.");
        }
        while (cont < size()) {
            if (aux.getPersona().getCedula().equals(documento)) {
                bandera = true;
                System.err.println("El pasaporte o Cedula introducido ya existe.");
                break;
            }
            cont++;
            aux = aux.getSiguiente();
        }
        return bandera;
    }

    /**
     * <h1>Pasaporte Formato</h1>
     * <p>
     * Verifica que el pasaporte cumpla con los requerimientos. Iniciar con una
     * letra y tener 6 numeros.</p>
     *
     * @param Pasaporte String que se desea validar
     * @return boolean: con el resultado de la operacion.
     */
    public boolean pasaporteFormato(String Pasaporte) {
        boolean bandera = false;
        for (int i = 1; i < 7; i++) {
            if (Character.isLetter(Pasaporte.charAt(i))) {
                bandera = true;
            }
        }
        if (!Character.isLetter(Pasaporte.charAt(0))) {
            bandera = true;
        }
        return bandera;
    }

    /**
     * <h1>Cedula Formato</h1>
     * <p>
     * Verifica que la cedula cumpla con los requerimientos. Iniciar con un
     * numero que no puede ser 0. Seguido debe llevar un guion. Despues cuatro
     * numeros otro guion y otros cuatro numeros.</p>
     *
     * @param Cedula String que se desea validar
     * @return boolean: con el resultado de la operacion.
     */
    public boolean cedulaFormato(String Cedula) {
        boolean bandera = false;
        for (int i = 2; i < 5; i++) {
            if (!Character.isDigit(Cedula.charAt(i))) {
                bandera = true;
            }
        }
        for (int i = 7; i < 11; i++) {
            if (!Character.isDigit(Cedula.charAt(i))) {
                bandera = true;
            }
        }
        if (!Character.isDigit(Cedula.charAt(0)) || Cedula.charAt(1) != '-' || Cedula.charAt(6) != '-' || Cedula.charAt(0) == '0') {
            bandera = true;
        }
        return bandera;
    }

    /**
     * <h1>Pasaporte Cedula</h1>
     * <p>
     * Comprueba si el documento introducido es un pasaporte o una cedula.</p>
     *
     * @param Documento String que se desea comprobar
     * @return boolean: con el resultado.
     */
    public boolean pasaporteCedula(String Documento) {
        boolean bandera = false;
        if (abcMayus(Documento.charAt(0)) || abcMinus(Documento.charAt(0))) {
            bandera = true;
        }
        return bandera;
    }

    /**
     * <h1>AbcMayus</h1>
     * <p>
     * Verifica si el caracter introducido es una letra del abecedario en
     * Mayuscula. De ser asi significa que el numero entrante es un
     * Pasaporte.</p>
     *
     * @param letra caracter que se desea validar
     * @return boolean: el resultado de la operacion.
     */
    public boolean abcMayus(char letra) {
        char a = (char) 65;
        boolean bandera = false;
        for (int i = 0; i < 26; i++) {
            if (a == letra) {
                bandera = true;
                break;
            } else {
                a = (char) (a + 1);
            }
        }
        return bandera;
    }

    /**
     * <h1>AbcMinus</h1>
     * <p>
     * Verifica si el caracter introducido es una letra del abecedario en
     * Minuscula. De ser asi significa que el numero entrante es un
     * Pasaporte.</p>
     *
     * @param letra caracter que se desea validar
     * @return boolean: el resultado de la operacion.
     */
    public boolean abcMinus(char letra) {
        char a = (char) 97;
        boolean bandera = false;
        for (int i = 0; i < 26; i++) {
            if (a == letra) {
                bandera = true;
                break;
            } else {
                a = (char) (a + 1);
            }
        }
        return bandera;
    }

    /**
     * <h1>Dequeue Multiple</h1>
     * <p>
     * Remueve de la cola a todas las personas hasta llegar al index deseado.
     * </p>
     *
     * @param index cantidad de dequeues que se desean realizar.
     * @return boolean: Con el resultado de la operacion.
     */
    public boolean dequeueMultiple(int index) {
        if (isEmpty()) {
            return false;
        } else {
            while (index > 0) {
                dequeue();
                index--;
            }
            return true;
        }
    }

    /**
     * <h1>Pasaporte Primero</h1>
     * <p>
     * Busca si hay pasaportes en la lista de ser asi los agrega de primero.</p>
     */
    public void pasaportePrimero() {
        Nodo aux = cabeza;
        int cont = 0;

        while (aux != null) {
            if (pasaporteCedula(aux.getPersona().getCedula())) { //Cuenta cuantos pasaportes hay en la Cola.
                cont++;
            }
            aux = aux.getSiguiente();
        }

        int cont2 = 0;
        while (cont > 0) {
            aux = cabeza;
            Nodo aux2 = aux;
            while (aux != null) {
                if (pasaporteCedula(aux.getPersona().getCedula())) {
                    break;
                }
                cont2++;                     //Cuenta cuantos nodos tiene delante de este.
                aux = aux.getSiguiente();
            }
            dequeueMultiple(cont2);          //Desencola todos los nodos al frente del pasaporte.
            while (cont2 > 0) {             //Añade todos los nodos que fueron removidos al poner el pasaporte de primero.
                queue(aux2.getPersona().getNombre(), aux2.getPersona().getApellido(),
                        aux2.getPersona().getApellido2(), aux2.getPersona().getCedula(), aux2.getPersona().getEdad());
                aux2 = aux2.getSiguiente();
                cont2--;
            }
            cont--;
        }
    }

    /**
     * <h1>Ultimo Nodo Cola</h1>
     * <p>
     * Declara el ultimo nodo de la lista en caso de que haya cambiado al
     * ordenar la estructura.</p>
     */
    public void ultimoNodoCola() {
        Nodo aux = top();
        while (aux != null) { //Declara cual va a ser el Ultimo nodo de la lista.
            ultimo = aux;
            aux = aux.getSiguiente();
        }
    }

    /**
     * <h1>Insertion Sort</h1>
     * <p>
     * Metodo de ordenamiento por insercion inserta la cedula de menor a mayor.
     * Basandose en la provincia, folio, asiento. Y en caso de que el documento
     * sea un pasaporte lo insertaria primero.</p>
     */
    public void insertionSort() {
        Nodo aux = top();
        if (aux == null || aux.getSiguiente() == null) { //Equivalente a size = 0 o 1. De ser asi la Cola esta vacia o ordenada respectivamente.
            return;
        }

        Nodo ColaOrdenada = null;
        while (aux != null) { //Recorre hasta el Final de la cola.
            Nodo sig = aux.getSiguiente();
            aux.setSiguiente(null);
            ColaOrdenada = sortedInsert(ColaOrdenada, aux);
            aux = sig;
        }

        cabeza = ColaOrdenada;
        ultimoNodoCola();
        pasaportePrimero();     //Coloca los pasaportes primero despues de ordenar.
    }

    /**
     * <h1>Sorted Insert</h1>
     * <p>
     * Ordena la Cola.</p>
     *
     * @param colaOrdenada Nodos ordenados
     * @param añadido Nodo que se desea ordenar
     * @return Cola ordenada.
     */
    public Nodo sortedInsert(Nodo colaOrdenada, Nodo añadido) {
        if (colaOrdenada == null) { //Si la Cola Ordenada se encuentra vacia.
            return añadido; //Añade el primer elemento a la Cola ordenada.
        }

        Nodo ant = null;
        Nodo aux = colaOrdenada;
        while (aux != null && aux.getPersona().getCedula().compareTo(añadido.getPersona().getCedula()) < 0) {   //Mientras el Aux de la ordenada sea menor al Nodo de la Cola Original.
            ant = aux;
            aux = aux.getSiguiente();
        }

        if (ant == null) {                      //Si esta condicion se cumple significa que el nodo añadido es menor que el primero de la cola.
            añadido.setSiguiente(colaOrdenada); //Por lo tanto lo añade de primero en la Cola
            return añadido;
        }

        Nodo antSig = ant.getSiguiente();
        ant.setSiguiente(añadido);              //Sino el Nodo mayor se añade despues del menor.
        añadido.setAnterior(ant);
        añadido.setSiguiente(antSig);           //Conecta el Nodo mayor con el que estaba conectado antes el menor.
        return colaOrdenada;
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            StringBuilder builder = new StringBuilder();
            Nodo aux = top();
            int cont = 0;
            while (cont < size) {
                builder.append(" - ").append(aux.getPersona());
                builder.append("\n");
                aux = aux.getSiguiente();
                cont++;
            }
            return builder.toString();
        }
        return "";
    }
}

