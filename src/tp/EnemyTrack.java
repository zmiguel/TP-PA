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
public class EnemyTrack {
    private int posLadder;
    private int strenghtLadder;
    private int posBatteringRam;
    private int strenghtBatteringRam;
    private int posSiegeTower;
    private int strenghtSiegeTower;
    private int trebuchet;
    private boolean SiegeTower = true;

    public EnemyTrack() {
        this.posLadder = 4;
        this.strenghtLadder = 2;
        
        this.posBatteringRam = 4;
        this.strenghtBatteringRam = 3;
        
        this.posSiegeTower = 4;
        this.strenghtSiegeTower = 4;
        
        this.trebuchet = 3;
    }
   
    public int getPosLadder(){
        return posLadder;
    }
    
    public void setPosLadder(int pl){
        posLadder = pl;
    }
    
    
    public int getStrenghtLadder(){
        return strenghtLadder;
    }
    
    public void setStrenghtLadder(int sl){
        strenghtLadder = sl;
    }
    
    
    
    public int getPosBatteringRam(){
        return posBatteringRam;
    }
    
    public void setPosBatteringRam(int pbr){
        posBatteringRam = pbr;
    }
    
    
    public int getStrenghtBatteringRam(){
        return strenghtBatteringRam;
    }
    
    public void setStrenghtBatteringRam(int srm){
        strenghtBatteringRam = srm;
    } 
    
    
    public int getPosSiegeTower(){
        return posSiegeTower;
    }
    
    public void setPosSiegeTower(int pst){
        posSiegeTower = pst;
    }
    
    
    public int getStrenghtSiegeTower(){
        return strenghtSiegeTower;
    }
    
    public void setStrenghtSiegeTower(int sst){
        strenghtSiegeTower = sst;
    }
    
    
    public int getTrebuchet(){
        return trebuchet;
    }
    
    public void setTrebuchet(int t){
        trebuchet = t;
    }

    public boolean isSiegeTower() {
        return SiegeTower;
    }

    public void setSiegeTower(boolean v){
        SiegeTower = v;
    }

    public boolean perdaJogoInsta(){
        if(posBatteringRam ==0 && posLadder == 0 && posSiegeTower == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean perdaJogoFimTurno(){
        if(posLadder == 0 && posBatteringRam == 0 || posLadder == 0 && posSiegeTower == 0 || posBatteringRam == 0 && posSiegeTower == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        return ("ENEMY TRACK\nPosition Ladders: " + posLadder + "\nPosition Battering Ram: " + posBatteringRam + "\nPosition Siege Tower: " + posSiegeTower + "\n");
    }
    
}
