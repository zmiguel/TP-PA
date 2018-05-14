package Logica.Eventos;

import Logica.StatusTrack;

import java.io.Serializable;

public class BadWeather implements Serializable {
    public void evento( StatusTrack ST){

        ST.setBadWeather(true);
    }
}
