package kz.nuris;

import kz.nuris.ships.Ship;
import kz.nuris.ships.types.Size;
import kz.nuris.ships.types.Type;

/**
 * Created by User on 11.03.2018.
 */
public class ShipGenerator implements Runnable {
    private Tunel tunel;
    private String threadName;

    public ShipGenerator(Tunel tunel, String threadName) {
        this.tunel = tunel;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true) {

                Thread.currentThread().setName("Поток генеретор коробля " + threadName);
                //Время на каждую генерацию судно.
                tunel.add(new Ship(Size.MIDDLE, Type.DRESS));

        }
    }


}
