package kz.nuris;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by User on 11.03.2018.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Доступное количество ядер: " + Runtime.getRuntime().availableProcessors());

        Tunel tunel = new Tunel();

        ShipGenerator shipGenerator1 = new ShipGenerator(tunel ,"1");
       // ShipGenerator shipGenerator2 = new ShipGenerator(tunel ,"2");

        BreadPier breadPier1 = new BreadPier(tunel , "1");
        BreadPier breadPier2 = new BreadPier(tunel , "2");
        BreadPier breadPier3 = new BreadPier(tunel , "3");

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(shipGenerator1);
     //   service.execute(shipGenerator2);

        service.execute(breadPier2);
        service.execute(breadPier3);
        service.execute(breadPier1);

        service.shutdown();


    }
}
