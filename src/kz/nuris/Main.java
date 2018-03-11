package kz.nuris;

import kz.nuris.ships.Ship;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by User on 11.03.2018.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Доступное количество ядер: " + Runtime.getRuntime().availableProcessors());

        Tunel tunel = new Tunel();

        ShipGenerator shipGenerator = new ShipGenerator(tunel);
        BreadPier breadPier = new BreadPier(tunel);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(shipGenerator);
        service.execute(breadPier);



        service.shutdown();


    }
}
