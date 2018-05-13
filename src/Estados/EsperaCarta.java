/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import java.io.Serializable;
import tp.Mundo;

/**
 *
 * @author Ricardo Marques
 */
public class EsperaCarta extends Adapter implements Serializable{
    
    public EsperaCarta(Mundo mundo){
        super(mundo);
    }
    
    public IEstados FimDeJogo(){
        return new JogoTerminado(this.getMundo());
    }
    
    
    @Override 
    public IEstados ProximoEstado(){
        return new AguardaAcao(this.getMundo());
    }
    
}
