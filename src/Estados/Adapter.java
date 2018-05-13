/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import tp.Mundo;
import java.io.Serializable;

/**
 *
 * @author Ricardo Marques
 */
public class Adapter implements IEstados, Serializable {
    protected Mundo mundo;
    
    public Adapter(Mundo mundo){
        this.mundo = mundo;
    }
            
    public Mundo getMundo(){
        return mundo;
    }
    
    public void setMundo(Mundo mundo){
        this.mundo = mundo;
    }
    
    
    @Override
    public IEstados ProximoEstado(){
        return this;
    }
    
    @Override
    public IEstados FimDeDia(){
        return this;
    }
    
    @Override 
    public IEstados FimDeJogo(){
        return this;
    }      
}
