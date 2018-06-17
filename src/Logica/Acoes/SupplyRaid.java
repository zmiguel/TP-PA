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
public class SupplyRaid implements Serializable {
    public void acao(DRM drm, StatusTrack ST, int valor){

           if(valor == 1){
               System.out.println("Unit Captured :(");
               ST.captured();
           }else {
               if (valor + drm.getRaidAction() > 5) {
                   ST.setStolenSupplies(ST.getStolenSupplies() + 2);
                   System.out.println("Two Supplies Stolen with sucess");
               } else if (valor + drm.getRaidAction() <= 5 && valor + drm.getRaidAction() >= 3) {
                   ST.setStolenSupplies(ST.getStolenSupplies() + 1);
                   System.out.println("One Supplie stolen with sucess");
               }else{
                   System.out.println("You get NOTHING!");
               }
           }
        }
}
