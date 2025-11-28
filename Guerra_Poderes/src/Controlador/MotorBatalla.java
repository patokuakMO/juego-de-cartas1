package Controlador;

import Modelo.Carta;

public class MotorBatalla {

    public void atacar(Carta atacante, Carta objetivo) {

        int ataque = atacante.getAtaque();
        double daño;

        // Relación elemental
        if (atacante.getElemento().equals(objetivo.getDebilidad())) {
            daño = ataque * 1.2;
        } else if (atacante.getDebilidad().equals(objetivo.getElemento())) {
            daño = ataque * 0.7;
        } else {
            daño = ataque;
        }

        if (objetivo.getVida() > 0 && atacante.getEnergia() > 0) {
            // Aplicar daño
            objetivo.setVida(objetivo.getVida() - (int) daño);
        }
        if (atacante.getEnergia() != 0){
            // Consumir energía
            atacante.setEnergia(atacante.getEnergia() - 1);
        } else {
            atacante.setEnergia(1);
        }

        if (objetivo.getVida() <= 0) {
            System.out.println(objetivo.getNombre() + " ha sido derrotado.");
        }
    }
}
