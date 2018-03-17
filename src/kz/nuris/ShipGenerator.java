package kz.nuris;

import kz.nuris.ships.Ship;
import kz.nuris.ships.Size;
import kz.nuris.ships.Type;

import java.util.Random;

/**
 * Created by User on 11.03.2018.
 */
public class ShipGenerator implements Runnable {
    private Tunel tunel;
    private String threadName;
    private int shipCount;

    public ShipGenerator(Tunel tunel, String threadName , int shipCount) {
        this.tunel = tunel;
        this.threadName = threadName;
        this.shipCount = shipCount;
    }

    @Override
    public void run() {
        int count =0;
        while (count <shipCount) {
            Thread.currentThread().setName("Поток генеретор коробля " + threadName);
            count++;
            tunel.add(new Ship(getRandomSize(), getRandomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private Type getRandomType(){
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size getRandomSize(){
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}
