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
public class JogoTerminado extends Adapter implements Serializable {
    
    public JogoTerminado(Mundo mundo){
        super(mundo);
    }
}
