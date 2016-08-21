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

    int getAmount()
    {
        return amount;
    }

    int getX()
    {
        return x;
    }

    int getY()
    {
        return y;
    }

    int getZ()
    {
        return z;
    }

}
