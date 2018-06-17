
package Logica;


import java.io.Serializable;
import java.security.SecureRandom;
/**
 *
 * @author me
 */
public class Dado implements Serializable {
    private final SecureRandom random;

    private int valor;

    public Dado(){
        random = new SecureRandom();
    }
    
    
    public int rodaDado(){
        int min = 1;
        int max = 6;

        valor = random.nextInt(max) + min;

        return valor;
    }

    public int getValor(){
        return valor;
    }
}
