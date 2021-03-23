package calculadora;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
//genera el panel que contiene todos los numeros, la coma y el signo igual
public class PadNumerico extends JPanel {

    private JButton[][] botones;

    public PadNumerico() {
        initComponentes();
    }

    private void initComponentes() {

        botones = new JButton[4][3];

        //Inicializa los botones
        int contador = 9;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                botones[i][j] = new JButton(String.valueOf(contador));
                contador--;
            }
        }

        botones[3][0] = new JButton("0");
        botones[3][1] = new JButton(".");
        botones[3][2] = new JButton("=");

        //Agrega los botones al panel
        this.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                this.add(botones[i][j]);
            }
        }
    }

    public JButton[][] getBotones() {
        return botones;
    }

    //test
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new PadNumerico());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
