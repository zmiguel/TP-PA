package Main;

import Logica.*;
import controler.Controler;
import ui.graphic.*;

public class Main {
    public static void main(String[] args){
        Mundo mundo = new Mundo();

        MenuInicial mi = new MenuInicial();
        Jogo j = new Jogo(mundo);
        Controler c = new Controler(mundo, mi, j);

        c.run();
    }
}
