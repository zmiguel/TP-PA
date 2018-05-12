/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acoes;

import tp.Dado;
import tp.EnemyTrack;

/**
 *
 * @author Ricardo Marques
 */
public class CloseCombatAttack {
    public void acao(EnemyTrack ET){
           Dado dado = null;
           int valor = 0;
            System.out.println("Close Combat Attack!\n");
           
            if(ET.getPosLadder() == 0){
              valor = dado.rodaDado();  
            }
            
            if(ET.getPosBatteringRam() == 0){
                valor = dado.rodaDado();
            }
            
            if(ET.getPosSiegeTower() == 0){
                valor = dado.rodaDado();
            }
           
           
       
                    
        }
    } 
