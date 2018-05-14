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
public class EsperaInicio extends Adapter implements Serializable{
    
    public EsperaInicio(Mundo mundo){
        super(mundo);
    }
    
    @Override 
    public IEstados ProximoEstado(){
        return new EsperaCarta(this.getMundo());
    }
    
}
