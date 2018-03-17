package kz.nuris;

import kz.nuris.ships.Ship;
import kz.nuris.ships.Type;

/**
 * Created by User on 11.03.2018.
 */
public class Pier implements Runnable {
    private Tunel tunel;
    private String threadName;
    private Type shipType;

    public Pier(Tunel tunel ,Type shipType ,String threadName) {
        this.tunel = tunel;
        this.threadName = threadName;
        this.shipType =shipType;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.currentThread().setName("Прогрузчик "+shipType+" " + threadName);

                //Время на погрузку товара
                Thread.sleep(500);
                Ship ship = tunel.get(shipType);
                if(ship!=null)
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
