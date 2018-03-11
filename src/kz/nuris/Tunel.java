package kz.nuris;

import kz.nuris.ships.Ship;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11.03.2018.
 */
public class Tunel {

    private List<Ship> store;
    private static final int maxShipsInTunel = 5;
    private static final int minShipsInTunel = 0;
    private int shipsCounter = 0;


    public Tunel() {
        store = new ArrayList<>();
    }

    public synchronized boolean add(Ship element) {
        if (shipsCounter < maxShipsInTunel) {
            store.add(element);
            System.out.println(store.size() + "+ Судно прибыло в тунель: " + Thread.currentThread().getName());
            shipsCounter++;
        } else {
            System.out.println(store.size() + "+ Нет место для судно в тунеле: "+ Thread.currentThread().getName());
            return false;
        }
        return true;
    }

    public synchronized Ship get(String name) {
        if (shipsCounter > minShipsInTunel) {
            for (Ship ship : store) {
                if (ship.getName().equals(name)) {
                    shipsCounter--;
                    System.out.println(store.size() + "- Судно взято из тунеля: " + Thread.currentThread().getName());
                    store.remove(ship);
                    return ship;
                }
            }
        }
        return null;
    }


}
