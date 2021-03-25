package calculadora;

import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JTextArea;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class TextoCalculadora extends JTextArea {

    private final int FONT_SIZE = 18;
    private final int LIMITE_ESCRITURA = 10;
    
    public final int CARACTERES_MAXIMOS = 19;

    public TextoCalculadora() {
        this.setEditable(false);
        this.setFont(new Font("monospaced", Font.PLAIN, FONT_SIZE));
        this.setRows(1);
        this.setColumns(CARACTERES_MAXIMOS);
    }

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

    public void concat(String s) {
        if (this.getText().length() + s.length() < LIMITE_ESCRITURA) {
            this.setText(this.getText() + s);
        }
    }
}
