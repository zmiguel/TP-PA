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
public class Contexto {
    IEstados inicio, estadoAtual;
    
    
    public Contexto(){
        inicio = new aguardaInicio(this);

        estadoAtual = inicio;
    }
    
    
    public void setEstado(IEstados estado){
        estadoAtual = estado;
    }

    /*public void abrirCofre(){
        estadoAtual.abrirCofre();
    }
    
    public void inserirPin(int pin){
        estadoAtual.inserirPin(pin);
    }
    
    public void fecharCofre(){
        estadoAtual.fecharCofre();
    }
    
    
    
    
    // GETTERS
    public IEstados getAberto() {
        return aberto;
    }

    public IEstados getFechado() {
        return fechado;
    }

    public IEstados getEstadoAtual() {
        return estadoAtual;
    }*/
    
    
}

