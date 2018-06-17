package controler;

import Estados.*;
import ui.graphic.*;
import Logica.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Observable;
import java.util.Observer;


public class Controler implements ActionListener{
    private volatile Mundo m;
    private MenuInicial mi;
    private Jogo j;
    boolean sair;

    public Controler(Mundo m, MenuInicial mi, Jogo j){
        this.m = m;
        this.mi = mi;
        this.j = j;
        m.addObserver(j);

        //menu iniciar listeners
        mi.addListener(this, mi.getB_Iniciar());
        mi.addListener(this, mi.getB_Continuar());
        mi.addListener(this, mi.getB_Sair());
        mi.addListener(this, mi.getM_Load());
        mi.addListener(this, mi.getM_Sair());

        //jogo listeners
        j.addListener(this,j.getB_ArcAttack());
        j.addListener(this,j.getB_ArcAttackLadder());
        j.addListener(this,j.getB_ArcAttackRam());
        j.addListener(this,j.getB_ArcAttackSiege());
        j.addListener(this,j.getB_BoilAttack());
        j.addListener(this,j.getB_BoilAttackLadder());
        j.addListener(this,j.getB_BoilAttackRam());
        j.addListener(this,j.getB_BoilAttackSiege());
        j.addListener(this,j.getB_CloseAtack());
        j.addListener(this,j.getB_CloseAtackLadder());
        j.addListener(this,j.getB_CloseAtackRam());
        j.addListener(this,j.getB_CloseAtackSiege());
        j.addListener(this,j.getB_Coupure());
        j.addListener(this,j.getB_Rally());
        j.addListener(this,j.getB_RallyNoSupp());
        j.addListener(this,j.getB_RallySupp());
        j.addListener(this,j.getB_TunnelMovement());
        j.addListener(this,j.getB_Sabotage());
        j.addListener(this,j.getB_SupplyRaid());
        j.addListener(this,j.getB_Gravar());
        j.addListener(this,j.getB_SkipTurn());
        j.addListener(this,j.getB_SkipAction());
        j.addListener(this, j.getM_Save());
        j.addListener(this, j.getM_Sair());
    }

    public void run() {
        while (!sair) {
            IEstados estado = m.getEstado();

            if (estado instanceof EsperaInicio) {
                mi.setVisible(true);
            } else if (estado instanceof EsperaCarta) {
                cartaVirada();
            } else if (estado instanceof AguardaAcao) {
                j.setVisible(true);
                if(m.isUpdateDone()==false){
                    updates();
                    m.setUpdateDone(true);
                }
            } else if (estado instanceof FinalDoDia) {
                fimDoDia();
                m.fimDoDia();
            } else if (estado instanceof JogoTerminado) {
                fimDoJogo();
                sair = true;
            }else{
                System.out.println("¯\\_(ツ)_/¯");
            }
        }
    }

    public void cartaVirada() {
        mi.setVisible(false);
        m.viraCarta();
        j.setVisible(true);
        updates();

    }
    public void updates(){
        j.updateMundo(m);
        System.out.println("Update Action");
        j.updateActionCard();
        System.out.println("Update Trackers");
        j.updateTrackers();
        System.out.println("Update actions remaining");
        j.updateActionsRemaining();
        System.out.println("Update Valid");
        j.updateValidActions();
        j.updateDado();
        j.updateTurno();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object origem = e.getSource();
        //Menu iniciar
        if(origem == (mi.getB_Iniciar())){
            m.jogo();
        }
        if(origem == (mi.getB_Continuar())){
            LoadGame();
            mi.setVisible(false);
            m.setUpdateDone(false);
        }
        if(origem == (mi.getM_Load())){
            LoadGame();
            mi.setVisible(false);
            m.setUpdateDone(false);
        }
        if(origem == (mi.getB_Sair())){
            System.exit(0);
        }
        if(origem == (mi.getM_Sair())){
            System.exit(0);
        }
        //Jogo
        if(origem == (j.getB_ArcAttack())){
            System.out.println("Arc Attack.....");
            j.openArcMenu();
        }
        if(origem == (j.getB_ArcAttackLadder())){
            System.out.println("Arc Attack.....");
            m.acoes(1,1);
        }
        if(origem == (j.getB_ArcAttackRam())){
            System.out.println("Arc Attack.....");
            m.acoes(1,2);
        }
        if(origem == (j.getB_ArcAttackSiege())){
            System.out.println("Arc Attack.....");
            m.acoes(1,3);
        }
        if(origem == (j.getB_BoilAttack())){
            System.out.println("Boil Attack.....");
            j.openBoilMenu();
        }
        if(origem == (j.getB_BoilAttackLadder())){
            System.out.println("Boil Attack.....");
            m.acoes(2,1);
        }
        if(origem == (j.getB_BoilAttackRam())){
            System.out.println("Boil Attack.....");
            m.acoes(2,2);
        }
        if(origem == (j.getB_BoilAttackSiege())){
            System.out.println("Boil Attack.....");
            m.acoes(2,3);
        }
        if(origem == (j.getB_CloseAtack())){
            System.out.println("Close Attack.....");
            j.openCloseMenu();
        }
        if(origem == (j.getB_CloseAtackLadder())){
            System.out.println("Close Attack.....");
            m.acoes(3,1);
        }
        if(origem == (j.getB_CloseAtackRam())){
            System.out.println("Close Attack.....");
            m.acoes(3,2);
        }
        if(origem == (j.getB_CloseAtackSiege())){
            System.out.println("Close Attack.....");
            m.acoes(3,3);
        }
        if(origem == (j.getB_Coupure())){
            System.out.println("Coupure.....");
            m.acoes(4,0);
        }
        if(origem == (j.getB_Rally())){
            System.out.println("Rally.....");
            j.openRallyMenu();
        }
        if(origem == (j.getB_RallyNoSupp())){
            System.out.println("Rally.....");
            m.acoes(5,0);
        }
        if(origem == (j.getB_RallySupp())){
            System.out.println("Rally.....");
            m.acoes(5,1);
        }
        if(origem == (j.getB_TunnelMovement())){
            System.out.println("Tunnel Movement.....");
            m.acoes(6,0);
        }
        if(origem == (j.getB_SupplyRaid())){
            System.out.println("Raiding.....");
            m.acoes(7,0);
        }
        if(origem == (j.getB_Sabotage())){
            System.out.println("Sabotagem.....");
            m.acoes(8,0);
        }
        //ops
        if(origem == (j.getB_Gravar())){
            System.out.println("Gravar.....");
            SaveGame();
        }
        if(origem == (j.getM_Save())){
            System.out.println("Gravar.....");
            SaveGame();
        }
        if(origem == (j.getB_SkipTurn())){
            System.out.println("Skip Turn.....");
            m.skipTurn();
        }
        if(origem == (j.getB_SkipAction())){
            System.out.println("Skip action.....");
            m.acoes(9,0);
        }
        if(origem == (j.getM_Sair())){
            System.out.println("Sair.....");
            System.exit(0);
        }
    }

    public void fimDoJogo(){
        System.out.println("O JOGO TERMINOU!");
        JOptionPane.showMessageDialog(j,
                "O Jogo Terminou!!",
                "Aviso!",JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }

    public void fimDoDia(){
        System.out.println("final do dia");
        JOptionPane.showMessageDialog(j,
                "Final do Dia",
                "Aviso!",JOptionPane.WARNING_MESSAGE);
    }

    private void LoadGame(){
        JFileChooser fc = new JFileChooser("./saves");
        int returnVal = fc.showOpenDialog(mi);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try{
                m = (Mundo)FileUtility.retrieveGameFromFile(file);
            }catch(IOException | ClassNotFoundException ex){
                JOptionPane.showMessageDialog(mi, "Operation failed: \r\n\r\n");
        }

        } else {
            System.out.println("Operation canceled ");
        }
    }

    private void SaveGame(){
        JFileChooser fc = new JFileChooser("./saves");
        int returnVal = fc.showSaveDialog(j);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try{
                FileUtility.saveGameToFile(file, m);
            }catch(IOException ex){
                JOptionPane.showMessageDialog(j, "Operation failed: \r\n\r\n");
            }
        } else {
            System.out.println("Operation canceled ");
        }
    }
}
