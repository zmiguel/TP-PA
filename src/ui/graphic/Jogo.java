package ui.graphic;

import Estados.*;
import Logica.Mundo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Jogo extends JFrame implements Observer {
    Mundo m;

    JLabel cards = new JLabel();
    JLabel action = new JLabel(new ImageIcon("cards/back.png"));
    JLabel enemi = new JLabel(new ImageIcon("cards/enemi.png"));
    JLabel status = new JLabel(new ImageIcon("cards/status.png"));

    //current day
    JLabel ActionTracker = new JLabel();

    //enemy trackers
    JLabel LadderTrack = new JLabel();
    JLabel RamTrack = new JLabel();
    JLabel SiegeTrack = new JLabel();
    JLabel TreTrack = new JLabel();

    //status trackers
    JLabel WallTrack = new JLabel();
    JLabel MoraleTrack = new JLabel();
    JLabel SuppliesTrack = new JLabel();
    JLabel TunnelTrack = new JLabel();
    JLabel RaidedTrack = new JLabel();

    //botoes
    JLabel bArea = new JLabel();
    JButton ArcAttack = new JButton("Archers Attack");
    JButton BoilAttack = new JButton("Boiling Water Attack");
    JButton CloseAttack = new JButton("Close Combat Attack");
    JButton Coupure = new JButton("Coupure");
    JButton Rally = new JButton("Rally Troops");
    JButton TunnelMovement = new JButton("Tunnel Movement");
    JButton Raid = new JButton("Supply Raid");
    JButton Sabotage = new JButton("Sabotage");


    public Jogo(Mundo m){
        this.m = m;

        this.setTitle("9Card Siege!");
        this.setResizable(false);

        int cardid;
        //window settings
        setLayout(null);
        setSize(950,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //cards settings
        cards.setBounds(0,0,950, 450);
        cards.setLayout(null);
        //action card
        action.setBounds(5,5,305,425);
        cards.add(action);
        //enemy card
        enemi.setBounds(315,5,305,425);
        cards.add(enemi);
        //status card
        status.setBounds(625,5,305,425);
        cards.add(status);
        //trackers settings
        //action
        ActionTracker.setBorder(new LineBorder(Color.red, 10));
        ActionTracker.setBounds(5,5,295,140);
        action.add(ActionTracker);
        //enemy
        LadderTrack.setOpaque(true);
        LadderTrack.setBackground(Color.red);
        LadderTrack.setBorder(new LineBorder(Color.BLACK));
        LadderTrack.setBounds(32,295,25,25);
        enemi.add(LadderTrack);
        RamTrack.setOpaque(true);
        RamTrack.setBackground(Color.red);
        RamTrack.setBorder(new LineBorder(Color.BLACK));
        RamTrack.setBounds(135,295,25,25);
        enemi.add(RamTrack);
        SiegeTrack.setOpaque(true);
        SiegeTrack.setBackground(Color.red);
        SiegeTrack.setBorder(new LineBorder(Color.BLACK));
        SiegeTrack.setBounds(240,295,25,25);
        enemi.add(SiegeTrack);
        TreTrack.setOpaque(true);
        TreTrack.setBackground(Color.blue);
        TreTrack.setBorder(new LineBorder(Color.BLACK));
        TreTrack.setBounds(240,380,25,25);
        enemi.add(TreTrack);
        //status
        WallTrack.setOpaque(true);
        WallTrack.setBackground(Color.green);
        WallTrack.setBorder(new LineBorder(Color.BLACK));
        WallTrack.setBounds(32,25,25,25);
        status.add(WallTrack);
        MoraleTrack.setOpaque(true);
        MoraleTrack.setBackground(Color.green);
        MoraleTrack.setBorder(new LineBorder(Color.BLACK));
        MoraleTrack.setBounds(125,25,25,25);
        status.add(MoraleTrack);
        SuppliesTrack.setOpaque(true);
        SuppliesTrack.setBackground(Color.green);
        SuppliesTrack.setBorder(new LineBorder(Color.BLACK));
        SuppliesTrack.setBounds(225,25,25,25);
        status.add(SuppliesTrack);
        TunnelTrack.setOpaque(true);
        TunnelTrack.setBackground(Color.black);
        TunnelTrack.setBorder(new LineBorder(Color.white));
        TunnelTrack.setBounds(20,380,25,25);
        status.add(TunnelTrack);
        RaidedTrack.setOpaque(true);
        RaidedTrack.setBackground(Color.yellow);
        RaidedTrack.setBorder(new LineBorder(Color.black));
        RaidedTrack.setBounds(325,350,25,25);
        status.add(RaidedTrack);
        //add cards and trackers to window
        add(cards);

        //botoes
        //area dos botoes
        bArea.setBounds(0,450,600,200);
        bArea.setLayout(new FlowLayout());
        //botoes em si

        bArea.add(ArcAttack);
        bArea.add(BoilAttack);
        bArea.add(CloseAttack);
        bArea.add(Coupure);
        bArea.add(Rally);
        bArea.add(TunnelMovement);
        bArea.add(Raid);
        bArea.add(Sabotage);
        add(bArea);

    }

    @Override
    public void update(Observable o, Object arg) {
        updateActionCard();
        updateTrackers();
        updateValidActions();
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

    public void updateTrackers(){
        //action card day
        int dia = m.ST().getDia();
        switch (dia){
            case 0: ActionTracker.setBounds(5,5,295,140);
                break;
            case 1: ActionTracker.setBounds(5,305,295,140);
                break;
            case 2: ActionTracker.setBounds(5,605,295,140);
                break;
            default: ActionTracker.setBounds(5,5,295,140);
                break;
        }
        //enemy tracker
        int ladder = m.ET().getPosLadder();
        switch (ladder){
            case 0: LadderTrack.setBounds(105,25,25,25);
                break;
            case 1: LadderTrack.setBounds(32,85,25,25);
                break;
            case 2: LadderTrack.setBounds(32,155,25,25);
                break;
            case 3: LadderTrack.setBounds(32,225,25,25);
                break;
            case 4: LadderTrack.setBounds(32,295,25,25);
                break;
            default: LadderTrack.setBounds(32,295,25,25);
                break;
        }
        int ram = m.ET().getPosBatteringRam();
        switch (ram){
            case 0: RamTrack.setBounds(135,25,25,25);
                break;
            case 1: RamTrack.setBounds(135,85,25,25);
                break;
            case 2: RamTrack.setBounds(135,155,25,25);
                break;
            case 3: RamTrack.setBounds(135,225,25,25);
                break;
            case 4: RamTrack.setBounds(135,295,25,25);
                break;
            default: RamTrack.setBounds(135,295,25,25);
                break;
        }
        if(!m.ET().isSiegeTower()) SiegeTrack.setVisible(false);
        int siege = m.ET().getPosSiegeTower();
        switch (siege){
            case 0: SiegeTrack.setBounds(170,25,25,25);
                break;
            case 1: SiegeTrack.setBounds(240,85,25,25);
                break;
            case 2: SiegeTrack.setBounds(240,155,25,25);
                break;
            case 3: SiegeTrack.setBounds(240,225,25,25);
                break;
            case 4: SiegeTrack.setBounds(240,295,25,25);
                break;
            default: SiegeTrack.setBounds(240,295,25,25);
                break;
        }
        int tre = m.ET().getTrebuchet();
        switch (tre){
            case 1: TreTrack.setBounds(35,375,25,25);
                break;
            case 2: TreTrack.setBounds(140,375,25,25);
                break;
            case 3: TreTrack.setBounds(240,375,25,25);
                break;
            default: TreTrack.setBounds(240,375,25,25);
                break;
        }
        //status tracker
        int wall = m.ST().getWall();
        switch (wall){
            case 0: WallTrack.setBounds(95,310,25,25);
                break;
            case 1: WallTrack.setBounds(32,235,25,25);
                break;
            case 2: WallTrack.setBounds(32,165,25,25);
                break;
            case 3: WallTrack.setBounds(32,95,25,25);
                break;
            case 4: WallTrack.setBounds(32,25,25,25);
                break;
            default: WallTrack.setBounds(32,25,25,25);
                break;
        }
        int morale = m.ST().getMorale();
        switch (morale){
            case 0: MoraleTrack.setBounds(125,310,25,25);
                break;
            case 1: MoraleTrack.setBounds(125,235,25,25);
                break;
            case 2: MoraleTrack.setBounds(125,165,25,25);
                break;
            case 3: MoraleTrack.setBounds(125,95,25,25);
                break;
            case 4: MoraleTrack.setBounds(125,25,25,25);
                break;
            default: MoraleTrack.setBounds(125,25,25,25);
                break;
        }
        int supplies = m.ST().getSupplies();
        switch (supplies){
            case 0: SuppliesTrack.setBounds(155,310,25,25);
                break;
            case 1: SuppliesTrack.setBounds(225,235,25,25);
                break;
            case 2: SuppliesTrack.setBounds(225,165,25,25);
                break;
            case 3: SuppliesTrack.setBounds(225,95,25,25);
                break;
            case 4: SuppliesTrack.setBounds(225,25,25,25);
                break;
            default: SuppliesTrack.setBounds(225,25,25,25);
             break;
        }
        int tunn = m.ST().getTunnel();
        switch (tunn){
            case 0: TunnelTrack.setBounds(20,380,25,25);
                break;
            case 1: TunnelTrack.setBounds(65,380,25,25);
                break;
            case 2: TunnelTrack.setBounds(115,380,25,25);
                break;
            case 3: TunnelTrack.setBounds(165,380,25,25);
                break;
            default: TunnelTrack.setBounds(20,380,25,25);
                break;
        }
        int raided = m.ST().getStolenSupplies();
        switch (raided){
            case 0: RaidedTrack.setBounds(325,350,25,25);
                break;
            case 1: RaidedTrack.setBounds(230,380,25,25);
                break;
            case 2: RaidedTrack.setBounds(230,330,25,25);
                break;
            default: RaidedTrack.setBounds(325,350,25,25);
                break;
        }
    }

    public void updateValidActions(){
        
    }
}