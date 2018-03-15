package kz.nuris;

import kz.nuris.ships.Ship;
import kz.nuris.ships.types.Type;

/**
 * Created by User on 11.03.2018.
 */
public class BreadPier implements Runnable {
    private Tunel tunel;
    private String threadName;

    public BreadPier(Tunel tunel , String threadName) {
        this.tunel = tunel;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.currentThread().setName("Прогрузчик "+Type.DRESS+" " + threadName);

                //Время на погрузку товара
                Thread.sleep(500);
                Ship ship = tunel.get(Type.DRESS);
                while (ship.countCheck()){
                    Thread.sleep(100);
                    ship.add(10);
                    System.out.println(ship.getCount() + " Загуженность судно. " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
