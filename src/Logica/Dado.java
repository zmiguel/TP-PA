
package tp;


import java.io.Serializable;
import java.security.SecureRandom;
/**
 *
 * @author me
 */
public class Dado implements Serializable {
    private final SecureRandom random;

    public Dado(){
        random = new SecureRandom();
    }
    
    
    public int rodaDado(){
        int min = 1;
        int max = 6;

        return random.nextInt(max) + min;
    }
}
