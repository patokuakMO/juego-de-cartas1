package Modelo;

import java.util.ArrayList;

public class ListaCartas {

    private ArrayList<Carta> cartas;

    public ListaCartas() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public Carta obtener(int index) {
        return cartas.get(index);
    }

    public int tamaño() {
        return cartas.size();
    }
    
        public boolean estaVacia() {
        return cartas.isEmpty();
    }
}

