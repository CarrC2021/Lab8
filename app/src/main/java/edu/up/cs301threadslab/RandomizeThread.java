package edu.up.cs301threadslab;

import java.util.Random;

public class RandomizeThread extends Thread {

    Random random;
    StarAnimation starAnimation;

    public RandomizeThread(StarAnimation star){
        super();
        random = new Random();
        starAnimation = star;
    }

    @Override
    public void run(){
        if (random.nextBoolean()) {
            starAnimation.addStar();
        }
        else { starAnimation.removeStar();}
            try {
                this.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
