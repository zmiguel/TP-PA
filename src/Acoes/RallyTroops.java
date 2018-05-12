/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acoes;

import tp.DRM;
import tp.Dado;
import tp.StatusTrack;
import java.util.Scanner;

/**
 *
 * @author Ricardo Marques
 */
public class RallyTroops {
    public void acao(StatusTrack ST, DRM drm) {
        System.out.println("Spend 1 Supply for +1 DRM?? (you have " + ST.getSupplies() + " supplies) [N/y]");

        Scanner scan = new Scanner(System.in);
        char choice = scan.next().charAt(0);

        if(choice == 'y' || choice == 'Y'){
            ST.setSupplies(ST.getSupplies() -1);
            drm.setMoraleAction(drm.getMoraleAction() + 1);
        }

        Dado dado = null;
        int valor = dado.rodaDado();

        if(valor + drm.getMoraleAction() > 4){
            ST.setMorale(ST.getMorale() + 1);
        }

    }
}
