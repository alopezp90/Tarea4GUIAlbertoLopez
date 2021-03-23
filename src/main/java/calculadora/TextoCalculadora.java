package calculadora;

import javax.swing.JTextArea;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class TextoCalculadora extends JTextArea {
    
    public double limpiar() {
        double memoria = Double.parseDouble(this.getText());
        this.setText("");
        return memoria;
    }
    
    public void cambiaSigno() {
        if (this.getText().charAt(0) == '-') {
            this.setText(this.getText().substring(1));
        } else {
            this.setText("-" + this.getText());
        }
    }    
}
