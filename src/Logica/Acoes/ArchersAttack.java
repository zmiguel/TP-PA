/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Acoes;

import java.io.Serializable;
import Logica.EnemyTrack;
import Logica.DRM;

/**
 *
 * @author Ricardo Marques
 */
public class ArchersAttack implements Serializable {
    public void acao(EnemyTrack ET, DRM drm, int choice, int valor){

        if(choice == 1){
            if(valor + drm.getLadders() > ET.getStrenghtLadder()){
                ET.setPosLadder(ET.getPosLadder() + 1);
                System.out.println("Ataque às Ladders Efetivo");
            }else{
                System.out.println("Ataque ineficaz");
            }
        }else if(choice == 2){
            if(valor + drm.getBatteringRam() > ET.getStrenghtBatteringRam() ){
                ET.setPosBatteringRam(ET.getPosBatteringRam() + 1);
                System.out.println("Ataque às Battering Ram Efetivo");
            }else{
                System.out.println("Ataque ineficaz");
            }
        }else if(choice == 3){
            if(valor + drm.getSiegeTower() > ET.getStrenghtSiegeTower()){
                ET.setPosSiegeTower(ET.getPosSiegeTower() + 1);
                System.out.println("Ataque às Siege Tower");
            }else{
                System.out.println("Ataque ineficaz");
            }
        }
    }

    public boolean verificaAlvo(int c, EnemyTrack ET){
        if(c == 1 && ET.getPosLadder() < 4 ){
            return true;
        }else if(c == 2 && ET.getPosBatteringRam() < 4){
            return true;
        }else return c == 3 && ET.getPosSiegeTower() < 4;
    }
}
