package Logica;

import java.io.*;

public class FileUtility
{
    public static final String FILE_TO_SAVE_GAME = "savedgame.bin";

    public static void saveGameToFile(File file, Object o) throws IOException
    {
        ObjectOutputStream oout = null;

        try{

            oout = new ObjectOutputStream(new FileOutputStream(file));
            oout.writeObject(o);

        }finally{
            if(oout != null)
                oout.close();
        }
    }

    public static Object retrieveGameFromFile(File file) throws IOException, ClassNotFoundException
    {
        ObjectInputStream oin = null;

        try{

            oin = new ObjectInputStream(new FileInputStream(file));
            return oin.readObject();

        }finally{
            if(oin != null)
                oin.close();
        }
    }

}

