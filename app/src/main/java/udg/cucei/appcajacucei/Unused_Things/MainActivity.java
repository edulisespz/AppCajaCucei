package udg.cucei.appcajacucei.Unused_Things;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import udg.cucei.appcajacucei.Main2Activity_menu;
import udg.cucei.appcajacucei.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button boton =(Button) findViewById(R.id.button1);

        assert boton != null;
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PdfPrueba.class);
                startActivity(intent);
            }
        });

        Button btnInstagram = (Button) findViewById(R.id.btninstagram);

        assert btnInstagram != null;
        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InstagramTest.class);
                startActivity(intent);
            }
        });

        Button botonPaint =(Button) findViewById(R.id.button_Paint);

        assert botonPaint != null;
        botonPaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PaintTest.class);
                startActivity(intent);
            }
        });

        Button button_Menu = (Button) findViewById(R.id.buttonMenu);

        assert button_Menu != null;
        button_Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity_menu.class);
                startActivity(intent);
            }
        });

        Button button_Algoritm = (Button) findViewById(R.id.btnMathAlgo);

        assert button_Algoritm != null;
        button_Algoritm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnterDataMathTest_Activity.class);
                startActivity(intent);
            }
        });



    }
}
