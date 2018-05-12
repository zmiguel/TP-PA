/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acoes;

import tp.DRM;
import tp.Dado;
import tp.EnemyTrack;
import tp.StatusTrack;

/**
 *
 * @author Ricardo Marques
 */
public class Sabotage {
    public void acao(StatusTrack ST, EnemyTrack ET, DRM drm){
        Dado dado = new Dado();
        int valor = dado.rodaDado();

        if(valor == 1){
            ST.captured();
        }else if(valor + drm.getSabotageAction() > 4){
            ET.setTrebuchet(ET.getTrebuchet() - 1);
        }
    }
}
