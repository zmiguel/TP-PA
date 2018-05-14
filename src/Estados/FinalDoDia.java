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
public class FinalDoDia extends Adapter implements Serializable{
    static int dia = 0;
    
    public FinalDoDia(Mundo mundo){
        super(mundo);
    }
    
    @Override 
    public IEstados ProximoEstado(){
        dia++;
        if(dia == 2){
            return new JogoTerminado(this.getMundo());
        }else{
            Mundo mundo = super.getMundo();
            mundo.setSTDia(dia);
        }
        
        return new EsperaCarta(this.getMundo());
    }
    
}