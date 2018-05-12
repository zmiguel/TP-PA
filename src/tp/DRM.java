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
    private int Ladders = 0;
    private int BatteringRam = 0;
    private int SiegeTower = 0;
    
    public int getDRM(String nome){
        if("Ladders".equals(nome)){
            return Ladders;
        }
        
        if("BatteringRam".equals(nome)){
            return BatteringRam;
        }
        
        if("SiegeTower".equals(nome)){
            return SiegeTower;
        }
        return 0;
    }
    
    public void setDRMLadders(int l){
        Ladders = l;
    }
    
    public void setDRMBatteringRam(int br){
        BatteringRam = br;
    }
    
    public void setDRMSiegeTower(int st){
        SiegeTower = st;
    }
    
    
}
