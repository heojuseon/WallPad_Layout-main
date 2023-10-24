package yiwoo.yiwoo_example.wallpad_layout.model.m_weather;


import java.util.Random;


public class Temp {
    Random randTemp;

    public Temp() {

    }

    public Random getRandTemp() {
        randTemp = new Random();
        return randTemp;
    }

    public void tempRandom() {

        randTemp = new Random();

    }


}
