package calculadora;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Alberto López Puertas 
 * <https://github.com/alopezp90>
 */

//genera el panel que contiene los simbolos que realizan las operaciones de la calculadora
public class PadSimbolico extends JPanel{

    private JButton[][] botones;

    public PadSimbolico() {
        initComponentes();
    }

    private void initComponentes() {

        botones = new JButton[4][2];

        //Inicializa los botones
        botones[0][0] = new JButton("/");
        botones[1][0] = new JButton("x");
        botones[2][0] = new JButton("+");
        botones[3][0] = new JButton("C");
        
        botones[0][1] = new JButton("%");
        botones[1][1] = new JButton("±");
        botones[2][1] = new JButton("-");
        botones[3][1] = new JButton("R");

        //Agrega los botones al panel
        this.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
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
        frame.add(new PadSimbolico());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
