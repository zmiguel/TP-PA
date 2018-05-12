/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import java.util.ArrayList;
import tp.Cartas;
import tp.EnemyTrack;

/**
 *
 * @author Ricardo Marques
 */
public class VolleyOfArrows {
     public void evento(ArrayList<Cartas> Baralho, EnemyTrack ET){
           
        ET.setStrenghtBatteringRam(ET.getStrenghtBatteringRam() + 1);
        ET.setStrenghtLadder(ET.getStrenghtLadder() + 1);
        ET.setStrenghtSiegeTower(ET.getStrenghtSiegeTower() + 1);
        
        System.out.print("\nBattering Ram Strenght: " + ET.getStrenghtBatteringRam() 
                + "\nLadder Strenght: " + ET.getStrenghtLadder()
                + "\nSiege Tower Strenght: " + ET.getStrenghtSiegeTower());

    } 
}
