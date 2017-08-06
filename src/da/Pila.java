package da;

/**
 *
 * @author Johan Herrera
 * @param <T>
 */
public class Pila<T extends Comparable<T>> {

    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    private int size;

    public Pila() {
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

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    /**
     * <h1>Push</h1>
     * <p>
     * Agrega una persona a la pila. </p>
     *
     * @param nombre Nombre de la Persona
     * @param apellido Primer Apellido de la Persona
     * @param apellido2 Segundo Apellido de la Persona
     * @param documento Documento de la Persona
     * @param edad Edad de la Persona
     */
    public void push(String nombre, String apellido, String apellido2, String documento, double edad) {
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
     * <h1>Pop</h1>
     * <p>
     * Remueve el ultimo nodo de la pila.</p>
     *
     * @return Nodo: Removido.
     */
    public Nodo pop() {
        Nodo<T> aux = ultimo;
        if (!isEmpty()) {
            ultimo = ultimo.getAnterior();
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
     * <h1>Peek</h1>
     * <p>
     * Devuelve el ultimo nodo de la pila pero no lo remueve.</p>
     *
     * @return Nodo: Ultimo nodo de la pila.
     */
    public Nodo peek() {
        if (!isEmpty()) {
            return ultimo;
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
        Nodo aux = peek();
        int cont = 0;
        if ((documento.length() != 11 && documento.length() != 7) || (documento.length() == 7 && pasaporteFormato(documento)) || (documento.length() == 11 && cedulaFormato(documento))) {
            bandera = true;
            System.err.println("La Cedula debe incluir 11 digitos incluyendo los guiones,"
                    + " ademas de que no puede iniciar con 0 y el Pasaporte debe incluir una Letra y seis digitos.");
        }
        while (cont < size) {
            if (aux.getPersona().getCedula().equals(documento)) {
                bandera = true;
                System.err.println("El pasaporte o Cedula introducido ya existe.");
                break;
            }
            cont++;
            aux = aux.getAnterior();
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
     * @param Cedula String que se desea validar.
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
     * @return boolean con el resultado.
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
     * @param letra caracter que se desea validar.
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
     * <h1>Pop Multiple</h1>
     * <p>
     * Remueve de la pila a todas las personas hasta llegar al index deseado.
     * </p>
     *
     * @param index cantidad de pop que se desean realizar.
     * @return boolean: con el resultado de la operacion.
     */
    public boolean popMultiple(int index) {
        if (isEmpty()) {
            return false;
        } else {
            while (index > 0) {
                pop();
                index--;
            }

            return true;
        }
    }

    /**
     * <h1>Pasaporte Primero</h1>
     * <p>
     * Busca los pasaportes y cedulas en la pila. Y los divide en listas
     * auxiliares para luego ser agregados en el orden Pasaportes primero
     * seguido de las cedulas.</p>
     *
     */
    public void pasaportePrimero() {
        Nodo aux = cabeza;
        Pila cedulaAux = new Pila();
        Pila pasaporteAux = new Pila();
        while (aux != null) {
            if (pasaporteCedula(aux.getPersona().getCedula())) { //Si es un pasaporte lo agrega a la pila auxiliar de pasaportes.
                pasaporteAux.push(aux.getPersona().getNombre(), aux.getPersona().getApellido(),
                        aux.getPersona().getApellido2(), aux.getPersona().getCedula(), aux.getPersona().getEdad());
            } else {
                cedulaAux.push(aux.getPersona().getNombre(), aux.getPersona().getApellido(), //Sino lo agrega a la pila auxiliar de cedulas.
                        aux.getPersona().getApellido2(), aux.getPersona().getCedula(), aux.getPersona().getEdad());
            }
            aux = aux.getSiguiente();
        }
        popMultiple(size); // Vacia la pila
        agregarDesdePilaAux(pasaporteAux); //Agrega las personas registradas con pasaporte.
        agregarDesdePilaAux(cedulaAux);    //Agrega las personas registradas con cedula.
    }

    /**
     * <h1>Agregar Desde PilaAux</h1>
     * <p>
     * Agrega a las personas desde otras pilas auxiliares.</p>
     *
     * @param pilaAux pila que se desea agregar.
     */
    public void agregarDesdePilaAux(Pila pilaAux) {
        if (!pilaAux.isEmpty()) {
            Nodo aux = pilaAux.cabeza;
            while (aux != null) {
                push(aux.getPersona().getNombre(), aux.getPersona().getApellido(), //Agrega los pasaportes a la pila original.
                        aux.getPersona().getApellido2(), aux.getPersona().getCedula(), aux.getPersona().getEdad());
                aux = aux.getSiguiente();
            }
            pilaAux.popMultiple(size);
        }
    }

    /**
     * <h1>Obtener Tamaño</h1>
     * <p>
     * Obtiene el tamaño de la pila.</p>
     *
     * @param p pila
     * @return int tamaño
     */
    public int obtenerTamaño(Pila p) {
        if (!p.isEmpty()) {
            int cont = 0;
            Nodo aux = p.getCabeza();
            while (aux.getSiguiente() != null) {
                cont++;
                aux = aux.getSiguiente();
            }
            return cont;
        } else {
            return 0;
        }
    }

    /**
     * <h1>Obtener Nodo</h1>
     * Obtener un nodo en la posicion deseada.
     *
     * @param p pila
     * @param index indice
     * @return Nodo
     */
    public Nodo obtenerNodo(Pila p, int index) {
        if (!p.isEmpty()) {
            int cont = 0;
            Nodo aux = p.getCabeza();
            while (cont != index) {
                cont++;
                aux = aux.getSiguiente();
            }
            if (aux == null) {
                System.out.println("No se encontro ningun nodo en la posicion digitada.");
                return null;
            }
            return aux;
        }
        return null;
    }

    /**
     * <h1>HeapSort</h1>
     * Ordena la pila por monticulos.
     *
     * @param p pila
     */
    public void heapSort(Pila p) {
        if (!p.isEmpty()) {
            int cont = size;
            heapify(p);
            for (int i = size; i > 0; i--) {
                swap(p, 0, i);
                size = size - 1;
                maxheap(p, 0);
            }
            setSize(cont);
            pasaportePrimero();
        }
    }

    /**
     * <h1>Heapify</h1>
     * Construye el monticulo
     *
     * @param p pila
     */
    public void heapify(Pila p) {
        if (!p.isEmpty()) {
            size = obtenerTamaño(p);
            for (int i = size / 2; i >= 0; i--) {
                maxheap(p, i);
            }
        }
    }

    /**
     * <h1>Swap</h1>
     * Intercambia las posiciones.
     *
     * @param p pila
     * @param i primera posicion
     * @param j segunda posicion
     */
    public void swap(Pila p, int i, int j) {
        if (!p.isEmpty()) {
            Persona tmp = obtenerNodo(p, i).getPersona();
            obtenerNodo(p, i).setPersona(obtenerNodo(p, j).getPersona());
            obtenerNodo(p, j).setPersona(tmp);
        }
    }

    /**
     * <h1>MaxHeap</h1>
     * Intercambia el elemento mayor del monticulo.
     *
     * @param p pila
     * @param i index
     */
    public void maxheap(Pila p, int i) {
        if (!p.isEmpty()) {
            int izq = 2 * i;
            int der = 2 * i + 1;
            int max = i;
            if (izq <= size) {
                if (obtenerNodo(p, izq).getPersona().getCedula().compareTo(obtenerNodo(p, i).getPersona().getCedula()) > 0) {
                    max = izq;
                }
            }
            if (der <= size) {
                if (obtenerNodo(p, der).getPersona().getCedula().compareTo(obtenerNodo(p, max).getPersona().getCedula()) > 0) {
                    max = der;
                }
            }
            if (max != i) {
                swap(p, i, max);
                maxheap(p, max);
            }
        }
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            StringBuilder builder = new StringBuilder();
            Nodo aux = cabeza;
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

