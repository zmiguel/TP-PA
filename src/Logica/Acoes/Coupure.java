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
public class Coupure implements Serializable {
     public void acao(StatusTrack ST, DRM drm,int valor){
           
           if(valor + drm.getCompureAction() > 4){
               ST.setWall(ST.getWall() + 1);
               System.out.println("Wall restored");
           }   
    }
}
