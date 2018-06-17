/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Acoes;

import Logica.EnemyTrack;
import Logica.DRM;
import java.io.Serializable;

/**
 *
 * @author Ricardo Marques
 */
public class CloseCombatAttack implements Serializable {
    public void acao(EnemyTrack ET, DRM drm, int choice, int valor){

        if(choice == 1){
            if(valor + drm.getClose() > 4){
                ET.setPosLadder(1);
                System.out.println("Ataque às Ladders Efetivo");
            }else{
                System.out.println("Ataque ineficaz");
            }
        }else if(choice == 2){
            if(valor + drm.getClose() > 4){
                ET.setPosBatteringRam(1);
                System.out.println("Ataque às Battering Ram Efetivo");
            }else{
                System.out.println("Ataque ineficaz");
            }
        }else if(choice == 3){
            if(valor + drm.getClose() > 4){
                ET.setPosSiegeTower(1);
                System.out.println("Ataque às Siege Tower");
            }else{
                System.out.println("Ataque ineficaz");
            }
        }
    }

    public boolean verificaAlvo(int c, EnemyTrack ET){
        if(c == 1 && ET.getPosLadder() == 0 ){
            return true;
        }else if(c == 2 && ET.getPosBatteringRam() == 0){
            return true;
        }else return c == 3 && ET.getPosSiegeTower() == 0;
    }
}
