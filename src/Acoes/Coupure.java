/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acoes;

import tp.Dado;
import tp.StatusTrack;

/**
 *
 * @author Ricardo Marques
 */
public class Coupure {
     public void acao(StatusTrack ST){
           Dado dado = null;
           int valor = 0;
           
           valor = dado.rodaDado();
           
           if(valor > 4){
               ST.setWall(ST.getWall() );          
           }
             
        }
    }
