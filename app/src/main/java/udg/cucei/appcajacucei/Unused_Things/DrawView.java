package udg.cucei.appcajacucei.Unused_Things;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Edgar Ulises on 14/04/2016.
 */

public class DrawView extends View {
    Paint paint = new Paint();

    int w;
    int h;

    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
    }

    @Override
    public void onDraw(Canvas canvas) {
        w = canvas.getWidth();
        h = canvas.getHeight();

        int centerWx = w/2;
        int centerHy = h/2;

        //horizontal line
        canvas.drawLine(centerWx - 50, centerHy, centerWx + 50, centerHy, paint);
        //vertical line
        canvas.drawLine(centerWx, centerHy - 50, centerWx, centerHy + 50, paint);

    }

}

