package Logica;

import Estados.*;
import ui.graphic.*;
import Logica.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Observable;
import java.util.Observer;


public class Controler implements ActionListener{
    private Mundo m;
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

        //jogo listeners
        j.addListener(this,j.getB_ArcAttack());
        j.addListener(this,j.getB_BoilAttack());
        j.addListener(this,j.getB_CloseAtack());
        j.addListener(this,j.getB_Coupure());
        j.addListener(this,j.getB_Rally());
        j.addListener(this,j.getB_TunnelMovement());
        j.addListener(this,j.getB_Sabotage());
        j.addListener(this,j.getB_SupplyRaid());
        j.addListener(this,j.getB_Gravar());
        j.addListener(this,j.getB_SkipTurn());
        j.addListener(this,j.getB_SkipAction());
    }

    public void run(){
        while (!sair) {
            IEstados estado = m.getEstado();

            if (estado instanceof EsperaInicio) {
                mi.setVisible(true);
            } else if (estado instanceof EsperaCarta) {
                cartaVirada();
            } else if (estado instanceof AguardaAcao) {
               // processaAcoes();
            } else if (estado instanceof FinalDoDia) {
                //fimDoDia();
            } else if (estado instanceof JogoTerminado) {
                //fimDoJogo();
                sair = true;
            }
        }
    }

    public void cartaVirada() {
        mi.setVisible(false);
        m.viraCarta();
        j.updateActionCard();
        j.updateTrackers();
        j.setVisible(true);
        
        j.updateValidActions();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object origem = e.getSource();
        //Menu iniciar
        if(origem == (mi.getB_Iniciar())){
            m.jogo();
        }
        if(origem == (mi.getB_Sair())){
            System.exit(0);
        }
        //Jogo
        if(origem == (j.getB_ArcAttack())){
        }
    }
}
