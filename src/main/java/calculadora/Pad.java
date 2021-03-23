package calculadora;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class Pad extends JPanel {

    private PadNumerico padNumerico;
    private PadSimbolico padSimbolico;

    public Pad() {
        initComponentes();
    }

    private void initComponentes() {
        this.padNumerico = new PadNumerico();
        this.padSimbolico = new PadSimbolico();
        
        this.add(padNumerico);
        this.add(padSimbolico);
    }

    public PadNumerico getPadNumerico() {
        return padNumerico;
    }

    public PadSimbolico getPadSimbolico() {
        return padSimbolico;
    }
    
    //test
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(new Pad());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
