package calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Alberto López Puertas
 * <https://github.com/alopezp90>
 */
public class Calculadora extends JFrame {

    private Pantalla pantalla;
    private Pad pad;
    private Double memoria;
    
    private boolean resultadoReciente;

    public Calculadora() {
        initComponentes();
    }

    private void initComponentes() {
        this.pantalla = new Pantalla();
        this.pad = new Pad();

        agregaListeners();

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(
                new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().add(pantalla);
        this.getContentPane().add(pad);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void agregaListeners() {
        //escritura
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 3 || j != 2) { //todos menos el signo igual
                    pad.getPadNumerico().getBotones()[i][j].addActionListener(
                            new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            if(resultadoReciente){
                                pantalla.getTexto().limpiar();
                            }
                            JButton btn = (JButton) ae.getSource();
                            String txt = btn.getText();
                            if(txt.equals(".") && pantalla.getTexto().getText().equals("")) {
                                pantalla.getTexto().setText("0");
                            }
                            pantalla.getTexto().concat(txt);
                            activarSimbolos(true);
                        }
                    });
                }
            }
        }

        //signo igual
        pad.getPadNumerico().getBotones()[3][2].addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                realizarOperacion();
            }
        });
        //signo dividir
        pad.getPadSimbolico().getBotones()[0][0].addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                memoria = Double.parseDouble(pantalla.getTexto().getText());
                pantalla.getTexto().limpiar();
                JButton btn = (JButton) ae.getSource();
                String txt = btn.getText();
                pantalla.getOperacion().setText(txt);
                activarSimbolos(false);
                resultadoReciente = false;
            }
        });
        //signo porcentaje
        pad.getPadSimbolico().getBotones()[0][1].addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                memoria = Double.parseDouble(pantalla.getTexto().getText());
                pantalla.getTexto().limpiar();
                JButton btn = (JButton) ae.getSource();
                String txt = btn.getText();
                pantalla.getOperacion().setText(txt);
                activarSimbolos(false);
                resultadoReciente = false;
            }
        });
        //signo multiplicar
        pad.getPadSimbolico().getBotones()[1][0].addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                memoria = Double.parseDouble(pantalla.getTexto().getText());
                pantalla.getTexto().limpiar();
                JButton btn = (JButton) ae.getSource();
                String txt = btn.getText();
                pantalla.getOperacion().setText(txt);
                activarSimbolos(false);
                resultadoReciente = false;
            }
        });
        //signo masmenos
        pad.getPadSimbolico().getBotones()[1][1].addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!pantalla.getTexto().getText().equals("")) {
                    pantalla.getTexto().cambiaSigno();
                    resultadoReciente = false;
                }
            }
        });
        //signo menos
        pad.getPadSimbolico().getBotones()[2][0].addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                memoria = Double.parseDouble(pantalla.getTexto().getText());
                pantalla.getTexto().limpiar();
                JButton btn = (JButton) ae.getSource();
                String txt = btn.getText();
                pantalla.getOperacion().setText(txt);
                activarSimbolos(false);
                resultadoReciente = false;
            }
        });
        //signo C
        pad.getPadSimbolico().getBotones()[2][1].addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pantalla.getTexto().limpiar();
                resultadoReciente = false;
            }
        });
        //signo mas
        pad.getPadSimbolico().getBotones()[3][0].addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                memoria = Double.parseDouble(pantalla.getTexto().getText());
                pantalla.getTexto().limpiar();
                JButton btn = (JButton) ae.getSource();
                String txt = btn.getText();
                pantalla.getOperacion().setText(txt);
                activarSimbolos(false);
                resultadoReciente = false;
            }
        });
        //signo R
        pad.getPadSimbolico().getBotones()[3][1].addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                memoria = 0.0;
                pantalla.getTexto().limpiar();
                resultadoReciente = false;
            }
        });
    }

    private void activarSimbolos(boolean bool) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                pad.getPadSimbolico().getBotones()[i][j].setEnabled(bool);
            }
        }
    }

    private void realizarOperacion() {
        switch (pantalla.getOperacion().getText()) {
            case "/":
                memoria /= Double.parseDouble(pantalla.getTexto().getText());
                break;
            case "%":
                memoria *= (Double.parseDouble(pantalla.getTexto().getText())) / 100;
                break;
            case "x":
                memoria *= Double.parseDouble(pantalla.getTexto().getText());
                break;
            case "-":
                memoria -= Double.parseDouble(pantalla.getTexto().getText());
                break;
            case "+":
                memoria += Double.parseDouble(pantalla.getTexto().getText());
                break;
        }
        resultadoReciente = true;
        muestraResultado();
    }

    private void muestraResultado() {
        String resultado = String.valueOf(memoria);
        if (resultado.length() < pantalla.getTexto().CARACTERES_MAXIMOS) {
            pantalla.getTexto().setText(resultado);
        } else {
            pantalla.getTexto().setText(resultado.substring(0, pantalla.getTexto().CARACTERES_MAXIMOS - 1));
        }
    }

    private void guarda() {
        if (pantalla.getTexto().getText().equals("")) {
            memoria = 0.0;
        } else {
            memoria = Double.parseDouble(pantalla.getTexto().getText());
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
