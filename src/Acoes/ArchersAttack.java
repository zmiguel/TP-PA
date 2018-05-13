/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acoes;

import java.util.Scanner;
import tp.Dado;
import tp.EnemyTrack;
import tp.DRM;

/**
 *
 * @author Ricardo Marques
 */
public class ArchersAttack {
    public void acao(EnemyTrack ET, DRM drm){
           Dado dado = new Dado();
           int valor = 0;
           boolean acaoRealizada = false;
           
            System.out.println("Archers Attack!\n");
            System.out.println("[1] - Ladders\n");
            System.out.println("[2] - Battering Ram\n");
            System.out.println("[3] - Siege Tower\n");
           
           
            while(!acaoRealizada){
               Scanner scan = new Scanner(System.in);
               int choice = scan.nextInt();
               valor = dado.rodaDado();
                    
               if(choice == 1 && ET.getPosLadder() != 4 ){
                    if(valor + drm.getLadders() > ET.getStrenghtLadder()){
                        ET.setPosLadder(ET.getPosLadder() + 1);
                        System.out.println("Ataque às Ladders Efetivo");
                        acaoRealizada = true;
                    }else{
                        System.out.println("Ataque ineficaz");
                        acaoRealizada = true;
                    } 
               }else if(choice == 2 && ET.getPosBatteringRam() != 4){
                    if(valor + drm.getBatteringRam() > ET.getStrenghtBatteringRam() ){
                        ET.setPosBatteringRam(ET.getPosBatteringRam() + 1);
                        System.out.println("Ataque às Battering Ram Efetivo");
                        acaoRealizada = true;
                    }else{
                        System.out.println("Ataque ineficaz");
                        acaoRealizada = true;
                    } 
               }else if(choice == 3  && ET.getPosSiegeTower() != 4){
                    if(valor + drm.getSiegeTower() > ET.getStrenghtSiegeTower()){
                        ET.setPosSiegeTower(ET.getPosSiegeTower() + 1);
                        System.out.println("Ataque às Siege Tower");
                        acaoRealizada = true;
                    }else{
                        System.out.println("Ataque ineficaz");
                        acaoRealizada = true;
                    } 
                }
            }
    } 
}
