/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import tp.EnemyTrack;

/**
 *
 * @author Ricardo Marques
 */
public class Collapsed {
     public void evento(EnemyTrack ET){
           
        if(ET.getPosSiegeTower() == 4){
            ET.setSiegeTower(false);
        }
    } 
}
