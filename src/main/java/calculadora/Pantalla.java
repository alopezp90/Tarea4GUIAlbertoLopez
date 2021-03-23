package calculadora;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Alberto López Puertas 
 * <https://github.com/alopezp90>
 */

public class Pantalla extends JPanel{
    
    private JLabel operacion;
    private TextoCalculadora texto;
    
    public Pantalla() {
        initComponentes();
    }
    
    public void initComponentes() {
        
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        operacion = new JLabel(" ");
        operacion.setFont(new Font("monospaced", Font.PLAIN, 14));
        
        texto = new TextoCalculadora();
        
        this.setLayout(new FlowLayout());
        this.add(operacion);
        this.add(texto);
    }
    
    //test
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(
                new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(new Pantalla());
        frame.getContentPane().add(new Pad());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
