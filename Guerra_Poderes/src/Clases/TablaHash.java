package Clases;

import java.util.HashMap;

/**
 *Guarda estadísticas del jugador.
 * @author Tilines
 */
public class TablaHash {
        private HashMap<String, Integer> datos = new HashMap<>();

    public void setDato(String clave, Integer valor) {
        datos.put(clave, valor);
    }

    public Integer getDato(String clave) {
        return datos.getOrDefault(clave, 0);
    }
}
