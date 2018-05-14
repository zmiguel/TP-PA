/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Estados.*;
import Logica.Acoes.*;
import Logica.Eventos.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Ricardo Marques
 */
public class Mundo implements Serializable {
    private final EnemyTrack ET;
    private final StatusTrack ST;
    private final DRM drm;
    private final Dado dado;
    private final ArrayList<Cartas> Baralho;
    private IEstados estadoAtual;

    public Mundo() {
        ET = new EnemyTrack();
        ST = new StatusTrack();
        Baralho = new ArrayList<>();
        drm = new DRM();
        dado = new Dado();
        estadoAtual = new EsperaInicio(this);
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

    public void viraCarta() {

        verificaTunel();

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
            }
            if (movs.equals("Battering Ram")) {
                ET.setPosBatteringRam(ET.getPosBatteringRam() - 1);
            }

            if (movs.equals("Siege Tower")) {
                ET.setPosSiegeTower(ET.getPosSiegeTower() - 1);
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
        setEstado(estadoAtual.ProximoEstado());
    }

    public void acoes() {
        for (int n = 0; n < Baralho.get(0).getNumActions(); n++) {

            boolean acaoRealizada = false;
            showETST(ET, ST);

            System.out.println("\nAÇÕES POR REALIZAR: " + (Baralho.get(0).getNumActions() - n));
            System.out.println("[1] - Archers Attack");
            System.out.println("[2] - Boiling Water Attack");
            System.out.println("[3] - Close Combat Attack");
            System.out.println("[4] - Coupure");
            System.out.println("[5] - Rally Troops");
            System.out.println("[6] - Tunnel Movement");
            System.out.println("[7] - Supply Raid");
            System.out.println("[8] - Sabotage");
            System.out.println("[9] - Passo (nao fazer nada)");
            System.out.print("> ");

            while (!acaoRealizada) {
                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();

                if (choice == 1 && !ST.getWeather()) {
                    if (ET.getPosLadder() == 4 && ET.getPosBatteringRam() == 4 && ET.getPosSiegeTower() == 4) {
                        System.out.println("Não é possivel executar um ataque");
                    } else {
                        acaoRealizada = true;
                        ArchersAttack at = new ArchersAttack();
                        at.acao(ET, drm);
                        break;
                    }
                } else if (choice == 2 && !ST.getWeather()) {
                    if (ET.getPosLadder() != 1 && ET.getPosBatteringRam() != 1 && ET.getPosSiegeTower() != 1) {
                        System.out.println("Não é possivel visto que nenhum está nos círculos");
                    } else {
                        acaoRealizada = true;
                        BoilingWaterAttack bwa = new BoilingWaterAttack();
                        bwa.acao(ET, drm);
                        break;
                    }
                } else if (choice == 3 && !ST.getWeather()) {
                    if (ET.getPosLadder() == 0 || ET.getPosBatteringRam() == 0 || ET.getPosSiegeTower() == 0) {
                        acaoRealizada = true;
                        CloseCombatAttack cca = new CloseCombatAttack();
                        cca.acao(ET, drm);
                        break;
                    } else {
                        System.out.println("Nenhum está no Close Combat");
                    }
                } else if (choice == 4 && !ST.getWeather()) {
                    if (ST.getWall() >= 4) {
                        System.out.println("Wall maxed out");
                    } else {
                        acaoRealizada = true;
                        Coupure c = new Coupure();
                        c.acao(ST, drm);
                        break;
                    }

                } else if (choice == 5 && !ST.getWeather()) {
                    if (ST.getMorale() >= 4) {
                        System.out.println("Morale maxed out");

                    } else {
                        acaoRealizada = true;
                        RallyTroops rt = new RallyTroops();
                        rt.acao(ST, drm);
                        break;
                    }
                } else if (choice == 6 && !ST.getWeather()) {
                    acaoRealizada = true;
                    TunnelMovement tm = new TunnelMovement();
                    tm.acao(ST);
                    break;
                } else if (choice == 7) {
                    if (ST.getTunnel() == 3 && ST.getStolenSupplies() < 2) {
                        acaoRealizada = true;
                        SupplyRaid sr = new SupplyRaid();
                        sr.acao(drm, ST);
                        break;
                    }
                } else if (choice == 8) {
                    if (ST.getTunnel() == 3) {
                        acaoRealizada = true;
                        Sabotage s = new Sabotage();
                        s.acao(ST, ET, drm);
                        break;
                    }
                } else if (choice == 9 && !ST.getWeather()) {
                    acaoRealizada = true;
                    break;
                }
            }
            if (ST.perdaJogoInsta() || ET.perdaJogoInsta()) {
                setEstado(estadoAtual.FimDeJogo());
            }
        }

        drm.resetDRM();
        ST.setBadWeather(false);

        if (ST.perdaJogoFimTurno() || ET.perdaJogoFimTurno()) {
            setEstado(estadoAtual.FimDeJogo());
        }

        Baralho.remove(0);
        setEstado(estadoAtual.ProximoEstado());
    }

    public void fimDoDia() {
        suppliesDrop();
        gerarBaralho();
        setEstado(getEstado().ProximoEstado());
    }

    public void showETST(EnemyTrack ET, StatusTrack ST) {
        System.out.print(ET.toString());
        System.out.print(ST.toString());
    }
}
    
