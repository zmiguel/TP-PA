/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Estados.*;
import Logica.Acoes.*;
import Logica.Eventos.*;
import java.util.Observable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Ricardo Marques
 */
public class Mundo extends Observable implements Serializable {
    private final EnemyTrack ET;
    private final StatusTrack ST;
    private final DRM drm;
    private final Dado dado;
    private final ArrayList<Cartas> Baralho;
    private IEstados estadoAtual;
    //acoes
    ArchersAttack at;
    BoilingWaterAttack bwa;
    CloseCombatAttack cca;
    Coupure c;
    RallyTroops rt;
    TunnelMovement tm;
    SupplyRaid sr;
    Sabotage s;

    public Mundo() {
        ET = new EnemyTrack();
        ST = new StatusTrack();
        Baralho = new ArrayList<>();
        drm = new DRM();
        dado = new Dado();
        estadoAtual = new EsperaInicio(this);
        //criar acoes
        at = new ArchersAttack();
        bwa = new BoilingWaterAttack();
        cca = new CloseCombatAttack();
        c = new Coupure();
        rt = new RallyTroops();
        tm = new TunnelMovement();
        sr = new SupplyRaid();
        s = new Sabotage();
    }

    public IEstados getEstado() {
        return this.estadoAtual;
    }

    private void setEstado(IEstados e) {
        this.estadoAtual = e;
    }

    public void gerarBaralho() {
        for (int i = 0; i < 7; i++) {
            Baralho.add(new Cartas(i, ST.getDia()));
        }
        Collections.shuffle(Baralho);
    }

    public int getCards() {
        return Baralho.size();
    }

    public void setSTDia(int d) {
        ST.setDia(d);
    }

    public void suppliesDrop() {
        ST.setSupplies(ST.getSupplies() - 1);
        ST.setDia(ST.getDia() + 1);
    }

    public void jogo() {
        gerarBaralho();
        setEstado(estadoAtual.ProximoEstado());
    }

    public void verificaTunel() {
        if (ST.getTunnel() == 3) {
            int valor = dado.rodaDado();
            if (valor == 1) {
                ST.captured();
            }
        }
    }

    public int getCardID(){
        return Baralho.get(0).getID();
    }

    public void viraCarta() {

        verificaTunel();

        ST.setAccoes(Baralho.get(0).getNumActions());

        System.out.println(Baralho.get(0).toString());

        if (Baralho.get(0).sss().equals("Trebuchet Attack")) {
            TrebuchetAttack ta = new TrebuchetAttack();
            ta.evento(ST, ET);
        } else if (Baralho.get(0).sss().equals("Illness")) {
            Illness i = new Illness();
            i.evento(ST);
        } else if (Baralho.get(0).sss().equals("Supplies Spoiled")) {
            SuppliesSpoiled ss = new SuppliesSpoiled();
            ss.evento(ST);
        } else if (Baralho.get(0).sss().equals("Death of a Leader")) {
            DeathOfALeader doal = new DeathOfALeader();
            doal.evento(ST);
        } else if (Baralho.get(0).sss().equals("Volley of Arrows")) {
            VolleyOfArrows voa = new VolleyOfArrows();
            voa.evento(drm);
        } else if (Baralho.get(0).sss().equals("Cover Of Darkness")) {
            CoverOfDarkness cod = new CoverOfDarkness();
            cod.evento(drm);
        } else if (Baralho.get(0).sss().equals("Determined Enemy")) {
            DeterminedEnemy de = new DeterminedEnemy();
            de.evento(drm);
        } else if (Baralho.get(0).sss().equals("Guards Distracted")) {
            GuardsDistracted gd = new GuardsDistracted();
            gd.evento(drm);
        } else if (Baralho.get(0).sss().equals("Bad Weather")) {
            BadWeather bw = new BadWeather();
            bw.evento(ST);
        } else if (Baralho.get(0).sss().equals("Gate Fortified")) {
            GateFortified gf = new GateFortified();
            gf.evento(drm);
        } else if (Baralho.get(0).sss().equals("Collapsed")) {
            Collapsed c = new Collapsed();
            c.evento(ET);
        } else if (Baralho.get(0).sss().equals("Enemy Fatigue")) {
            EnemyFatigue ef = new EnemyFatigue();
            ef.evento(drm);
        } else if (Baralho.get(0).sss().equals("Iron Shields")) {
            IronShields is = new IronShields();
            is.evento(drm);
        } else if (Baralho.get(0).sss().equals("Boiling Oil")) {
            BoilingOil bo = new BoilingOil();
            bo.evento(drm);
        } else if (Baralho.get(0).sss().equals("Flaming Arrows")) {
            FlamingArrows fa = new FlamingArrows();
            fa.evento(drm);
        } else if (Baralho.get(0).sss().equals("Repaired Trebuchet")) {
            RepairedTrebuchet rt = new RepairedTrebuchet();
            rt.evento(drm, ET);
        } else if (Baralho.get(0).sss().equals("Rally!")) {
            Rally r = new Rally();
            r.evento(drm);
        } else if (Baralho.get(0).sss().equals("Faith")) {
            Faith f = new Faith();
            f.evento(drm);
        }

        for (String movs : Baralho.get(0).combo()) {
            if (movs.equals("Ladders")) {
                ET.setPosLadder(ET.getPosLadder() - 1);
                if(ET.getPosLadder()<0) ET.setPosLadder(0);
            }
            if (movs.equals("Battering Ram")) {
                ET.setPosBatteringRam(ET.getPosBatteringRam() - 1);
                if(ET.getPosBatteringRam()<0) ET.setPosBatteringRam(0);
            }

            if (movs.equals("Siege Tower")) {
                ET.setPosSiegeTower(ET.getPosSiegeTower() - 1);
                if(ET.getPosSiegeTower()<0) ET.setPosSiegeTower(0);
            }

            if (movs.equals("Slowest Unit Movement")) {
                if (ET.getPosLadder() > ET.getPosBatteringRam() && ET.getPosLadder() > ET.getPosSiegeTower()) {
                    ET.setPosLadder(ET.getPosLadder() - 1);
                } else if (ET.getPosBatteringRam() > ET.getPosLadder() && ET.getPosBatteringRam() > ET.getPosSiegeTower()) {
                    ET.setPosBatteringRam(ET.getPosBatteringRam() - 1);
                } else if (ET.getPosSiegeTower() > ET.getPosLadder() && ET.getPosSiegeTower() > ET.getStrenghtBatteringRam()) {
                    ET.setPosSiegeTower(ET.getPosSiegeTower() - 1);
                } else if (ET.getPosLadder() > ET.getPosBatteringRam() && ET.getPosLadder() == ET.getPosSiegeTower()) {
                    ET.setPosLadder(ET.getPosLadder() - 1);
                    ET.setPosSiegeTower(ET.getPosSiegeTower() - 1);
                } else if (ET.getPosBatteringRam() > ET.getPosLadder() && ET.getPosBatteringRam() == ET.getPosSiegeTower()) {
                    ET.setPosSiegeTower(ET.getPosSiegeTower() - 1);
                    ET.setPosBatteringRam(ET.getPosBatteringRam() - 1);
                } else if (ET.getPosLadder() > ET.getPosSiegeTower() && ET.getPosLadder() == ET.getStrenghtBatteringRam())
                    ET.setPosLadder(ET.getPosLadder() - 1);
                ET.setPosBatteringRam(ET.getPosBatteringRam() - 1);
            }
        }

        if (ST.perdaJogoInsta() || ET.perdaJogoInsta()) {
            setEstado(estadoAtual.FimDeJogo());
        }
        ST.TunnelFree();
        verifyClose();
        setEstado(estadoAtual.ProximoEstado());
    }

    public boolean verificaAcao(int choice) {

        if (choice == 1 && !ST.getWeather()) {
            if (ET.getPosLadder() == 4 && ET.getPosBatteringRam() == 4 && ET.getPosSiegeTower() == 4) {
                System.out.println("Não é possivel executar um ataque");
                return false;
            } else {
                return true;
            }
        } else if (choice == 2 && !ST.getWeather()) {
            if (ET.getPosLadder() != 1 && ET.getPosBatteringRam() != 1 && ET.getPosSiegeTower() != 1) {
                System.out.println("Não é possivel visto que nenhum está nos círculos");
                return false;
            } else {
                return true;
            }
        } else if (choice == 3 && !ST.getWeather()) {
            if (ET.getPosLadder() == 0 || ET.getPosBatteringRam() == 0 || ET.getPosSiegeTower() == 0) {
                return true;
            } else {
                System.out.println("Nenhum está no Close Combat");
                return false;
            }
        } else if (choice == 4 && !ST.getWeather()) {
            if (ST.getWall() >= 4) {
                System.out.println("Wall maxed out");
                return false;
            } else {
                return true;
            }

        } else if (choice == 5 && !ST.getWeather()) {
            if (ST.getMorale() >= 4) {
                System.out.println("Morale maxed out");
                return false;
            } else {
                return true;
            }
        } else if (choice == 6 && !ST.getWeather()) {
            return true;
        } else if (choice == 7) {
            if (ST.getTunnel() == 3 && ST.getStolenSupplies() < 2) {
                return true;
            } else {
                System.out.println("Supplis Maxed out or you are not in the end of the tunnel");
                return false;
            }
        } else if (choice == 8) {
            if (ST.getTunnel() == 3) {
                return true;
            } else {
                System.out.println("You are not in the end of the tunnel");
                return false;
            }
        } else if(choice == 9){
            return true;
        }
        return false;
    }

    public boolean verificaAlvo(int c1, int c2) {
        if (c1 == 1) {
            return at.verificaAlvo(c2, ET);
        }
        if (c1 == 2) {
            return bwa.verificaAlvo(c2, ET);
        }
        if (c1 == 3) {
            return cca.verificaAlvo(c2, ET);
        }
        return false;
    }

    public void acoes(int choice, int choice2) {
        switch (choice) {
            case 1:
                at.acao(ET, drm, choice2);
                break;
            case 2:
                bwa.acao(ET, drm, choice2);
                break;
            case 3:
                cca.acao(ET, drm, choice2);
                break;
            case 4:
                c.acao(ST, drm);
                break;
            case 5:
                rt.acao(ST, drm, choice2);
                break;
            case 6:
                tm.acao(ST);
                break;
            case 7:
                sr.acao(drm, ST);
                break;
            case 8:
                s.acao(ST, ET, drm);
                break;
            case 9:
                break;

        }

        if (ST.perdaJogoInsta() || ET.perdaJogoInsta()) {
            setEstado(estadoAtual.FimDeJogo());
        }

        if(ST.getAccoes()== 1){
            drm.resetDRM();
            resetClsoe();
            ST.setBadWeather(false);

            if (ST.perdaJogoFimTurno() || ET.perdaJogoFimTurno()) {
                setEstado(estadoAtual.FimDeJogo());
            }

            Baralho.remove(0);
        }

        setEstado(estadoAtual.ProximoEstado());
    }

    public void fimDoDia() {
        suppliesDrop();
        resetTunnel();
        gerarBaralho();
        setEstado(getEstado().ProximoEstado());
    }

    public void showETST(EnemyTrack ET, StatusTrack ST) {
        System.out.print(ET.toString());
        System.out.print(ST.toString());
    }

    public int getAccoes() {
        return ST.getAccoes();
    }

    public void setAccoes(int a) {
        ST.setAccoes(a);
    }

    public void showStatus() {
        showETST(ET, ST);
    }

    public void verifyClose(){
        if(ET.getPosLadder()==0 && ET.getPosBatteringRam() == 0 || ET.getPosLadder() == 0 && ET.getPosSiegeTower() == 0 || ET.getPosBatteringRam() == 0 && ET.getPosSiegeTower() == 0){
            ST.setClose(true);
        }
    }

    public void resetClsoe(){
        ST.setClose(false);
    }

    public boolean isClose(){
        return ST.isClose();
    }

    public void resetTunnel(){
        if(ST.getTunnel() == 1 || ST.getTunnel() ==2){
            ST.saveRaided();
        }
        ST.setTunnel(0);
        ST.setSairTunnel(true);
    }

    public int getSupplies() {
        return ST.getSupplies();
    }

    public boolean ultimoDia(){
        if(ST.getDia()==2){
            return true;
        }else{
            return false;
        }
    }
}
    
