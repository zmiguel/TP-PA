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
public class GuardsDistracted {
    public void evento(ArrayList<Cartas> Baralho, StatusTrack ST){
           
        ST.setMorale(ST.getMorale() + 1);
        //SABOTAGE A IMPLEMENTAR
      
        System.out.print("\nMORALE: " + ST.getMorale());

    }
}
