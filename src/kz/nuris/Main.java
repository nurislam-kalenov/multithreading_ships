package kz.nuris;

import kz.nuris.ships.Type;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by User on 11.03.2018.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Доступное количество ядер: " + Runtime.getRuntime().availableProcessors());

        Tunel tunel = new Tunel();

        ShipGenerator shipGenerator1 = new ShipGenerator(tunel ,"1" ,10);

        Pier pier1 = new Pier(tunel , Type.DRESS,"1");
        Pier pier2 = new Pier(tunel ,Type.BANANA ,"2");
        Pier pier3 = new Pier(tunel , Type.MEAL,"3");

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(shipGenerator1);
        service.execute(pier1);
        service.execute(pier2);
        service.execute(pier3);

        service.shutdown();


    }
}
