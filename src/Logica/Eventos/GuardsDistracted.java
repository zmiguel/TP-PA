/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Eventos;

import Logica.DRM;

import java.io.Serializable;

/**
 *
 * @author Ricardo Marques
 */
public class GuardsDistracted implements Serializable {
    public void evento(DRM drm){

        drm.setMoraleAction(1);
        drm.setSabotageAction(1);

    }
}
