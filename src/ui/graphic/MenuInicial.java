package ui.graphic;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuInicial extends JFrame {
    JPanel Painel;
    JButton IniciarJogo;
    JButton ContinuarJogo;
    JButton Sair;

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem menuItemLoad, menuItemSair;

    Icon iconIniciar = new ImageIcon("inicio.png");
    Icon iconSair = new ImageIcon("sair.png");

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

        menuBar = new JMenuBar();

        menu = new JMenu("Ficheiro");
        menuBar.add(menu);
        menuItemLoad = new JMenuItem("Carregar Jogo");
        menu.add(menuItemLoad);
        menuItemSair = new JMenuItem("Sair");
        menu.add(menuItemSair);

        setJMenuBar(menuBar);


        IniciarJogo = new JButton("Iniciar Jogo",iconIniciar);
        IniciarJogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        background.add(IniciarJogo);
        
        Sair = new JButton("Sair", iconSair);
        Sair.setAlignmentX(Component.CENTER_ALIGNMENT);
        background.add(Sair);
    }

    public void addListener(ActionListener cont, JButton b){
        b.addActionListener(cont);
    }

    public void addListener(ActionListener cont, JMenuItem i){
        i.addActionListener(cont);
    }

    public JButton getB_Iniciar(){
        return IniciarJogo;
    }

    public JMenuItem getM_Load(){return menuItemLoad;}

    public JMenuItem getM_Sair(){return menuItemSair;}

    public JButton getB_Sair(){
        return Sair;
    }
}
