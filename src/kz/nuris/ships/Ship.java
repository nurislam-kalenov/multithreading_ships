package kz.nuris.ships;

/**
 * Created by User on 11.03.2018.
 */
public class Ship {

    public Ship(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int count;
    private String name;

}
