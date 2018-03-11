package kz.nuris;

import kz.nuris.ships.Ship;

/**
 * Created by User on 11.03.2018.
 */
public class BreadPier implements Runnable {
    private Tunel tunel;

    public BreadPier(Tunel tunel) {
        this.tunel = tunel;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(5000);
                Ship ship = tunel.get("Bread");
                if (ship == null) {
                    System.out.println(" - Погрузка засыпает на 10 сек. ");
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
