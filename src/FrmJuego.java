import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FrmJuego extends JFrame {

    JPanel pnlJugador1, pnlJugador2;
    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();

    JTabbedPane tpJugadores;

    public FrmJuego() {
        setSize(500, 300);
        setTitle("Juguemos al apuntado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnRepartir = new JButton("Repartir");
        btnRepartir.setBounds(10, 10, 100, 25);
        add(btnRepartir);

        JButton btnVerificar = new JButton("Grupos");
        btnVerificar.setBounds(120, 10, 100, 25);
        add(btnVerificar);

        JButton btnEscalera = new JButton("Escalera");
        btnEscalera.setBounds(230, 10, 100, 25);
        add(btnEscalera);

        JButton btnPuntuacion = new JButton("Puntuación");
        btnPuntuacion.setBounds(340, 10, 100, 25);
        add(btnPuntuacion);

        tpJugadores = new JTabbedPane();
        tpJugadores.setBounds(10, 50, 460, 200);
        add(tpJugadores);

        // Pestañas
        pnlJugador1 = new JPanel();
        pnlJugador1.setBackground(new Color(128, 0, 128));

        pnlJugador2 = new JPanel();
        pnlJugador2.setBackground(new Color(0, 187, 45));

        tpJugadores.addTab("Juan Manuel Lopera", pnlJugador1);
        tpJugadores.addTab("Salomé Ceballos Cardona", pnlJugador2);

        // Eventos
        btnRepartir.addActionListener(e -> {
            repartir();
        });

        btnVerificar.addActionListener(e -> {
            verificarGrupos();
        });

        btnEscalera.addActionListener(e -> {
            verificarEscalera();
        });

        btnPuntuacion.addActionListener(e -> {
            puntuacion();
        });
    }

    private void repartir() {
        jugador1.repartir();
        jugador2.repartir();

        jugador1.mostrar(pnlJugador1);
        jugador2.mostrar(pnlJugador2);

    }

    private void verificarGrupos() {
        if (tpJugadores.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, jugador1.getGrupos());
        } else {
            JOptionPane.showMessageDialog(null, jugador2.getGrupos());
        }
    }

    private void verificarEscalera() {
        if (tpJugadores.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, jugador1.getEscalera());
        } else {
            JOptionPane.showMessageDialog(null, jugador2.getEscalera());
        }
    }

    private void puntuacion() {
        if (tpJugadores.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, jugador1.getPuntuacion());
        } else {
            JOptionPane.showMessageDialog(null, jugador2.getPuntuacion());
        }
    }

}
