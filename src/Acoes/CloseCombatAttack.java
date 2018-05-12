/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acoes;

import tp.Dado;
import tp.EnemyTrack;

import java.util.Scanner;

/**
 *
 * @author Ricardo Marques
 */
public class CloseCombatAttack {
    public void acao(EnemyTrack ET){
        Dado dado = null;
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
                if(valor > 4){
                    ET.setPosLadder(1);
                    break;
                }
            }else{
                System.out.print("Escolha Inválida");
            }
            case 2: if(ET.getPosBatteringRam()==0){
                if(valor > 4){
                    ET.setPosBatteringRam(1);
                    break;
                }
            }else{
                System.out.print("Escolha Inválida");
            }
            case 3: if(ET.getPosSiegeTower()==0){
                if(valor > 4){
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
