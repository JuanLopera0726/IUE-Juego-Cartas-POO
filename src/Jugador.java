import java.util.Random;

import javax.swing.JPanel;

public class Jugador {
    // Constantes
    private final int TOTAL_CARTAS = 10;
    private final int MARGEN_SUPERIOR = 10;
    private final int MARGEN_IZQUIERDA = 10;
    private final int DISTANCIA_CARTAS = 40;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];
    private Random r = new Random();

    public void repartir() {
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        pnl.setLayout(null);
        int posicion = MARGEN_IZQUIERDA + DISTANCIA_CARTAS * (TOTAL_CARTAS - 1);
        for (Carta carta : cartas) {
            carta.mostrar(posicion, MARGEN_SUPERIOR, pnl);
            posicion -= DISTANCIA_CARTAS;
        }
        pnl.repaint();
    }

    public String getGrupos() {
        int[] contadores = new int[NombreCarta.values().length];

        for (Carta carta : cartas) {
            // Oirdinal para enumerados
            contadores[carta.getNombre().ordinal()]++;
        }

        String grupos = "";
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                grupos += Grupo.values()[contadores[i]] + " DE " + NombreCarta.values()[i] + "\n";
            }
        }
        // devuelve el resultado si hay o no grupos
        return grupos.isEmpty() ? "No hay grupos" : "Se encontraron los siguientes grupos:\n" + grupos;
    }

    public String getEscalera() {
        // Matriz para ordenar por pinta y valor
        int[][] contadores = new int[Pinta.values().length][NombreCarta.values().length];
        // contar cartas por pinta y valor
        for (Carta carta : cartas) {
            int pinta = carta.getPinta().ordinal();
            int valor = carta.getNombre().ordinal();
            contadores[pinta][valor]++;
        }
        // resultado y booleano para saber si hay escaleras
        String resultado = "Se encontraron las siguientes escaleras:\n";
        int  hayEscalera = 0;
        // recorrer cada pinta
        for (int i = 0; i < contadores.length; i++) {
            // inicio y longitud de la escalera
            int inicio = -1;
            int longitud = 0;
            // recorrer cada valor en cada pinta
            for (int j = 0; j < contadores[i].length; j++) {
                // Si hay cartas de la misma pinta
                if (contadores[i][j] > 0) {
                    if (inicio == -1) {
                        inicio = j;
                    }
                    longitud++;
                } else {
                    // Preguntamos la longitud para saber si hay una escalera
                    if (longitud >= 2) {
                        resultado += Pinta.values()[i] + ": " + NombreCarta.values()[inicio] + " HASTA "
                                + NombreCarta.values()[j - 1] + "\n";
                        hayEscalera = 1;
                    }
                    inicio = -1;
                    longitud = 0;
                }
            }
            // por si la esalera termina al final
            if (longitud >= 2) {
                resultado += Pinta.values()[i] + ": " + NombreCarta.values()[inicio] + " HASTA "
                        + NombreCarta.values()[contadores[i].length - 1] + "\n";
                hayEscalera = 1;
            }
        }
        return hayEscalera == 1 ? resultado : "No hay escaleras en la mano";
    }

    private int valorCarta(NombreCarta nombre) {

        int posicion = nombre.ordinal();
        // Si es As,Jack,Queen,King
        if (posicion >= 9 || posicion == 0) {
            return 10;
        }
        // Si son las cartas normales
        return posicion + 1;
    }

    public String getPuntuacion() {
        int[] cartaUsada = new int[TOTAL_CARTAS];
        int puntuacion = 0;
        // detectar grupos
        for (int i = 0; i < cartas.length; i++) {
            for (int j = i + 1; j < cartas.length; j++) {

                if (cartas[i].getNombre() == cartas[j].getNombre()) {
                    cartaUsada[i] = 1;
                    cartaUsada[j] = 1;
                }
            }
        }
        // detectar escaleras de la misma pinta
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas.length; j++) {
                // Si no son iguales
                if (i != j) {
                    // Si son de la misma pinta
                    if (cartas[i].getPinta() == cartas[j].getPinta()) {

                        int carta1 = cartas[i].getNombre().ordinal();
                        int carta2 = cartas[j].getNombre().ordinal();

                        if (carta1 + 1 == carta2 || carta2 + 1 == carta1) {
                            cartaUsada[i] = 1;
                            cartaUsada[j] = 1;
                        }
                    }
                }
            }
        }
        // sumar cartas no usadas
        for (int i = 0; i < cartas.length; i++) {
            if (cartaUsada[i] != 1) {
                puntuacion += valorCarta(cartas[i].getNombre());
            }
        }
        return "Puntuación del jugador: " + puntuacion;
    }

}
