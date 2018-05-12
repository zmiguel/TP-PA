/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import tp.StatusTrack;
import tp.EnemyTrack;
import tp.Dado;


/**
 *
 * @author Ricardo Marques
 */
public class TrebuchetAttack {  
    
    public void evento(StatusTrack ST, EnemyTrack ET){
        int valor;
        Dado dado = null;

            if(ET.getTrebuchet() == 3){
                ST.setWall(ST.getWall() - 2);
            }else if(ET.getTrebuchet() == 2){
                ST.setWall(ST.getWall() - 1);
            }else if(ET.getTrebuchet() == 1){
                valor = dado.rodaDado();
                if(valor >= 4){
                    ST.setWall(ST.getWall() - 1); 
                }
            }
            
        System.out.print("\nWALL VALUE IS NOW: " + ST.getWall());

    }   
}



