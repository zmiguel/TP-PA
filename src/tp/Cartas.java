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
public class Cartas {
    
    private int id;
    Eventos[] Evento = new Eventos[3];
    
    public Cartas(int i){
        this.id = i + 1;
        
        if(i == 0){
            int[] temp = {0};
            this.Evento[0] = new Eventos(3, temp, "Trebuchet Attack", "Later");
            this.Evento[1] = new Eventos(2, temp, "Trebuchet Attack", "Later");
            this.Evento[2] = new Eventos(1, temp, "Trebuchet Attack", "Later");
        }else if(i == 1){
            int[] temp = {3};
            this.Evento[0] = new Eventos(2, temp, "Illness", "-1 Moral; -1 Supplies");
            temp[0] = 4;
            this.Evento[1] = new Eventos(2, temp, "Guards Distracted", "+1 Sabotage Action; +1 Morale Action");
            temp[0] = 0;
            this.Evento[2] = new Eventos(1, temp, "Trebuchet Attack", "Later");
        }else if(i == 2){
            int[] temp = {1};
            this.Evento[0] = new Eventos(2, temp, "Supplies Spoiled", "-1 Supplies");
            temp[0] = 0;
            this.Evento[1] = new Eventos(2, temp, "Bad Weather", "Only Raid and Sabotage actions are allowed this turn");
            int[] temp1 = {1, 2};
            this.Evento[2] = new Eventos(2, temp1, "Boiling Oil", "+2 Attack on enemy units in circle spaces");
        
        }else if(i == 3){
            int[] temp1 = {1, 3};
            this.Evento[0] = new Eventos(2, temp1, "Death of a Leader", "-1 Morale");
            
            temp1[0] = 1;
            temp1[1] = 2;
            this.Evento[1] = new Eventos(2, temp1, "Gate Fortified", "+1 Attack on Battering Ram");
            
            int [] temp = {0};
            temp[0] = 3;
            this.Evento[2] = new Eventos(3, temp, "Flaming Arrows", "+1 Attack on Siege Engine");
        
        } else if(i == 4){
            int[] temp = {2};
            this.Evento[0] = new Eventos(3, temp, "Volley of Arrows", "+1 to all attacks");
            
            int[] temp1 = {1, 2};
            this.Evento[1] = new Eventos(2, temp1, "Collapsed", "Siege Tower removed from game if on starting space");
            
            temp[0] = 1;
            this.Evento[2] = new Eventos(2, temp, "Repaired Trebuchet", "+1 Trebuchet (MAX 3); +1 to Coupure action");
        }else if(i == 5){
            int[] temp = {4};
            this.Evento[0] = new Eventos(3, temp, "Cover of Darkness", "+1 to Raid and Sabotage actions");
            
            temp[0] = 1;
            this.Evento[1] = new Eventos(3, temp, "Enemy Fatigue", "+1 to Coupure, Raid and Sabotage Actions");
            

            int[] temp1 = {2,3};
            this.Evento[2] = new Eventos(3, temp1, "Rally!", "+1 to attacks on Close Combat or Circle Spaces");
        
        } else if(i == 6){
            int[] temp = {2};
            this.Evento[0] = new Eventos(2, temp, "Determined Enemy", "-1 on attacks on the Battering Ram");
            
            temp[0] = 3;
            this.Evento[1] = new Eventos(2, temp, "Iron Shields", "-1 to attacks on the Siege Tower");
            

            int[] temp1 = {1,2,3};
            this.Evento[2] = new Eventos(3, temp1, "Faith", "+1 to attacks on Battering Ram, Ladders and Morale Action");
        
        
        }
    }
    
    public int getID(){
        return id;
    }
    
}
