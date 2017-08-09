package da;

/**
 *
 * @author Johan Herrera
 * @param <T>
 */
public class Lista<T extends Comparable<T>> {

    private Nodo<T> cabeza;
    private Nodo<T> ultimo;
    private int size;

    public Lista() {
        this.cabeza = null;
        this.ultimo = null;
        this.size = 0;
    }

    public int size() {
        return size;
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

    public boolean isEmpty() {
        return cabeza == null;
    }

    /**
     * <h1>Add</h1>
     * <p>
     * Agrega personas a la lista simple.</p>
     *
     * @param nombre Nombre de la Persona
     * @param apellido Primer Apellido de la Persona
     * @param apellido2 Segundo Apellido de la Persona
     * @param documento Documento de la Persona
     * @param edad Edad de la Persona
     * @return boolean: Con el resultado de la operacion.
     */
    public boolean add(String nombre, String apellido, String apellido2, String documento, double edad) {
        if (!validarCedulaPasaporte(documento)) {
            if (pasaporteCedula(documento)) {
                documento = documento.toUpperCase();
            }
            Persona miPersona = new Persona(nombre, apellido, apellido2, documento, edad);
            Nodo nuevo = new Nodo(miPersona);
            if (isEmpty()) {
                cabeza = nuevo;
                ultimo = nuevo;
            } else {
                ultimo.setSiguiente(nuevo);
                ultimo = nuevo;
            }
            nuevo.setPersona(miPersona);
            size++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * <h1>AddFirstSimple</h1>
     * <p>
     * Agrega la persona al inicio de la lista</p>
     *
     * @param nombre Nombre de la Persona
     * @param apellido Primer Apellido de la Persona
     * @param apellido2 Segundo Apellido de la Persona
     * @param documento Documento de la Persona
     * @param edad Edad de la Persona
     * @return boolean: el resultado de la operacion
     */
    public boolean addFirstSimple(String nombre, String apellido, String apellido2, String documento, double edad) {
        Persona miPersona = new Persona(nombre, apellido, apellido2, documento, edad);
        Nodo nuevo = new Nodo(miPersona);
        if (isEmpty()) {
            cabeza = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        }
        nuevo.setPersona(miPersona);
        size++;
        return true;
    }

    /**
     * <h1>AddCircular</h1>
     * <p>
     * Agrega personas a la lista Circular.</p>
     *
     * @param nombre Nombre de la Persona
     * @param apellido Primer Apellido de la Persona
     * @param apellido2 Segundo Apellido de la Persona
     * @param documento Documento de la Persona
     * @param edad Edad de la Persona
     * @return boolean: con el resultado de la operacion.
     */
    public boolean addCircular(String nombre, String apellido, String apellido2, String documento, double edad) {
        if (!validarCedulaPasaporte(documento)) {
            if (pasaporteCedula(documento)) {
                documento = documento.toUpperCase();
            }
            Persona persona = new Persona(nombre, apellido, apellido2, documento, edad);
            Nodo nuevo = new Nodo(persona);
            if (isEmpty()) {
                cabeza = nuevo;
                ultimo = nuevo;
                ultimo.setSiguiente(cabeza);
                cabeza.setAnterior(ultimo);
            } else {
                ultimo.setSiguiente(nuevo);
                nuevo.setAnterior(ultimo);
                nuevo.setSiguiente(cabeza);
                cabeza.setAnterior(nuevo);
                ultimo = nuevo;
            }
            nuevo.setPersona(persona);
            size++;
            return true;
        } else {
            return false;
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
        while (cont < size) {
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
     * @param Documento String que se desea comprobar.
     * @return boolean con el resultado de la operacion.
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
     * <h1>Remove</h1>
     * <p>
     * Comprueba si el index introducido es valido. De ser asi elimina a la
     * persona de la lista.</p>
     *
     * @param index posicion del nodo a eliminar.
     * @return
     */
    public boolean remove(int index) {
        if (0 == size) {
            return false;
        } else if (0 > index || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Indice invalido");
        } else {
            if (0 == index) {
                cabeza = cabeza.getSiguiente();
            } else if (index == size - 1) {
                Nodo aux = cabeza;
                while (aux.getSiguiente() != null) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(null);
                ultimo = aux;
            } else {
                Nodo aux = cabeza;
                for (int i = 0; i < index - 1; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
            }
            --size;
            return true;
        }
    }

    /**
     * <h1>Pasaporte Primero</h1>
     * <p>
     * Busca si hay pasaportes en la lista de ser asi los agrega de primero.</p>
     */
    public void pasaportePrimero() {
        if (!isEmpty()) {
            Nodo aux = cabeza;
            int cont = 0;

            while (aux != null) { //Recorre la Lista.
                if (pasaporteCedula(aux.getPersona().getCedula())) { //Cuenta la cantidad de personas registradas con pasaporte.
                    cont++;
                }
                aux = aux.getSiguiente();
            }
            int cont2 = 0;
            while (cont > 0) { //Repite el proceso hasta que todos los pasaportes se encuentren ubicados antes de las cedulas.
                aux = cabeza;
                Nodo aux2 = aux;
                while (aux != null) { //Recorre la lista
                    if (pasaporteCedula(aux.getPersona().getCedula())) { //Busca si alguna persona de la lista esta registrada con un pasaporte.
                        break;
                    }
                    cont2++;
                    aux = aux.getSiguiente();
                }
                int cont3 = cont2;
                while (cont3 > 0) { //Remueve de la lista todas las personas que esten registradas con una cedula dejando solo los que tengan pasaporte.
                    remove(0);
                    cont3--;
                }
                ultimoNodoLista();
                while (cont2 > 0) { //Añade nuevamente las personas a la lista.
                    add(aux2.getPersona().getNombre(), aux2.getPersona().getApellido(),
                            aux2.getPersona().getApellido2(), aux2.getPersona().getCedula(), aux2.getPersona().getEdad());
                    aux2 = aux2.getSiguiente();
                    cont2--;
                }
                cont--;
            }
        }
    }

    /**
     * <h1>Pasaporte PrimeroC</h1>
     * <p>
     * Busca si hay pasaportes en la listaCircular de ser asi los agrega de
     * primero.</p>
     */
    public void pasaportePrimeroC() {
        if (!isEmpty()) {
            Nodo aux = cabeza;
            int cont = 0;

            while (aux != null) { //Recorre la Lista.
                if (pasaporteCedula(aux.getPersona().getCedula())) { //Cuenta la cantidad de personas registradas con pasaporte.
                    cont++;
                }
                aux = aux.getSiguiente();
            }
            int cont2 = 0;
            while (cont > 0) { //Repite el proceso hasta que todos los pasaportes se encuentren ubicados antes de las cedulas.
                aux = cabeza;
                Nodo aux2 = aux;
                while (aux != null) { //Recorre la lista
                    if (pasaporteCedula(aux.getPersona().getCedula())) { //Busca si alguna persona de la lista esta registrada con un pasaporte.
                        break;
                    }
                    cont2++;
                    aux = aux.getSiguiente();
                }
                int cont3 = cont2;
                while (cont3 > 0) { //Remueve de la lista todas las personas que esten registradas con una cedula dejando solo los que tengan pasaporte.
                    remove(0);
                    cont3--;
                }
                ultimoNodoLista();
                while (cont2 > 0) { //Añade nuevamente las personas a la lista.
                    add(aux2.getPersona().getNombre(), aux2.getPersona().getApellido(),
                            aux2.getPersona().getApellido2(), aux2.getPersona().getCedula(), aux2.getPersona().getEdad());
                    aux2 = aux2.getSiguiente();
                    cont2--;
                }
                cont--;
            }
            linkeos();

        }
    }

    /**
     * <h1>Linkeos</h1>
     * <p>
     * Hace los linkeos necesarios para convertir la lista en una lista
     * circular.</p>
     */
    public void linkeos() {
        if (!isEmpty()) {
            Nodo aux = cabeza;
            Nodo aux2 = cabeza.getSiguiente();
            int cont = 0;
            while (cont < size - 1) {
                aux2.setAnterior(aux);
                aux = aux.getSiguiente();
                aux2 = aux2.getSiguiente();
                cont++;
            }
            cabeza.setAnterior(ultimo);
            ultimo.setSiguiente(cabeza);
        }
    }

    /**
     * <h1>UltimoNodoLista</h1>
     * <p>
     * Declara el ultimo nodo de la lista en caso de que haya cambiado al
     * ordenar la estructura.</p>
     */
    public void ultimoNodoLista() {
        Nodo aux = cabeza;
        while (aux != null) { //Declara cual va a ser el Ultimo nodo de la lista.
            ultimo = aux;
            aux = aux.getSiguiente();
        }
    }

    /**
     * <h1>MergeSort</h1>
     * <p>
     * Ordena la lista utilizando el metodo de ordenamiento por mezcla</p>
     *
     * @param inicial Nodo donde empieza la lista.
     * @return Nodo: Cabeza.
     */
    public Nodo mergeSort(Nodo inicial) {
        //Divide la lista esta que sea nula o solo tenga 1 elemento en la lista.
        if (inicial == null || inicial.getSiguiente() == null) {
            return inicial;
        }
        //Divide la lista en 2 listas.
        //Encuentra el nodo de la mitad de la lista y divide la lista en 2.
        Nodo mitad = dividirLista(inicial);
        Nodo sigMitad = mitad.getSiguiente();
        mitad.setSiguiente(null);

        //Divide la lista hasta que tenga solo un elemento cada uno.
        Nodo izq = mergeSort(inicial);
        Nodo der = mergeSort(sigMitad);

        //Comienza a mezclar la mitad izq y la mitad der.
        mergeS(izq, der);
        return cabeza;
    }

    /**
     * <h1>Merge</h1>
     * <p>
     * Mezcla las sublistas creadas por el MergeSort</p>
     *
     * @param izqIni Inicio de la Lista Izquierda
     * @param derIni Inicio de la Lista Derecha
     */
    public void mergeS(Nodo izqIni, Nodo derIni) {
        Nodo aux;
        Nodo mezclar = null;
        Nodo añadido = new Nodo(null);

        while (izqIni != null && derIni != null) {
            if (izqIni.getPersona().getCedula().compareTo(derIni.getPersona().getCedula()) < 0) {
                aux = izqIni;
                izqIni = izqIni.getSiguiente();
            } else {
                aux = derIni;
                derIni = derIni.getSiguiente();
            }

            if (mezclar != null) {
                añadido.setSiguiente(aux);
            } else {
                mezclar = aux;
            }
            añadido = aux;
        }

        if (izqIni == null) {
            añadido.setSiguiente(derIni);
        } else {
            añadido.setSiguiente(izqIni);
        }
        cabeza = mezclar;
    }

    /**
     * <h1>MergeSortC</h1>
     * <p>
     * Ordena la listaCircular utilizando el metodo de ordenamiento por
     * mezcla</p>
     *
     * @param inicial Nodo donde empieza la lista.
     * @return Nodo: Cabeza.
     */
    public Nodo mergeSortC(Nodo inicial) {
        //Elimino los linkeos para poder dividir la lista correctamente.
        cabeza.setAnterior(null);
        ultimo.setSiguiente(null);

        //Divide la lista esta que sea nula o solo tenga 1 elemento en la lista.
        if (inicial == null || inicial.getSiguiente() == null) {
            return inicial;
        }
        //Divide la lista en 2 listas.
        //Encuentra el nodo de la mitad de la lista y divide la lista en 2.
        Nodo mitad = dividirLista(inicial);
        Nodo sigMitad = mitad.getSiguiente();
        mitad.setSiguiente(null);

        //Divide la lista hasta que tenga solo un elemento cada uno.
        Nodo izq = mergeSort(inicial);
        Nodo der = mergeSort(sigMitad);

        //Comienza a mezclar la mitad izq y la mitad der.
        mergeC(izq, der);
        pasaportePrimeroC();
        return cabeza;
    }

    /**
     * <h1>MergeC</h1>
     * <p>
     * Mezcla las sublistasCirculares creadas por el MergeSort</p>
     *
     * @param izqIni Inicio de la Lista Izquierda
     * @param derIni Inicio de la Lista Derecha
     */
    public void mergeC(Nodo izqIni, Nodo derIni) {
        Nodo aux;
        Nodo mezclar = null;
        Nodo añadido = new Nodo(null);

        while (izqIni != null && derIni != null) {
            if (izqIni.getPersona().getCedula().compareTo(derIni.getPersona().getCedula()) < 0) {
                aux = izqIni;
                izqIni = izqIni.getSiguiente();
            } else {
                aux = derIni;
                derIni = derIni.getSiguiente();
            }

            if (mezclar != null) {
                añadido.setSiguiente(aux);
                aux.setAnterior(añadido);
            } else {
                mezclar = aux;
            }
            añadido = aux;
        }

        if (izqIni == null) {
            añadido.setSiguiente(derIni);
        } else {
            añadido.setSiguiente(izqIni);
            izqIni.setAnterior(añadido);
        }
        cabeza = mezclar;
    }

    /**
     * <h1>Dividir Lista</h1>
     * <p>
     * Busca la mitad de la lista.</p>
     *
     * @param inicial Nodo donde inicia la lista.
     * @return Nodo: Puntero.
     */
    public Nodo dividirLista(Nodo inicial) {
        if (inicial == null) {
            return inicial;
        }
        Nodo puntero1 = inicial;
        Nodo puntero2 = inicial;
        while (puntero2 != null && puntero2.getSiguiente() != null && puntero2.getSiguiente().getSiguiente() != null) {
            puntero1 = puntero1.getSiguiente();
            puntero2 = puntero2.getSiguiente().getSiguiente();
        }
        return puntero1;
    }

    /**
     * <h1>Obtener Nodo</h1>
     * Obtener un nodo en la posicion deseada.
     *
     * @param p lista
     * @param index indice
     * @return Nodo
     */
    public Nodo obtenerNodo(Lista p, int index) {
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
     * <h1>Swap</h1>
     * Intercambia las posiciones.
     *
     * @param p lista
     * @param i primera posicion
     * @param j segunda posicion
     */
    public void swap(Lista p, int i, int j) {
        if (!p.isEmpty()) {
            Persona tmp = obtenerNodo(p, i).getPersona();
            obtenerNodo(p, i).setPersona(obtenerNodo(p, j).getPersona());
            obtenerNodo(p, j).setPersona(tmp);
        }
    }

    /**
     * <h1>BrickSort</h1>
     * <p>
     * Ordena la lista mediante el metodo ordenamiento por ladrillos.
     * </p>
     *
     * @param p lista
     */
    public void brickSort(Lista p) {
        if (!p.isEmpty()) {
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < p.size - 1; i += 2) {
                    if (p.obtenerNodo(p, i).getPersona().getCedula().compareTo(p.obtenerNodo(p, i + 1).getPersona().getCedula()) > 0) {
                        swap(p, i, i + 1);
                        sorted = false;
                    }
                }
                for (int i = 1; i < p.size - 1; i += 2) {
                    if (p.obtenerNodo(p, i).getPersona().getCedula().compareTo(p.obtenerNodo(p, i + 1).getPersona().getCedula()) > 0) {
                        swap(p, i, i + 1);
                        sorted = false;
                    }
                }
            }
        }
        pasaportePrimero();
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

