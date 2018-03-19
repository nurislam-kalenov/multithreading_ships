package kz.nuris;

import kz.nuris.ships.Ship;
import kz.nuris.ships.types.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurislam Kalenov.
 */
public class Tunnel {

    private List<Ship> store;
    private static final int maxShipsInTunel = 5;
    private static final int minShipsInTunel = 0;
    private int shipsCounter = 0;


    public Tunnel() {
        store = new ArrayList<>();
    }

    public synchronized boolean add(Ship element) {

        try {
            if (shipsCounter < maxShipsInTunel) {
                notifyAll();
                store.add(element);
                String info = String.format("%s + The ship arrived in the tunnel: %s %s %s", store.size(), element.getType(), element.getSize(), Thread.currentThread().getName());
                System.out.println(info);
                shipsCounter++;

            } else {
                System.out.println(store.size() + "> There is no place for a ship in the tunnel: " + Thread.currentThread().getName());
                wait();
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Ship get(Type shipType) {

        try {
            if (shipsCounter > minShipsInTunel) {
                notifyAll();
                for (Ship ship : store) {
                    if (ship.getType() == shipType) {
                        shipsCounter--;
                        System.out.println(store.size() + "- The ship is taken from the tunnel: " + Thread.currentThread().getName());
                        store.remove(ship);
                        return ship;
                    }
                }
            }

            System.out.println("0 < There are no ships in the tunnel");
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }


}
