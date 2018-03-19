package kz.nuris.tasks;

import kz.nuris.Tunnel;
import kz.nuris.ships.Ship;
import kz.nuris.ships.types.Size;
import kz.nuris.ships.types.Type;

import java.util.Random;

/**
 * Created by Nurislam Kalenov.
 */
public class ShipGenerator implements Runnable {
    private Tunnel tunnel;
    private int shipCount;

    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < shipCount) {
            Thread.currentThread().setName(" Generator ship");
            count++;
            tunnel.add(new Ship(getRandomSize(), getRandomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}
