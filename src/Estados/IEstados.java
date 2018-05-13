/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estados;

/**
 *
 * @author Ricardo Marques
 */
public interface IEstados {
    IEstados ProximoEstado();
    IEstados FimDeJogo();
    IEstados FimDeDia();
}
