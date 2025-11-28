package Modelo;

/**
 * Inicializa las cartas del jugador y la computadora. Usa arreglos y bucles
 * para evitar duplicación.
 *
 * @author carli
 */
public class CrearCartas {

    public static void crear(Jugador jugador, Jugador computadora) {
        Carta[] cartasJugador = {
            new Carta("Flamix", 100, 25, 5, "Fuego", "Agua"),
            new Carta("Aquaron", 120, 20, 5, "Agua", "Planta"),
            new Carta("Leafy", 90, 30, 5, "Planta", "Fuego")
        };

        Carta[] cartasComputadora = {
            new Carta("Robotron", 110, 22, 5, "Metal", "Fuego"),
            new Carta("MagmaDog", 95, 27, 5, "Fuego", "Agua"),
            new Carta("Hydrax", 130, 18, 5, "Agua", "Planta")
        };

        if (jugador.getColaEspera().estaVacia()) {
            for (Carta c : cartasJugador) {
                jugador.getColaEspera().encolar(c);
            }
        }

        if (computadora.getColaEspera().estaVacia()) {
            for (Carta c : cartasComputadora) {
                computadora.getColaEspera().encolar(c);
            }
        }

        if (jugador.getMazo().estaVacia()) {
            for (Carta c : cartasJugador) {
                jugador.getMazo().agregarCarta(c);
            }
        }

        if (computadora.getMazo().estaVacia()) {
            for (Carta c : cartasComputadora) {
                computadora.getMazo().agregarCarta(c);
            }
        }
    }
}
