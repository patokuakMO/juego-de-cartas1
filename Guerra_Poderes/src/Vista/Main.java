package Vista;

import Modelo.Carta;
import Controlador.JuegoGuerra;
import Controlador.MotorBatalla;
import Modelo.Jugador;
import Modelo.Pila;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Pila pilaDerrotadas = new Pila();
        int contadorJugador = 0;
        Pila pilaDerrotadasCPU = new Pila();
        int contadorCPU = 0;

        // -----------------------------
        // 1. CREAR JUGADORES
        // -----------------------------
        System.out.print("Ingrese nombre del jugador: ");
        String nombreJugador = sc.nextLine();

        Jugador jugador = new Jugador(nombreJugador);
        Jugador computadora = new Jugador("Computadora");

        // -----------------------------
        // 2. CREAR CARTAS DE EJEMPLO
        // -----------------------------
        Carta c1 = new Carta("Flamix", 100, 25, 5, "Fuego", "Agua");
        Carta c2 = new Carta("Aquaron", 120, 20, 5, "Agua", "Planta");
        Carta c3 = new Carta("Leafy", 90, 30, 5, "Planta", "Fuego");

        Carta e1 = new Carta("Robotron", 110, 22, 5, "Metal", "Fuego");
        Carta e2 = new Carta("MagmaDog", 95, 27, 5, "Fuego", "Agua");
        Carta e3 = new Carta("Hydrax", 130, 18, 5, "Agua", "Planta");

        // -----------------------------
        // 3. AGREGAR AL MAZO DEL JUGADOR
        // -----------------------------
        jugador.getMazo().agregarCarta(c1);
        jugador.getMazo().agregarCarta(c2);
        jugador.getMazo().agregarCarta(c3);

        computadora.getMazo().agregarCarta(e1);
        computadora.getMazo().agregarCarta(e2);
        computadora.getMazo().agregarCarta(e3);

        // -----------------------------
        // 4. INICIAR JUEGO
        // -----------------------------
        JuegoGuerra juego = new JuegoGuerra(jugador, computadora);
        juego.iniciar();

        System.out.println("\nTUS CARTAS:");
        for (int i = 0; i < jugador.getMazo().tamaño(); i++) {
            System.out.println(i + ". " + jugador.getMazo().obtener(i));
        }

        // -----------------------------
        // 5. SELECCIONAR CARTA DEL JUGADOR
        // -----------------------------
        System.out.print("\nSelecciona una carta para combatir: ");
        int indice = sc.nextInt();

        Carta cartaJugador = jugador.getMazo().obtener(indice);

        // -----------------------------
        // 6. COMPUTADORA ELIGE CARTA AL AZAR
        // -----------------------------
        int aleatoria = (int) (Math.random() * computadora.getMazo().tamaño());
        Carta cartaCPU = computadora.getMazo().obtener(aleatoria);

        System.out.println("\nLa computadora elige: " + cartaCPU.getNombre());
        
        do {
            // -----------------------------
            // 7. COMBATE
            // -----------------------------
            System.out.println("\n>>> TU ATACAS PRIMERO");
            MotorBatalla.atacar(cartaJugador, cartaCPU);

            if (cartaCPU.getVida() > 0) {
                System.out.println("\n>>> LA COMPUTADORA ATACA");
                MotorBatalla.atacar(cartaCPU, cartaJugador);
            }
            // -----------------------------
            // 8. RESULTADOS
            // -----------------------------
            System.out.println("\n--- RESULTADO ---");
            System.out.println("Tu carta: " + cartaJugador);
            System.out.println("Carta computadora: " + cartaCPU);

            //se debe desencolar la carta perdedora
            //se debe encolar la carta que perdio a una pila diferente de perdida
            //se debe aumentar un contador para TablaHash en ronda perdida
            //se deben mejorar la carta que ganó, recibir un mini-boost
            // Si la carta del jugador muere
            if (cartaJugador.getVida() <= 0) {
                System.out.println("\nPerdiste la Batalla");
                contadorJugador++;
                pilaDerrotadas.push(cartaJugador);
                jugador.getMazo().eliminarCarta(cartaJugador);// quitamos la varta perdedora del mazo
                cartaJugador = jugador.getMazo().obtener(indice + 1); //siguiente carta
            } else // Si la carta de la CPU muere
            if (cartaCPU.getVida() <= 0) {
                System.out.println("\nGanaste la Batalla");
                contadorCPU++;
                pilaDerrotadasCPU.push(cartaCPU);
                jugador.getMazo().eliminarCarta(cartaCPU);
                cartaCPU = computadora.getMazo().obtener(aleatoria); // saca nueva carta
            } else {
                System.out.println("\nAmbas cartas siguen con vida.");
            }
        } while (jugador.tieneCartas(jugador.getMazo())
                && computadora.tieneCartas(computadora.getMazo())
                && cartaJugador != null
                && cartaCPU != null);
        sc.close();
        //===========================FINAL============================
        System.out.println(jugador.getNombre()+" Batallas Ganadas: "+contadorCPU);
        System.out.println(jugador.getNombre()+" Batallas perdidas: "+contadorJugador);
    }
}
