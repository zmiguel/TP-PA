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
public class Illness implements Serializable {

    public void evento( StatusTrack ST){
           
        ST.setMorale(ST.getMorale() - 1);
        if(ST.getMorale()<0) ST.setMorale(0);
        ST.setSupplies(ST.getSupplies() - 1);
        if(ST.getSupplies()<0) ST.setSupplies(0);
      
        System.out.print("\nMORALE: " + ST.getMorale() + " SUPPLIES: " + ST.getSupplies());

    }   
}
