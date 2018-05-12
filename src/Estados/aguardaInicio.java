/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;


/**
 *
 * @author me
 */
public class aguardaInicio implements IEstados{
    Contexto contexto; 
    
    public aguardaInicio(Contexto cont){
        contexto = cont;
        System.out.println("9 CARD SIEGE\n1 - Jogar\n2 - Sair\n");
    }

    @Override
    public void aguardaRetiradaDeCarta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

