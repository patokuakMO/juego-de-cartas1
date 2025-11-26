package Clases;

public class Jugador {

    private String nombre;
    private ListaCartas mazo;
    private Cola<Carta> colaEspera;
    private Pila pilaDescarte;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mazo = new ListaCartas();
        this.colaEspera = new Cola<>();
        this.pilaDescarte = new Pila();
    }

    public String getNombre() {
        return nombre;
    }

    public ListaCartas getMazo() {
        return mazo;
    }

    public Cola<Carta> getColaEspera() {
        return colaEspera;
    }

    public Pila getPilaDescarte() {
        return pilaDescarte;
    }

    public boolean tieneCartasVivas() {
        for (int i = 0; i < mazo.tamaño(); i++) {
            if (mazo.obtener(i).getVida() > 0) {
                return true;
            }
        }
        return false;
    }
}

