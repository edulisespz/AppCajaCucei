package udg.cucei.appcajacucei.Calculations;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Edgar Ulises on 27/04/2016.
 */
public class ListStorage extends ArrayList<Storage>{
    int totalAmount;
    int desiredAmount;
    int style;
    Shape element, box;

    public ListStorage(Shape element, Shape box, int amount)
    {
        totalAmount = 0;
        desiredAmount = amount;
        //storageKind(element, box);
        this.element = element;
        this.box = box;
        style = 0;
    }
    public ListStorage(Shape element, Shape box, int desiredAmount, int totalAmount, int style)
    {
        this.desiredAmount = desiredAmount;
        this.totalAmount = totalAmount;
        this.style = style;
        //storageKind(element, box);
        this.element = element;
        this.box = box;

    }

    int getTotalAmount()
    {
        return totalAmount;
    }

    public int storageKind()
    {
        //Storage s;
        int r = -1;
        List<Integer> completed = new ArrayList<Integer>();
        List<ListStorage> posibles = new ArrayList<ListStorage>();
        List<Integer> kinds = new ArrayList<Integer>();
        if (totalAmount >= desiredAmount)
            return 1;

        else if (this.style == 0)
        {
            int kindF;
            kinds.add((box.getX() / element.getX()) * (box.getY() / element.getY()) * (box.getZ() / element.getZ()));
            kinds.add((box.getX() / element.getY()) * (box.getY() / element.getX()) * (box.getZ() / element.getZ()));
            kinds.add((box.getX() / element.getX()) * (box.getY() / element.getZ()) * (box.getZ() / element.getY()));
            kinds.add((box.getX() / element.getZ()) * (box.getY() / element.getX()) * (box.getZ() / element.getY()));
            kinds.add((box.getX() / element.getY()) * (box.getY() / element.getZ()) * (box.getZ() / element.getX()));
            kinds.add((box.getX() / element.getZ()) * (box.getY() / element.getY()) * (box.getZ() / element.getX()));
            kindF = Collections.max(kinds);

            if (kindF < 1)
                return -1;
                /*if (totalAmount >= desiredAmount)
                    completed.add(1);
                else if (kindF < 1)
                    completed.add(-1);
                else
                {*/
            if (kinds.get(0) == kindF)
            {
                int newX = box.getX() - (element.getX() * (box.getX() / element.getX()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(0), 0, 1);
                Storage s = new Storage(element.getX(), element.getY(), element.getZ(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;

                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getY() * (box.getY() / element.getY()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(0), 0, 1);
                Storage s2 = new Storage(element.getX(), element.getY(), element.getZ(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getZ() * (box.getZ() / element.getZ()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(0), 0, 1);
                Storage s3 = new Storage(element.getX(), element.getY(), element.getZ(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }
            if (kinds.get(1) == kindF)
            {
                int newX = box.getX() - (element.getY() * (box.getX() / element.getY()));
                int newY = box.getY();// - (element.getY() * (box.getY() / element.getY()));
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(1), 0, 1);
                Storage s = new Storage(element.getY(), element.getX(), element.getZ(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getX() * (box.getY() / element.getX()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(1), 0, 1);
                Storage s2 = new Storage(element.getY(), element.getX(), element.getZ(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getZ() * (box.getZ() / element.getZ()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(1), 0, 1);
                Storage s3 = new Storage(element.getY(), element.getX(), element.getZ(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }
            if (kinds.get(2) == kindF)
            {
                int newX = box.getX() - (element.getX() * (box.getX() / element.getX()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(2), 0, 2);
                Storage s = new Storage(element.getX(), element.getZ(), element.getY(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getZ() * (box.getY() / element.getZ()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(2), 0, 2);
                Storage s2 = new Storage(element.getX(), element.getZ(), element.getY(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getY() * (box.getZ() / element.getY()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(2), 0, 2);
                Storage s3 = new Storage(element.getX(), element.getZ(), element.getY(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }
            if (kinds.get(3) == kindF)
            {
                int newX = box.getX() - (element.getZ() * (box.getX() / element.getZ()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(3), 0, 2);
                Storage s = new Storage(element.getZ(), element.getX(), element.getY(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getX() * (box.getY() / element.getX()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(3), 0, 2);
                Storage s2 = new Storage(element.getZ(), element.getX(), element.getY(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getY() * (box.getZ() / element.getY()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(3), 0, 2);
                Storage s3 = new Storage(element.getZ(), element.getX(), element.getY(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }
            if (kinds.get(4) == kindF)
            {
                int newX = box.getX() - (element.getY() * (box.getX() / element.getY()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(4), 0, 3);
                Storage s = new Storage(element.getY(), element.getZ(), element.getX(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getZ() * (box.getY() / element.getZ()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(4), 0, 3);
                Storage s2 = new Storage(element.getY(), element.getZ(), element.getX(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getX() * (box.getZ() / element.getX()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(4), 0, 3);
                Storage s3 = new Storage(element.getY(), element.getZ(), element.getX(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }
            if (kinds.get(5) == kindF)
            {
                int newX = box.getX() - (element.getZ() * (box.getX() / element.getZ()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(5), 0, 3);
                Storage s = new Storage(element.getZ(), element.getY(), element.getX(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getY() * (box.getY() / element.getY()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(5), 0, 3);
                Storage s2 = new Storage(element.getZ(), element.getY(), element.getX(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getX() * (box.getZ() / element.getX()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(5), 0, 3);
                Storage s3 = new Storage(element.getZ(), element.getY(), element.getX(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }
        }
        else if (this.style == 1)
        {
            int kindF;
            kinds.add((box.getX() / element.getX()) * (box.getY() / element.getY()) * (box.getZ() / element.getZ()));
            kinds.add((box.getX() / element.getY()) * (box.getY() / element.getX()) * (box.getZ() / element.getZ()));
            kindF = Collections.max(kinds);

            if (kindF < 1)
                return -1;

            if (kinds.get(0) == kindF)
            {
                int newX = box.getX() - (element.getX() * (box.getX() / element.getX()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(0), 0, 1);
                Storage s = new Storage(element.getX(), element.getY(), element.getZ(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getY() * (box.getY() / element.getY()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(0), 0, 1);
                Storage s2 = new Storage(element.getX(), element.getY(), element.getZ(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getZ() * (box.getZ() / element.getZ()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(0), 0, 1);
                Storage s3 = new Storage(element.getX(), element.getY(), element.getZ(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }
            if (kinds.get(1) == kindF)
            {
                int newX = box.getX() - (element.getY() * (box.getX() / element.getY()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(1), 0, 1);
                Storage s = new Storage(element.getY(), element.getX(), element.getZ(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getX() * (box.getY() / element.getX()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(1), 0, 1);
                Storage s2 = new Storage(element.getY(), element.getX(), element.getZ(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getZ() * (box.getZ() / element.getZ()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(1), 0, 1);
                Storage s3 = new Storage(element.getY(), element.getX(), element.getZ(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }
        }
        else if (this.style == 2)
        {
            int kindF;
            kinds.add((box.getX() / element.getX()) * (box.getY() / element.getZ()) * (box.getZ() / element.getY()));
            kinds.add((box.getX() / element.getZ()) * (box.getY() / element.getX()) * (box.getZ() / element.getY()));
            kindF = Collections.max(kinds);

            if (kindF < 1)
                return -1;

            if (kinds.get(0) == kindF)
            {
                int newX = box.getX() - (element.getX() * (box.getX() / element.getX()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(0), 0, 2);
                Storage s = new Storage(element.getX(), element.getZ(), element.getY(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getZ() * (box.getY() / element.getZ()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(0), 0, 2);
                Storage s2 = new Storage(element.getX(), element.getZ(), element.getY(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getY() * (box.getZ() / element.getY()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(0), 0, 2);
                Storage s3 = new Storage(element.getX(), element.getZ(), element.getY(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }
            if (kinds.get(1) == kindF)
            {
                int newX = box.getX() - (element.getZ() * (box.getX() / element.getZ()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(1), 0, 2);
                Storage s = new Storage(element.getZ(), element.getX(), element.getY(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getX() * (box.getY() / element.getX()));// - (element.getY() * (box.getY() / element.getY()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(1), 0, 2);
                Storage s2 = new Storage(element.getZ(), element.getX(), element.getY(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getY() * (box.getZ() / element.getY()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(1), 0, 2);
                Storage s3 = new Storage(element.getZ(), element.getX(), element.getY(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }

        }
        else if (this.style == 3)
        {
            int kindF;
            kinds.add((box.getX() / element.getY()) * (box.getY() / element.getZ()) * (box.getZ() / element.getX()));
            kinds.add((box.getX() / element.getZ()) * (box.getY() / element.getY()) * (box.getZ() / element.getX()));
            kindF = Collections.max(kinds);

            if (kindF < 1)
                return -1;

            if (kinds.get(0) == kindF)
            {
                int newX = box.getX() - (element.getY() * (box.getX() / element.getY()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(0), 0, 3);
                Storage s = new Storage(element.getY(), element.getZ(), element.getX(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getZ() * (box.getY() / element.getZ()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(0), 0, 3);
                Storage s2 = new Storage(element.getY(), element.getZ(), element.getX(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getX() * (box.getZ() / element.getX()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(0), 0, 3);
                Storage s3 = new Storage(element.getY(), element.getZ(), element.getX(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }
            if (kinds.get(1) == kindF)
            {
                int newX = box.getX() - (element.getZ() * (box.getX() / element.getZ()));
                int newY = box.getY();
                int newZ = box.getZ();
                Shape newBox = new Shape(newX, newY, newZ);
                ListStorage p = new ListStorage(element, newBox, desiredAmount - kinds.get(1), 0, 3);
                Storage s = new Storage(element.getZ(), element.getY(), element.getX(), kindF);
                p.add(s);
                completed.add(p.storageKind());
                totalAmount = kindF;
                posibles.add(p);


                int newX2 = box.getX();
                int newY2 = box.getY() - (element.getY() * (box.getY() / element.getY()));
                int newZ2 = box.getZ();
                Shape newBox2 = new Shape(newX2, newY2, newZ2);
                ListStorage p2 = new ListStorage(element, newBox2, desiredAmount - kinds.get(1), 0, 3);
                Storage s2 = new Storage(element.getZ(), element.getY(), element.getX(), kindF);
                p2.add(s2);
                completed.add(p2.storageKind());
                totalAmount = kindF;
                posibles.add(p2);


                int newX3 = box.getX();
                int newY3 = box.getY();
                int newZ3 = box.getZ() - (element.getX() * (box.getZ() / element.getX()));
                Shape newBox3 = new Shape(newX3, newY3, newZ3);
                ListStorage p3 = new ListStorage(element, newBox3, desiredAmount - kinds.get(1), 0, 3);
                Storage s3 = new Storage(element.getZ(), element.getY(), element.getX(), kindF);
                p3.add(s3);
                completed.add(p3.storageKind());
                totalAmount = kindF;
                posibles.add(p3);
            }

        }
        int i = 0;
        int max = 0;
        int indMax = -1;

        for (ListStorage p : posibles)
        {
            if (completed.get(i) == 1 && p.totalAmount >= max)
            {
                max = p.totalAmount;
                indMax = i;
                r = 1;
            }
            i++;
        }

        if (indMax != -1)
        {
            this.addAll(posibles.get(indMax));  //TODO: testing
            totalAmount += max;
            return completed.get(indMax);
        }
        else
            return -1;

    }
}
