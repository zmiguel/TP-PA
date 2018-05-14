/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.io.Serializable;

/**
 *
 * @author Ricardo Marques
 */
class Evento implements Serializable {
    
    public final int numAcoes;
    public final String nome;
    public final String descricao;
    public final String[] mov;
    
    
    public Evento(int numA, String[] movimento, String name, String desc){
        this.numAcoes = numA;
        this.nome = name;
        this.descricao = desc;
        this.mov = movimento;
    }
    
    public int getNumActions(){
        return numAcoes;
    }    
    
    public String[] getCombo(){
        return mov;
    }
    
    public String getDesc(){
        return descricao;
    }
    
}
