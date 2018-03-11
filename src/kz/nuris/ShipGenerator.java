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
        boolean isHavePlace = true;
        while (true) {
            try {
                Thread.sleep(1000);
                isHavePlace = tunel.add(new Ship(10, "Bread"));
                if (!isHavePlace) {

                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
