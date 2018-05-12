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
public class DRM {
    private int Ladders;
    private int BatteringRam;
    private int SiegeTower;

    DRM(){
        this.Ladders = 0;
        this.BatteringRam = 0;
        this.SiegeTower = 0;

    }
    
    public int getLadders(){
        return Ladders;
    }

    public int getBatteringRam(){
        return BatteringRam;
    }

    public int getSiegeTower(){
        return SiegeTower;
    }

    public void setLadders(int l){
        Ladders = l;
    }

    public void setBatteringRam(int br){
        BatteringRam = br;
    }

    public void setSiegeTower(int st){
        SiegeTower = st;
    }

    public void resetDRM(){
        Ladders = SiegeTower = BatteringRam = 0;
    }
    
}
