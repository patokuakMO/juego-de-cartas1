package Modelo;
/**
 *  Representa un jugador con mazo, cola y pila.
 * @author Tilines
 */
public class Jugador {

    private String nombre;
    private int rondasG;
    private ListaCartas mazo;
    private Cola<Carta> colaEspera;
    private Pila pilaDescarte;

    public Jugador() {
    }
        
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.rondasG = 0;
        this.mazo = new ListaCartas();
        this.colaEspera = new Cola<>();
        this.pilaDescarte = new Pila();
    }

    public String getNombre() {
        return nombre;
    }

    public int getRondasG() {
        return rondasG;
    }

    public void setRondasG(int rondasG) {
        this.rondasG = rondasG;
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

    public boolean tieneCartas(ListaCartas mazo){
        return !mazo.estaVacia();
    }
}

