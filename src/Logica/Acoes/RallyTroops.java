/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Acoes;

import Logica.DRM;
import Logica.Dado;
import Logica.StatusTrack;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Ricardo Marques
 */
public class RallyTroops implements Serializable {
    public void acao(StatusTrack ST, DRM drm) {
        System.out.println("Spend 1 Supply for +1 DRM?? (you have " + ST.getSupplies() + " supplies) [N/y]");

        Scanner scan = new Scanner(System.in);
        char choice = scan.next().charAt(0);

        if(choice == 'y' || choice == 'Y'){
            ST.setSupplies(ST.getSupplies() -1);
            drm.setMoraleAction(drm.getMoraleAction() + 1);
        }

        Dado dado = new Dado();
        int valor = dado.rodaDado();

        if(valor + drm.getMoraleAction() > 4){
            ST.setMorale(ST.getMorale() + 1);
        }

    }
}
