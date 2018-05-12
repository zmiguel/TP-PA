/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eventos;

import tp.DRM;

/**
 *
 * @author Ricardo Marques
 */
public class EnemyFatigue {
    public void evento(DRM drm){
        drm.setSabotageAction(1);
        drm.setCompureAction(1);
        drm.setRaidAction(1);
    } 
}
