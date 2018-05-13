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
    private boolean badWeather = false;
    private int stolenSupplies;
    private boolean sairTunnel;
    private int dia;

    public StatusTrack() {
        this.wall = 4;
        this.morale = 4;
        this.supplies = 4;   
        this.tunnel = 0;
        this.stolenSupplies = 0;
        this.sairTunnel = true;
        this.dia = 0;
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
    
    public int getStolenSupplies(){
        return stolenSupplies;
    }
    
    public void setStolenSupplies(int ss){
        stolenSupplies = ss;
    }

    public boolean isSairTunnel() {
        return sairTunnel;
    }

    public void setSairTunnel(boolean sairTunnel) {
        this.sairTunnel = sairTunnel;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void captured(){
        setStolenSupplies(0);
        setMorale(getMorale() - 1);
        setTunnel(0);
        sairTunnel = true;
    }

    public void saveRaided(){
        if(supplies < 4){
            supplies += stolenSupplies;
        }
        if(supplies > 4){
            supplies = 4;
        }
        stolenSupplies = 0;
    }

    public void TunnelFree(){
        if(sairTunnel){
            if(tunnel == 1){
                tunnel++;
            }else if(tunnel == 2){
                tunnel++;
                sairTunnel = false;
            }
        }else{
            if(tunnel == 2){
                tunnel--;
            }else if(tunnel == 1){
                tunnel--;
                sairTunnel = true;
            }
        }
        if(tunnel==0){
            saveRaided();
        }
    }
    
    
     @Override
    public String toString(){
        return ("\nSTATUS TRACK\nWall: " + wall + "\nMorale: " + morale + "\nSupplies: " + supplies + "\nTunnel: " + tunnel + "\nRaided Supplies: " + stolenSupplies + "\n");
    }
    
}
