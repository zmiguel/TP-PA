/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ricardo Marques
 */
public class TP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EnemyTrack ETObject = new EnemyTrack();
        StatusTrack STObject = new StatusTrack();
        Cartas[] Baralho;
        Baralho = new Cartas[7];
        //CRIAR CARTAS
        for(int i = 0; i < 7; i++){
            Baralho[i] = new Cartas(i); 
        }
        
        for(int i = 0; i < 7; i++){
            System.out.println(Baralho[i].getID());
            System.out.println(Baralho[i].Evento[0].nome);
            System.out.println(Baralho[i].Evento[1].nome);
            System.out.println(Baralho[i].Evento[2].nome);
        }
        
        //Contexto c1 = new Contexto();
    }
    
    
    private static int getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


    
}
