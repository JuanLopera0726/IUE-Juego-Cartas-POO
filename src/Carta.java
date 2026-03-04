import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carta {
    
    private int indice;

    public Carta(Random r){
        this.indice = r.nextInt(52) + 1;

    }

    public void mostrar(int x, int y, JPanel pnl){
        String nombreImagen="imagenes/carta"+indice+ ".jpg";
        ImageIcon imgCarta = new ImageIcon(getClass().getResource(nombreImagen));

        JLabel lblCarta = new JLabel(imgCarta);
        lblCarta.setBounds(x,y, imgCarta.getIconWidth(), imgCarta.getIconHeight());
        pnl.add(lblCarta);
    }

}
