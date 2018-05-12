/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

import Acoes.ArchersAttack;
import Acoes.BoilingWaterAttack;
import Acoes.CloseCombatAttack;
import Acoes.Coupure;
import Acoes.RallyTroops;
import java.util.ArrayList;
import java.util.Collections;
import Estados.Contexto;
import Eventos.BoilingOil;
import Eventos.Collapsed;
import Eventos.CoverOfDarkness;
import Eventos.DeathOfALeader;
import Eventos.DeterminedEnemy;
import Eventos.EnemyFatigue;
import Eventos.Faith;
import Eventos.FlamingArrows;
import Eventos.GateFortified;
import Eventos.GuardsDistracted;
import Eventos.Illness;
import Eventos.IronShields;
import Eventos.Rally;
import Eventos.RepairedTrebuchet;
import Eventos.SuppliesSpoiled;
import Eventos.TrebuchetAttack;
import Eventos.VolleyOfArrows;
import java.util.Scanner;

/**
 *
 * @author Ricardo Marques
 */
public class TP {

    public static void main(String[] args) {
        EnemyTrack ET = new EnemyTrack();
        StatusTrack ST = new StatusTrack();
        ArrayList<Cartas> Baralho = new ArrayList<>();
<<<<<<< Updated upstream
=======
        Dado dado = null;
>>>>>>> Stashed changes
        boolean sair = false;
        
        Contexto c1 = new Contexto();
        
        //CRIAR CARTAS  
        for(int i = 0; i < 7; i++){
            Baralho.add(new Cartas(i));
        }
    
        while(getInput() != 1){}

            Collections.shuffle(Baralho);   

            while(!sair){
                
                if(ST.getTunnel() == 3){
                    Dado d;
                    int valor = d.rodaDado();
                    if (valor == 1){
                        ST.setTunnel(0);
                        ST.setMorale(ST.getMorale() - 1);
                        ST.setRaidedSupplies(0);
                    }
                }
                
                
                System.out.print(ET.toString());
                System.out.print(ST.toString());
                System.out.print("\n\n[1] - TIRAR CARTA\n[2] - GRAVAR\n[3] - SAIR\n>");
                
                while(getInput() == 1){

                     System.out.print(Baralho.get(0));
                     
                     if(Baralho.get(0).sss().equals("Trebuchet Attack")){ 
                        TrebuchetAttack ta = new TrebuchetAttack();
                        ta.evento(ST, ET);  
                     }else if(Baralho.get(0).sss().equals("Illness")){
                         Illness i = new Illness();
                         i.evento(Baralho, ST);
                     }else if(Baralho.get(0).sss().equals("Supplies Spoiled")){
                         SuppliesSpoiled ss = new SuppliesSpoiled();
                         ss.evento(ST);
                     }else if(Baralho.get(0).sss().equals("Death of a Leader")){
                         DeathOfALeader doal = new DeathOfALeader();
                         doal.evento(ST);
                     }else if(Baralho.get(0).sss().equals("Volley of Arrows")){
                         VolleyOfArrows voa = new VolleyOfArrows();
                         voa.evento(Baralho, ET);
                     }else if(Baralho.get(0).sss().equals("Cover Of Darkness")){
                         CoverOfDarkness cod = new CoverOfDarkness();
                         cod.evento(Baralho, ST,ET);
                     }else if(Baralho.get(0).sss().equals("Determined Enemy")){
                         DeterminedEnemy de = new DeterminedEnemy();
                         de.evento(Baralho, ST, ET);
                     }else if(Baralho.get(0).sss().equals("Guards Distracted")){
                         GuardsDistracted gd = new GuardsDistracted();
                         gd.evento(Baralho, ST);
                     }else if(Baralho.get(0).sss().equals("Bad Weather")){
                         //ONLY RAID AND SABOTAGE ACTIONS ALLOWED THIS TURN
                     }else if(Baralho.get(0).sss().equals("Gate Fortified")){
                         GateFortified gf = new GateFortified();
                         gf.evento(Baralho, ST);
                     }else if(Baralho.get(0).sss().equals("Collapsed")){
                         Collapsed c = new Collapsed();
                         c.evento(Baralho, ST, ET);
                     }else if(Baralho.get(0).sss().equals("Enemy Fatigue")){
                         EnemyFatigue ef = new EnemyFatigue();
                         ef.evento(Baralho, ST, ET);
                     }else if(Baralho.get(0).sss().equals("Iron Shields")){
                         IronShields is = new IronShields();
                         is.evento(Baralho, ST, ET);
                     }else if(Baralho.get(0).sss().equals("Boiling Oil")){
                         BoilingOil bo = new BoilingOil();
                         bo.evento(Baralho, ST, ET);
                     }else if(Baralho.get(0).sss().equals("Flaming Arrows")){
                         FlamingArrows fa = new FlamingArrows();
                         fa.evento(Baralho, ST, ET);
                     }else if(Baralho.get(0).sss().equals("Repaired Trebuchet")){
                         RepairedTrebuchet rt = new RepairedTrebuchet();
                         rt.evento(Baralho, ST, ET);
                     }else if(Baralho.get(0).sss().equals("Rally!")){
                         Rally r = new Rally();
                         r.evento(Baralho, ST, ET);
                     }else if(Baralho.get(0).sss().equals("Faith")){
                         Faith f = new Faith();
                         f.evento(Baralho, ST, ET);
                     }
                     
                     for(String movs: Baralho.get(0).combo()){
                         if(movs.equals("Ladders")){
                             ET.setPosLadder(ET.getPosLadder() - 1);
                         }
                         if(movs.equals("Battering Ram")){
                             ET.setPosBatteringRam(ET.getPosBatteringRam() - 1);
                         }
                         
                         if(movs.equals("SiegeTower")){
                             ET.setPosSiegeTower(ET.getPosSiegeTower() - 1);
                         }
                         
                         if(movs.equals("Slowest Unit Movement")){
                             if(ET.getPosLadder() > ET.getPosBatteringRam() && ET.getPosLadder() > ET.getPosSiegeTower()){
                                 ET.setPosLadder(ET.getPosLadder() - 1);
                             }else if(ET.getPosBatteringRam() > ET.getPosLadder() && ET.getPosBatteringRam() > ET.getPosSiegeTower()){
                                 ET.setPosBatteringRam(ET.getPosBatteringRam() - 1);
                             }else if(ET.getPosSiegeTower() > ET.getPosLadder() && ET.getPosSiegeTower() > ET.getStrenghtBatteringRam()){
                                 ET.setPosSiegeTower(ET.getPosSiegeTower() -1);
                             }else if(ET.getPosLadder() > ET.getPosBatteringRam() && ET.getPosLadder() == ET.getPosSiegeTower()){
                                 ET.setPosLadder(ET.getPosLadder() - 1);
                                ET.setPosSiegeTower(ET.getPosSiegeTower() -1);
                             }else if(ET.getPosBatteringRam() > ET.getPosLadder() && ET.getPosBatteringRam() == ET.getPosSiegeTower()){
                                ET.setPosSiegeTower(ET.getPosSiegeTower() -1);
                                ET.setPosBatteringRam(ET.getPosBatteringRam() - 1);
                             }else if(ET.getPosLadder() > ET.getPosSiegeTower() && ET.getPosLadder() == ET.getStrenghtBatteringRam())
                                    ET.setPosLadder(ET.getPosLadder() - 1);
                                    ET.setPosBatteringRam(ET.getPosBatteringRam() - 1);
                            }
                     }
  
                     for(int n = 0;n < Baralho.get(0).getNumActions(); n++){
                        System.out.println("[1] - Archers Attack");
                        System.out.println("[2] - Boiling Water Attack");
                        System.out.println("[3] - Close Combat Attack");
                        System.out.println("[4] - Coupure");
                        System.out.println("[5] - Rally Troops");
                        System.out.println("[6] - Tunnel Movement");
                        System.out.println("[7] - Supply Raid");
                        System.out.println("[8] - Sabotage");

                    Scanner scan = new Scanner(System.in);
                    int choice = scan.nextInt();

                    switch (choice) {
                        case 1:  ArchersAttack at = new ArchersAttack();
                                 at.acao(ET);
                                 break;
                        case 2: if(ET.getPosLadder() != 1 && ET.getPosBatteringRam() != 1 && ET.getPosSiegeTower() != 1){
                                }else{ 
                                    BoilingWaterAttack bwa = new BoilingWaterAttack();
                                    bwa.acao(ET);
                                    break;
                                }
                                 
                        case 3:  if(ET.getPosLadder() == 0 || ET.getPosBatteringRam() == 0 || ET.getPosSiegeTower() == 0){
                                    CloseCombatAttack cca = new CloseCombatAttack();
                                    cca.acao(ET);
                                    break;
                        }
                        
                        case 4: Coupure c = new Coupure();
                                c.acao(ST);
                                
                        case 5: RallyTroops rt = new RallyTroops();
                                rt.acao();
                               
                        //case 6
                        //case 7
                        default: System.out.print("Escolha Inválida");

                        }
                                 
                     }
                     
                     
                     
                    Baralho.remove(0);
                    System.out.print("\n\n[1] - TIRAR CARTA\n[2] - GRAVAR\n[3] - SAIR\n>");
                    
                }
                
            }
    }
    
    
    private static int getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    
}
