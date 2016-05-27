package udg.cucei.appcajacucei.DrawingModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;


import udg.cucei.appcajacucei.R;

public class PaintTest extends AppCompatActivity {
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_test);

        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);

    }
}
