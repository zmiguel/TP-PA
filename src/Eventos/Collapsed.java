/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import java.util.ArrayList;
import tp.Cartas;
import tp.EnemyTrack;
import tp.StatusTrack;

/**
 *
 * @author Ricardo Marques
 */
public class Collapsed {
     public void evento(ArrayList<Cartas> Baralho, StatusTrack ST, EnemyTrack ET){
           
        if(ET.getPosSiegeTower() == 4){
         ET.setStrenghtSiegeTower(-1);
        }
    } 
}
