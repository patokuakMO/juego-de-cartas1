package Clases;
/**
 *Cola implementada con nodos enlazados (FIFO).
 * @author Tilines
 */
public class Cola<T> {

    private class NodoCola {
        T dato;
        NodoCola siguiente;

        public NodoCola(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private NodoCola frente;
    private NodoCola fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    // Encolar
    public void encolar(T dato) {
        NodoCola nuevo = new NodoCola(dato);
        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    // Desencolar
    public T desencolar() {
        if (estaVacia()) {
            return null;
        }
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return dato;
    }

    // Ver el primero
    public T peek() {
        return estaVacia() ? null : frente.dato;
    }

    // Ver si está vacía
    public boolean estaVacia() {
        return frente == null;
    }

    // Obtener tamaño
    public int tamaño() {
        int count = 0;
        NodoCola aux = frente;
        while (aux != null) {
            count++;
            aux = aux.siguiente;
        }
        return count;
    }

}
