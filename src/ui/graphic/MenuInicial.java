package ui.graphic;

import com.sun.jdi.InconsistentDebugInfoException;
import ui.graphic.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuInicial extends JFrame {
    JPanel Painel;
    JButton IniciarJogo;

    Icon iconIniciar = new ImageIcon("inicio.png");

    public MenuInicial(){
        this.setTitle("9Card Siege!");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout(5,5));
        setSize(500,500);
        setLocationRelativeTo(null);

        JLabel logo = new JLabel(new ImageIcon("9css.png"));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        logo.setAlignmentY(Component.TOP_ALIGNMENT);
        add(logo,BorderLayout.NORTH);
        logo.setPreferredSize(new Dimension(500,357));

        JLabel background = new JLabel();
        background.setLayout(new FlowLayout());
        add(background,BorderLayout.CENTER);


        IniciarJogo = new JButton("Iniciar Jogo!",iconIniciar);
        IniciarJogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        background.add(IniciarJogo);

    }

    public void addListener(ActionListener cont, JButton b){
        b.addActionListener(cont);
    }

    public JButton getB_Iniciar(){
        return IniciarJogo;
    }
}
