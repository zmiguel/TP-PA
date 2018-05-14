/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Eventos;

import Logica.EnemyTrack;

import java.io.Serializable;

/**
 *
 * @author Ricardo Marques
 */
public class Collapsed implements Serializable {
     public void evento(EnemyTrack ET){
           
        if(ET.getPosSiegeTower() == 4){
            ET.setSiegeTower(false);
        }
    } 
}
