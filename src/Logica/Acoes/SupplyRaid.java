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

/**
 *
 * @author Ricardo Marques
 */
public class SupplyRaid implements Serializable {
    public void acao(DRM drm, StatusTrack ST){
           Dado dado = new Dado();
           int valor = 0;
           
           valor = dado.rodaDado();

           System.out.println("Dado: " + valor);
           
           if(valor +  drm.getRaidAction() > 5){
               ST.setStolenSupplies(ST.getStolenSupplies() + 2);
               System.out.println("Two Supplies Stolen with sucess");
           }else if(valor + drm.getRaidAction() <= 5 && valor + drm.getRaidAction() >= 3){
               ST.setStolenSupplies(ST.getStolenSupplies() + 1);
               System.out.println("One Supplie stolen with sucess");
           }else if(valor + drm.getRaidAction() == 1){
               System.out.println("Unit Captured :(");
               ST.captured();
           }
        }
}