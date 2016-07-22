package udg.cucei.appcajacucei;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import udg.cucei.appcajacucei.InputModule.ItemInputBase;
import udg.cucei.appcajacucei.PdfModule.FileChooser;

public class Main2Activity_menu extends AppCompatActivity {

    //private int PICK_IMAGE_REQUEST = 1;

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

        ImageButton btnfile = (ImageButton)findViewById(R.id.imageButton_MenuDocument);
        assert btnfile != null;
        btnfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //working but not in specific folder
                //Intent intent = new Intent();
                ////intent.setType("application/pdf");
                //Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
                //        + "/pdfdemo_itext/");
                //intent.setDataAndType(uri, "application/pdf");
                //intent.setAction(Intent.ACTION_GET_CONTENT);
                //// Always show the chooser (if there are multiple options available)
                //startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

                Intent intent = new Intent(Main2Activity_menu.this, FileChooser.class);
                startActivity(intent);


            }
        });







    }
}
