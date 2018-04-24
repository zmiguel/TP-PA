/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp;

/**
 *
 * @author Ricardo Marques
 */
public class StatusTrack {
    private int wall;
    private int morale;
    private int supplies;
    private int tunnel;
    private int raidedsupplies;

    public StatusTrack() {
        this.wall = 4;
        this.morale = 4;
        this.supplies = 4;   
        this.tunnel = 0;
        this.raidedsupplies = 0;
    }
}
