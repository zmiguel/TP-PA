/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp;

/**
 *
 * @author Ricardo Marques
 */
class Eventos {
    
    public int numAcoes;
    public String nome;
    public String descricao;
    public int[] mov;
    
    
    public Eventos(int numA, int[] movimento, String name, String desc){
        this.numAcoes = numA;
        this.nome = name;
        this.descricao = desc;
        this.mov = movimento;
    }
    
    
    
}
