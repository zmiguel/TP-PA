/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Eventos;

import Logica.StatusTrack;

import java.io.Serializable;

/**
 *
 * @author Ricardo Marques
 */
public class DeathOfALeader implements Serializable {
    public void evento( StatusTrack ST){
           
        ST.setMorale(ST.getMorale() - 1);
      
        System.out.print("\nMORALE: " + ST.getMorale());

    }   
}
