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
public class AguardaAcao extends Adapter implements Serializable{
    
    public AguardaAcao(Mundo mundo){
        super(mundo);
    }
    
    public IEstados proximoEstado(){
        if(mundo.getCards() == 0){
            return new FinalDoDia(this.getMundo());
        }else{
            return new EsperaCarta(mundo);
        }
    
    }
    
    
    @Override 
    public IEstados FimDeJogo(){
        return new JogoTerminado(this.getMundo());
    }

}
