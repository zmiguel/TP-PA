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
    private boolean badWeather = false;

    public StatusTrack() {
        this.wall = 4;
        this.morale = 4;
        this.supplies = 4;   
        this.tunnel = 0;
        this.raidedsupplies = 0;
    }
    
    public int getWall(){
        return wall;
    }
    
    public void setWall(int w){
        wall = w;
    }
    
    public int getMorale(){
        return morale;
    }
    
    public void setMorale(int m){
        morale = m;
    }
    
    public int getSupplies(){
        return supplies;
    }
    
    public void setSupplies(int s){
        supplies = s;
    }
    
    public int getTunnel(){
        return tunnel;
    }
    
    public void setTunnel(int t){
        tunnel = t;
    }

    public boolean getWeather(){
        return badWeather;
    }

    public void setBadWeather(boolean cena){
        badWeather = cena;
    }

    public int getRaidedSupplies(){
        return raidedsupplies;
    }
    
    public void setRaidedSupplies(int rs){
        raidedsupplies = rs;
    }
    
     @Override
    public String toString(){
        return ("\nSTATUS TRACK\nWall: " + wall + "\nMorale: " + morale + "\nSupplies: " + supplies + "\nTunnel: " + tunnel + "\nRaided Supplies: " + raidedsupplies + "\n");
    }
    
}
