package kz.nuris;

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
                Thread.currentThread().setName("Прогрузчик хлеба" +this);

                //Время на погрузку товара
                Thread.sleep(3000);
                tunel.get("Bread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
