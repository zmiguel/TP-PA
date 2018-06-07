package ui.graphic;

import Estados.*;
import Logica.Mundo;

import java.awt.*;
import java.io.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Jogo extends JFrame implements Observer {
    Mundo m;

    JLabel cards = new JLabel();
    JLabel action = new JLabel(new ImageIcon("cards/back.png"));
    JLabel enemi = new JLabel(new ImageIcon("cards/enemi.png"));
    JLabel status = new JLabel(new ImageIcon("cards/status.png"));

    public Jogo(Mundo m){
        this.m = m;

        this.setTitle("9Card Siege!");
        this.setResizable(false);

        int cardid;

        setLayout(new BorderLayout(5,5));
        setSize(950,650);

        cards.setAlignmentX(Component.CENTER_ALIGNMENT);
        cards.setAlignmentY(Component.TOP_ALIGNMENT);
        cards.setPreferredSize(new Dimension(915,425));
        cards.setLayout(new FlowLayout());
        //action card
        action.setPreferredSize(new Dimension(305,425));
        cards.add(action);
        //enemi card
        enemi.setPreferredSize(new Dimension(305,425));
        cards.add(enemi);
        //status card
        status.setPreferredSize(new Dimension(305,425));
        cards.add(status);

        add(cards);

    }

    @Override
    public void update(Observable o, Object arg) {
        updateActionCard();
    }

    public void updateActionCard(){
        int cardid = m.getCardID();
        switch (cardid){
            case 1: action.setIcon(new ImageIcon("cards/1.png"));
                break;
            case 2: action.setIcon(new ImageIcon("cards/2.png"));
                break;
            case 3: action.setIcon(new ImageIcon("cards/3.png"));
                break;
            case 4: action.setIcon(new ImageIcon("cards/4.png"));
                break;
            case 5: action.setIcon(new ImageIcon("cards/5.png"));
                break;
            case 6: action.setIcon(new ImageIcon("cards/6.png"));
                break;
            case 7: action.setIcon(new ImageIcon("cards/7.png"));
                break;
            default: break;
        }
    }
}
