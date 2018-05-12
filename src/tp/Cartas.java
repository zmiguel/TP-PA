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
    
    private final int id;
    private final int dia = 0;
    private final Eventos[] Evento = new Eventos[3];
    
    public Cartas(int i){
        this.id = i + 1;
        String []enemyCombo = {"Nothing"};
        String []enemyCombo1 = {"Ladders"};
        String []enemyCombo2 = {"Battering Ram"};
        String []enemyCombo3 = {"Tower Siege"};
        String []enemyCombo4 = {"Slowest Unit Movement"};
        String []enemyCombo5 = {"Ladders", "Battering Ram"};
        String []enemyCombo6 = {"Ladders", "Tower Siege"};
        String []enemyCombo7 = {"Battering Ram", "Tower Siege"};
        String []enemyCombo8 = {"Ladders","Battering Ram", "Tower Siege"};
  
        if(i == 0){
            this.Evento[0] = new Eventos(3, enemyCombo, "Trebuchet Attack", "Later");
            this.Evento[1] = new Eventos(2, enemyCombo, "Trebuchet Attack", "Later");
            this.Evento[2] = new Eventos(1, enemyCombo, "Trebuchet Attack", "Later");
        }else if(i == 1){
            this.Evento[0] = new Eventos(2, enemyCombo3, "Illness", "-1 Moral; -1 Supplies");
            this.Evento[1] = new Eventos(2, enemyCombo4, "Guards Distracted", "+1 Sabotage Action; +1 Morale Action");
            this.Evento[2] = new Eventos(1, enemyCombo, "Trebuchet Attack", "Later");
        }else if(i == 2){
            this.Evento[0] = new Eventos(2, enemyCombo1, "Supplies Spoiled", "-1 Supplies");
            this.Evento[1] = new Eventos(2, enemyCombo, "Bad Weather", "Only Raid and Sabotage actions are allowed this turn");
            this.Evento[2] = new Eventos(2, enemyCombo5, "Boiling Oil", "+2 Attack on enemy units in circle spaces");
        }else if(i == 3){
            this.Evento[0] = new Eventos(2, enemyCombo6, "Death of a Leader", "-1 Morale");
            this.Evento[1] = new Eventos(2, enemyCombo5, "Gate Fortified", "+1 Attack on Battering Ram");
            this.Evento[2] = new Eventos(3, enemyCombo3, "Flaming Arrows", "+1 Attack on Siege Engine");
        } else if(i == 4){
            this.Evento[0] = new Eventos(3, enemyCombo2, "Volley of Arrows", "+1 to all attacks");
            this.Evento[1] = new Eventos(2, enemyCombo5, "Collapsed", "Siege Tower removed from game if on starting space");
            this.Evento[2] = new Eventos(2, enemyCombo1, "Repaired Trebuchet", "+1 Trebuchet (MAX 3); +1 to Coupure action");
        }else if(i == 5){
            this.Evento[0] = new Eventos(3, enemyCombo4, "Cover of Darkness", "+1 to Raid and Sabotage actions");
            this.Evento[1] = new Eventos(3, enemyCombo1, "Enemy Fatigue", "+1 to Coupure, Raid and Sabotage Actions");
            this.Evento[2] = new Eventos(3, enemyCombo7, "Rally!", "+1 to attacks on Close Combat or Circle Spaces");
        } else if(i == 6){
            this.Evento[0] = new Eventos(2, enemyCombo2, "Determined Enemy", "-1 on attacks on the Battering Ram");
            this.Evento[1] = new Eventos(2, enemyCombo3, "Iron Shields", "-1 to attacks on the Siege Tower");
            this.Evento[2] = new Eventos(3, enemyCombo8, "Faith", "+1 to attacks on Battering Ram, Ladders and Morale Action");
        }
    }
    
    
   public int getNumActions(){
       return Evento[dia].getNumActions();
   }     
           
   
   public String[] combo(){
       return Evento[dia].getCombo();
   }
   
   
  public String sss(){
      return (Evento[dia].nome);
  }
  
   @Override
   public String toString() {
        return ("Carta: "+ id + " Evento: " + Evento[dia].nome);
   }
   
}
