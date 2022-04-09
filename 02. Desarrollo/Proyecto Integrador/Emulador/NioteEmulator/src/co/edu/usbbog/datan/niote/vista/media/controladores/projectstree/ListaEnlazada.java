package co.edu.usbbog.datan.niote.vista.media.controladores.projectstree;

import co.edu.usbbog.datan.niote.controlador.logica.GestionRed;

/**
 * @author Camilo Andrés Díaz Gómez.
 * @version 1.0
 * @since August 2020.
 */
public class ListaEnlazada {

    Nodo cabeza;
    int size; //Tamaano lista enlazada

    /*
    Un elemento queda al inicio de las listas
    nodo1 = cabeza = nuevo elemento
     */
 /*
    Si se quiere agregar el elemento al final hay que recorrer toda la lista
     */
    public ListaEnlazada() {
        cabeza = null;
        size = 0;
    }

    //Metodo para saber si esta vacia
    public boolean estaVacia() {
        //Una forma de if 
        //return (cabeza==null)?true:false;
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    /*
    public boolean estaVacia() {
        return (cabeza == null) ? true : false;
    }*/
    //Metodo para saber si esta vacia
    public void addPrimer(GestionRed obj) {
        if (cabeza == null) {
            cabeza = new Nodo(obj);
        } else {
            //Cuando no esta vacia
            //Se crea un nodo sin apuntamiendo, despues, este nodo se apunta
            Nodo temp = cabeza;
            Nodo nuevo = new Nodo(obj); //Aislado
            nuevo.enlazarSiguiente(temp);
            cabeza = nuevo; //Se añade el nuevo
        }
        size++;
    }

    public void addFinal(GestionRed obj) {
        Nodo nuevo = new Nodo(obj);
        if (estaVacia()) {
            cabeza = nuevo;
        } else {
            Nodo aux = cabeza;
            while (aux.obtenerSiguiente() != null) {
                aux = aux.obtenerSiguiente();
            }
            aux.enlazarSiguiente(nuevo);
        }
        size++;
    }

    //Calcular tamaño de la lista
    public int size() {
        return size;
    }

    //Obtener el elemento de un nodo
    //Retorna un objeto
    //Indice: posicion que queremos llegar
    public Object obtenerValor(int indice) {
        int contador = 0;
        Nodo temp = cabeza;
        while (contador < indice) {
            temp = temp.obtenerSiguiente();
            //Pasar de un nodo a otro
            contador++;
        }
        return temp.obtenerValor();
    }

    //Eliminar la cabeza de la lista
    public void eliminarPrimeroOCabeza() {
        if (size > 1) {
            cabeza = cabeza.obtenerSiguiente();
            size--;
        } else {
            cabeza = null;
        }
    }

    public void insertarPorPosicion(int indice, GestionRed obj) {

        if (indice >= 0 && indice <= size) {
            Nodo nuevo = new Nodo(obj);

            if (indice == 0) {
                nuevo.enlazarSiguiente(cabeza);
                cabeza = nuevo;

            } else if (indice == size) {
                Nodo aux = cabeza;

                while (aux.obtenerSiguiente() != null) {
                    aux = aux.obtenerSiguiente();
                }

                aux.enlazarSiguiente(nuevo);
            } else {

                Nodo aux = cabeza;

                for (int i = 0; i < (indice - 1); i++) {
                    aux = aux.obtenerSiguiente();
                }

                Nodo siguiente = aux.obtenerSiguiente();
                aux.enlazarSiguiente(nuevo);

                nuevo.enlazarSiguiente(siguiente);
            }
        }
        size++;
    }

    //Se busca un dato del nodo del depende del elemento digitado
    public GestionRed buscarElemento(String obj) {
        // Crea una copia de la lista.
        Nodo aux = cabeza;
        // Bandera para indicar si el valor existe.
        boolean encontrado = false;
        // Recorre la lista hasta encontrar el elemento o hasta 
        // llegar al final de la lista.
        while (aux != null && encontrado != true) {
            // Consulta si el valor del nodo es igual al de referencia.
            if (obj.equals(aux.obtenerValor().getRed().getNombre())) {
                // Canbia el valor de la bandera.
                encontrado = true;
                return aux.valor;
            } else {
                // Avansa al siguiente. nodo.
                aux = aux.obtenerSiguiente();
            }
        }
        // Retorna el resultado de la bandera.
        return aux.valor;
    }

    public Object getValor(int indice) throws Exception {

        if (indice >= 0 && indice < size) {

            if (indice == 0) {
                return cabeza.obtenerValor();
            } else {

                Nodo aux = cabeza;

                for (int i = 0; i < indice; i++) {
                    aux = aux.obtenerSiguiente();
                }

                return aux.obtenerValor();
            }

        } else {
            throw new Exception("Posicion no se enceuntra lista");
        }
    }

    //Elimina toda la lista
    public void eliminar() {
        cabeza = null;
        size = 0;
    }

    //Imprime toda la lista
    public void listar() {
        if (!estaVacia()) {
            Nodo aux = cabeza;
            int i = 0;
            while (aux != null) {
                System.out.print("[ " + aux.obtenerValor().getRed().getNombre() + " ]" + " ->  ");
                // Avanza al siguiente nodo
                aux = aux.obtenerSiguiente();
                i++;
            }
        }
    }
}
