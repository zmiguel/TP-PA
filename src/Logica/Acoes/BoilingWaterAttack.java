/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Acoes;

import java.io.Serializable;
import java.util.Scanner;
import Logica.Dado;
import Logica.EnemyTrack;
import Logica.DRM;

/**
 *
 * @author Ricardo Marques
 */
public class BoilingWaterAttack implements Serializable {
    public void acao(EnemyTrack ET, DRM drm){
           
        int valor = 0;
        Dado dado = new Dado();
                     
                    System.out.println("Boiling Water Attack");
                    System.out.println("[1] - Ladder");
                    System.out.println("[2] - Battering Ram");
                    System.out.println("[3] - Tower Siege");


                    Scanner scan = new Scanner(System.in);
                    int choice = scan.nextInt();

                    switch (choice) {
                        case 1:  if(ET.getPosLadder() == 1){
                                    valor = dado.rodaDado();
                                    if(valor + 1 + drm.getCircle() > ET.getStrenghtLadder()){
                                        ET.setPosLadder(ET.getPosLadder()+ 1);
                                        break;
                                    }
                                 }
                                 
                        case 2: if(ET.getPosBatteringRam() == 1){
                                    valor = dado.rodaDado();
                                    if(valor  + 1 + drm.getCircle() > ET.getStrenghtBatteringRam()){
                                        ET.setPosBatteringRam(ET.getPosBatteringRam() + 1);
                                        break;
                                    }
                              }
          
                        case 3: if(ET.getPosSiegeTower() == 1){
                                valor = dado.rodaDado();
                                 if(valor + 1 + drm.getCircle() > ET.getPosSiegeTower()){
                                     ET.setPosSiegeTower(ET.getPosSiegeTower() + 1);
                                     break;
                                 }
                        }
                    }
    }
}
