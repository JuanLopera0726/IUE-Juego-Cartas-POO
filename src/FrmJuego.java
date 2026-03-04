import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FrmJuego extends JFrame {

    JPanel pnlJugador1, pnlJugador2;
    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();

    public FrmJuego(){
        setSize(500, 300);
        setTitle("Juguemos al apuntado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnRepartir = new JButton("Repartir");
        btnRepartir.setBounds(10,10,100,25);
        add(btnRepartir);

        JButton btnVerificar = new JButton("Verificar");
        btnVerificar.setBounds(120,10,100,25);
        add(btnVerificar);

        JTabbedPane tpJugadores = new JTabbedPane();
        tpJugadores.setBounds(10,50,460,200);
        add(tpJugadores);
        
        // Pestañas
        pnlJugador1 = new JPanel();
        pnlJugador1.setBackground(new Color(0,255,0));

        pnlJugador2 = new JPanel();
        pnlJugador2.setBackground(new Color(0,255,255));

        tpJugadores.addTab("Juan Manuel Lopera", pnlJugador1);
        tpJugadores.addTab("Salomé Ceballos Cardona", pnlJugador2);

        // Eventos
        btnRepartir.addActionListener(e ->{
            repartir();
        });
        
    }

    private void repartir(){
       jugador1.repartir();
       jugador2.repartir();

       jugador1.mostrar(pnlJugador1);
       jugador2.mostrar(pnlJugador2);
       
    }


}
