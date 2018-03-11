package kz.nuris;

import kz.nuris.ships.Ship;

/**
 * Created by User on 11.03.2018.
 */
public class ShipGenerator implements Runnable {
    private Tunel tunel;


    public ShipGenerator(Tunel tunel) {
        this.tunel = tunel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().setName("Поток генеретор коробля");
                //Время на каждую генерацию судно.
                Thread.sleep(2000);
                tunel.add(new Ship(10, "Bread"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
