/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acoes;

import java.util.Scanner;
import tp.Dado;
import tp.EnemyTrack;

/**
 *
 * @author Ricardo Marques
 */
public class ArchersAttack {
    public void acao(EnemyTrack ET){
           Dado dado;
           
            System.out.println("Archers Attack!\n");
            System.out.println("[1] - Ladders\n");
            System.out.println("[2] - Battering Ram\n");
            System.out.println("[3] - Siege Tower\n");
           
           
           Scanner scan = new Scanner(System.in);
           int choice = scan.nextInt();
           
        switch (choice) {
            case 1:  ET.setPosLadder(ET.getPosLadder() + 1);
                     break;
            case 2:  ET.setPosBatteringRam(ET.getPosBatteringRam() + 1);
                     break;
            case 3:  ET.setPosSiegeTower(ET.getPosBatteringRam() + 1);
                     break;
            default: System.out.print("Escolha Inválida");
                    
        }
    } 
}
