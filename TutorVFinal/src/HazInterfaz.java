import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HazInterfaz extends JFrame {
    JPanel panelBotones = new JPanel();
    JButton btn[] = new JButton[3];
    String[] nombreBotones = {"Compilar","Ejecutar","Ayuda"};


    public void inicializa(){
        this.inicializaPBotones();
        this.inicalizaPProblemas();
        this.inicializaPResolucion();
    }

    public void inicializaPBotones(){
        panelBotones.setLayout(new BoxLayout(panelBotones,BoxLayout.Y_AXIS));
        for(int i = 0;i < btn.length; i++){
            btn[i]= new JButton(nombreBotones[i]);
            panelBotones.add(new JLabel());
            panelBotones.add(new JLabel());
            panelBotones.add(new JLabel());
            panelBotones.add(btn[i]);
        }
        this.add(panelBotones,BorderLayout.EAST);
    }

    public void inicalizaPProblemas(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        String problema = "Hacer un programa en java que imprima Hola Mundo";
        panel.add(new JLabel(problema), BorderLayout.NORTH);
        this.add(panel,BorderLayout.NORTH);
    }

    public void inicializaPResolucion(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextArea txtAreaSol = new JTextArea(40,30); //número de filas y columnas
        txtAreaSol.setText("public static void main(String[] args) {\n" +
                "        \n" +
                "    }");
        panel.add(txtAreaSol,BorderLayout.CENTER);
        this.add(panel,BorderLayout.WEST);
    }

    public HazInterfaz() throws HeadlessException {
        this.setLocationRelativeTo(null);
        this.setSize(600,600);
        this.setResizable(false);
        this.setVisible(true);
        this.inicializa();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
