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

    public String getGrupos(){
        int[] contadores = new int[NombreCarta.values().length];

        for (Carta carta : cartas){
            // Oirdinal para enumerados
            contadores[carta.getNombre().ordinal()]++;
        }

        String grupos = "";
        for (int i=0; i< contadores.length; i++){
            if (contadores[i]>=2){
                grupos += Grupo.values()[contadores[i]]+" DE "+ NombreCarta.values()[i]+ "\n";
            }
        }
        return grupos.isEmpty() ? "No hay grupos" : "Se encontraron los siguientes grupos:\n"+grupos;
    }

}
