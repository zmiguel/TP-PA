/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;

/**
 *
 * @author Ricardo Marques
 */
public class DRM implements Serializable {
    private int Ladders;
    private int BatteringRam;
    private int SiegeTower;
    private int MoraleAction;
    private int SabotageAction;
    private int CompureAction;
    private int RaidAction;
    private int Circle;
    private int Close;

    DRM(){
        this.Ladders = 0;
        this.BatteringRam = 0;
        this.SiegeTower = 0;
        this.SabotageAction = 0;
        this.MoraleAction = 0;
        this.CompureAction = 0;
        this.RaidAction = 0;
        this.Circle = 0;
        this.Close = 0;

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

    public int getMoraleAction(){
        return MoraleAction;
    }

    public int getSabotageAction(){
        return SabotageAction;
    }

    public int getCompureAction(){
        return CompureAction;
    }

    public int getRaidAction(){
        return RaidAction;
    }

    public int getCircle() {
        return Circle;
    }

    public int getClose() {
        return Close;
    }

    ///-----------------------------///

    public void setLadders(int l){
        Ladders = l;
    }

    public void setBatteringRam(int br){
        BatteringRam = br;
    }

    public void setSiegeTower(int st){
        SiegeTower = st;
    }

    public void setMoraleAction(int ma){
        MoraleAction = ma;
    }

    public void setSabotageAction(int sa){
        SabotageAction = sa;
    }

    public void setCompureAction(int ca){
        CompureAction = ca;
    }

    public void setRaidAction(int raidAction) {
        RaidAction = raidAction;
    }

    public void setCircle(int circle) {
        Circle = circle;
    }

    public void setClose(int close) {
        Close = close;
    }

    public void resetDRM(){
        Ladders = SiegeTower = BatteringRam = MoraleAction = SabotageAction = CompureAction = RaidAction = Circle = Close = 0;
    }
    
}
