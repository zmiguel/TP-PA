
package tp;


import java.util.Random;
/**
 *
 * @author me
 */
public class Dado {
    Random random;

    public Dado(){
        random = new Random();
    }
    
    
    public int rodaDado(){
        int min = 1;
        int max = 6;
        
        return random.nextInt(max) + min;
    }
}
