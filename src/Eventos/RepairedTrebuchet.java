/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import tp.EnemyTrack;
import tp.DRM;

/**
 *
 * @author Ricardo Marques
 */
public class RepairedTrebuchet {
    public void evento(DRM drm, EnemyTrack ET){
           
        drm.setCompureAction(1);

        if(ET.getTrebuchet() < 3){
            ET.setTrebuchet(ET.getTrebuchet() + 1);
        }
    } 
}
