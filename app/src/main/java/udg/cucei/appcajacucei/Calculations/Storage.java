package udg.cucei.appcajacucei.Calculations;

/**
 * Created by Edgar Ulises on 27/04/2016.
 */
public class Storage {
    int amount;
    int x, y, z;
    int weight;

    public Storage() { }

    public Storage(int a, int b, int c, int d)
    {
        x = a;
        y = b;
        z = c;
        amount = d;
    }

    public int getAmount() {
        return amount;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

}
