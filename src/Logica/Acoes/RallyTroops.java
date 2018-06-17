/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Acoes;

import Logica.DRM;
import Logica.StatusTrack;
import java.io.Serializable;

/**
 *
 * @author Ricardo Marques
 */
public class RallyTroops implements Serializable {
    public void acao(StatusTrack ST, DRM drm, int choice, int valor) {
        if(choice == 1){
            ST.setSupplies(ST.getSupplies() -1);
            drm.setMoraleAction(drm.getMoraleAction() + 1);
        }

        if(valor + drm.getMoraleAction() > 4){
            ST.setMorale(ST.getMorale() + 1);
        }

    }
}
