package Controlador;

import Modelo.Carta;

public class MotorBatalla {

    public void atacar(Carta atacante, Carta objetivo) {
        int ataque = atacante.getAtaque();
        int dano;

        // Relación elemental
        if (atacante.getElemento().equals(objetivo.getDebilidad())) {
            dano = (int)(ataque * 1.2);
        } else if (atacante.getDebilidad().equals(objetivo.getElemento())) {
            dano = (int)(ataque * 0.7);
        } else {
            dano = ataque;
        }

        if (objetivo.getVida() > 0 && atacante.getEnergia() > 0) {
            objetivo.setVida(objetivo.getVida() - dano);
            System.out.println(atacante.getNombre() + " ataca a " + objetivo.getNombre() + " causando " + dano + " de daño.");
            System.out.println("Vida restante de " + objetivo.getNombre() + ": " + objetivo.getVida());

            atacante.setEnergia(atacante.getEnergia() - 1);
        }

        if (objetivo.getVida() <= 0) {
            System.out.println(objetivo.getNombre() + " ha sido derrotado.");
        }
    }
}