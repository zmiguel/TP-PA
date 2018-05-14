/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Acoes;

import Logica.Dado;
import Logica.EnemyTrack;
import Logica.DRM;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Ricardo Marques
 */
public class CloseCombatAttack implements Serializable {
    public void acao(EnemyTrack ET, DRM drm){
        Dado dado = new Dado();
        int valor;

        System.out.println("Close Combat Attack!\n");
        System.out.println("[1] - Ladders\n");
        System.out.println("[2] - Battering Ram\n");
        System.out.println("[3] - Siege Tower\n");

        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        valor = dado.rodaDado();

        switch (choice) {
            case 1: if(ET.getPosLadder()==0){
                if(valor + drm.getClose() > 4){
                    ET.setPosLadder(1);
                    break;
                }
            }else{
                System.out.print("Escolha Inválida");
            }
            case 2: if(ET.getPosBatteringRam()==0){
                if(valor + drm.getClose() > 4){
                    ET.setPosBatteringRam(1);
                    break;
                }
            }else{
                System.out.print("Escolha Inválida");
            }
            case 3: if(ET.getPosSiegeTower()==0){
                if(valor + drm.getClose() > 4){
                    ET.setPosSiegeTower(1);
                    break;
                }
            }else{
                System.out.print("Escolha Inválida");
            }
            default: System.out.print("Escolha Inválida");

        }
    }
}
