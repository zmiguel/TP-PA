/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import java.util.ArrayList;
import tp.Cartas;
import tp.StatusTrack;

/**
 *
 * @author Ricardo Marques
 */
public class GateFortified {
    public void evento(ArrayList<Cartas> Baralho, StatusTrack ST){
           
        ST.setMorale(ST.getMorale() - 1);
        ST.setSupplies(ST.getSupplies() - 1);
      
        System.out.print("\nMORALE: " + ST.getMorale() + " SUPPLIES: " + ST.getSupplies());

    }  
}
