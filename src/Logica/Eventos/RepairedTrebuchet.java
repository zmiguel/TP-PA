/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Eventos;

import Logica.EnemyTrack;
import Logica.DRM;

import java.io.Serializable;

/**
 *
 * @author Ricardo Marques
 */
public class RepairedTrebuchet implements Serializable {
    public void evento(DRM drm, EnemyTrack ET){
           
        drm.setCompureAction(1);

        if(ET.getTrebuchet() < 3){
            ET.setTrebuchet(ET.getTrebuchet() + 1);
        }
    } 
}
