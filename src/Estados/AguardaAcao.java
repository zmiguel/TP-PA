/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

import java.io.Serializable;
import Logica.Mundo;

/**
 *
 * @author Ricardo Marques
 */
public class AguardaAcao extends Adapter implements Serializable{
    
    public AguardaAcao(Mundo mundo){
        super(mundo);
    }
    
    public IEstados ProximoEstado(){
        if(mundo.getCards() == 0){
            mundo.setUpdateDone(false);
            return new FinalDoDia(this.getMundo());
        }else{
            mundo.setAccoes(mundo.getAccoes()-1);
            if(mundo.getAccoes()>0){
                mundo.setUpdateDone(false);
                return new AguardaAcao(mundo);
            }else{
                mundo.setUpdateDone(false);
                return new EsperaCarta(mundo);
            }
        }
    }
    
    
    @Override 
    public IEstados FimDeJogo(){
        return new JogoTerminado(this.getMundo());
    }

}
