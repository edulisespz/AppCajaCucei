package udg.cucei.appcajacucei;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import udg.cucei.appcajacucei.InputModule.ItemInputBase;

public class Main2Activity_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_activity_menu);

        ImageButton btnBottle = (ImageButton) findViewById(R.id.imageButton_MenuBottle);

        assert btnBottle != null;
        btnBottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity_menu.this, ItemInputBase.class);
                intent.putExtra("state",0); // send the initial state
                startActivity(intent);
            }
        });

        ImageButton btnBox = (ImageButton)findViewById(R.id.imageButton_MenuCaja);
        assert btnBox != null;
        btnBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity_menu.this, ItemInputBase.class);
                intent.putExtra("state",1);
                startActivity(intent);
            }
        });

        ImageButton btnpallet = (ImageButton)findViewById(R.id.imageButton_MenuPalette);
        assert btnpallet != null;
        btnpallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity_menu.this, ItemInputBase.class);
                intent.putExtra("state",4);
                startActivity(intent);
            }
        });




    }
}
