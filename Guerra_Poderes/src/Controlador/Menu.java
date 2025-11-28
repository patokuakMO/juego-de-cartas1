package Controlador;
import Modelo.Carta;
import Modelo.Jugador;
import java.util.Scanner;
/**
 *
 * @author carli
 */
public class Menu {
    public void menu(Jugador jugador, Jugador computadora){
        int contadorJugador = 0;
        int contadorCPU = 0;
        Scanner sc = new Scanner(System.in);
        MotorBatalla batalla = new MotorBatalla();
        
        // 5. Seleccionar carta inicial
        System.out.print("\nSelecciona una carta para combatir: ");
        int indice = sc.nextInt();
        Carta cartaJugador = jugador.getMazo().obtener(indice);

        // CPU elige carta
        int aleatoria = (int) (Math.random() * computadora.getMazo().tamaño());
        Carta cartaCPU = computadora.getMazo().obtener(aleatoria);
        System.out.println("\nLa computadora elige: " + cartaCPU.getNombre());

        //6.Muestreo de acciones y menu
        do {
            // --- COMBATE ---
            System.out.println("\n>>> TU ATACAS PRIMERO");
            batalla.atacar(cartaJugador, cartaCPU);

            if (cartaCPU.getVida() > 0) {
                System.out.println("\n>>> LA COMPUTADORA ATACA");
                batalla.atacar(cartaCPU, cartaJugador);
            }

            // RESULTADOS
            System.out.println("\n--- RESULTADO ---");
            System.out.println("Tu carta: " + cartaJugador);
            System.out.println("Carta computadora: " + cartaCPU);

            // CARTA DEL JUGADOR MUERE
            if (cartaJugador.getVida() <= 0) {
                System.out.println("\nPerdiste la Batalla");
                contadorCPU++;
                computadora.setRondasG(contadorCPU);

                jugador.getPilaDescarte().push(cartaJugador);
                jugador.getMazo().eliminarCarta(cartaJugador);

                // pasar a siguiente carta del mazo
                if (jugador.getMazo().tamaño() > 0) {
                    cartaJugador = jugador.getMazo().obtener(0);
                } else {
                    cartaJugador = null;
                }
            } // CARTA DE CPU MUERE
            else if (cartaCPU.getVida() <= 0) {
                System.out.println("\nGanaste la Batalla");
                contadorJugador++;
                jugador.setRondasG(contadorJugador);

                computadora.getPilaDescarte().push(cartaCPU);
                computadora.getMazo().eliminarCarta(cartaCPU);

                // CPU toma nueva carta
                if (computadora.getMazo().tamaño() > 0) {
                    int nueva = (int) (Math.random() * computadora.getMazo().tamaño());
                    cartaCPU = computadora.getMazo().obtener(nueva);
                } else {
                    cartaCPU = null;
                }
            }

            // Si ambas viven, continúa siguiente ronda automáticamente
        } while (cartaJugador != null && cartaCPU != null);

        // FIN DEL JUEGO
        System.out.println("\n=====================");
        System.out.println("RESULTADOS FINALES");
        System.out.println("=====================");
        System.out.println("Batallas Ganadas: " + contadorJugador);
        System.out.println("Batallas Perdidas: " + contadorCPU);
    }
}
