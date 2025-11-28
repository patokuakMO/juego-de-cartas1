package Modelo;
/**
 *Pila simple para guardar cartas descartadas (LIFO).
 * @author Tilines
 */
public class Pila {
    
    private class NodoPila {
        Carta carta;
        NodoPila abajo;

        public NodoPila(Carta carta) {
            this.carta = carta;
        }
    }

    private NodoPila tope;

    public void push(Carta carta) {
        NodoPila nuevo = new NodoPila(carta);
        nuevo.abajo = tope;
        tope = nuevo;
    }

    public Carta pop() {
        if (vacia()) return null;
        Carta c = tope.carta;
        tope = tope.abajo;
        return c;
    }

    public boolean vacia() {
        return tope == null;
    }
}

