/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acoes;

import tp.StatusTrack;

/**
 *
 * @author Ricardo Marques
 */
public class TunnelMovement {
    public void acao(StatusTrack ST){
        if(ST.isSairTunnel()){//quando estamos a sair do tunel
            if(ST.getTunnel() == 0){//CASTELO
                ST.setTunnel(1);
            }else if(ST.getTunnel()==1 || ST.getTunnel() == 2){
                ST.setTunnel(3);
                ST.setSairTunnel(false);
            }
        }else{ //quando estamos a entrar
            if(ST.getTunnel() == 3){//enemy lines
                ST.setTunnel(2);
            }else if(ST.getTunnel()==1 || ST.getTunnel() == 2){
                ST.setTunnel(0);
                ST.setSairTunnel(true);
                ST.saveRaided();
            }
        }
    }
    
}
