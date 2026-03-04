import java.util.Random;

import javax.swing.JPanel;

public class Jugador {
    // Constante
    private final int TOTAL_CARTAS = 10;
    private final int MARGEN_SUPERIOR = 10;
    private final int MARGEN_IZQUIERDA = 10;
    private final int DISTANCIA_CARTAS = 40;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];
    private Random r = new Random();

    public void repartir(){
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl){
        pnl.removeAll();
        pnl.setLayout(null);
        int posicion = MARGEN_IZQUIERDA + DISTANCIA_CARTAS*(TOTAL_CARTAS-1);
        for (Carta carta : cartas){
            carta.mostrar( posicion, MARGEN_SUPERIOR, pnl);
            posicion -= DISTANCIA_CARTAS;
        }
        pnl.repaint();
    }

}
