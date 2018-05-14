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
public class BoilingOil implements Serializable {
    public void evento(DRM drm){
        drm.setCircle(2);
    } 
}
