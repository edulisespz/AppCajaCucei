package udg.cucei.appcajacucei.InputModule;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import udg.cucei.appcajacucei.R;

public class ItemInputBase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_input_base);


        if (findViewById(R.id.fragment_Holder) != null) {
            if (savedInstanceState != null) {
                return;
            }
            Frag_ItemSize item_size = new Frag_ItemSize();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_Holder, item_size).commit();

        }

        ImageButton BTNnext = (ImageButton) findViewById(R.id.ImgBtnSig);
        BTNnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Frag_BoxSize box_size = new Frag_BoxSize();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder, box_size);
                transaction.commit();

            }
        });

        ImageButton BTNprev = (ImageButton) findViewById(R.id.ImgBtnAnt);
        BTNprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Frag_ItemSize item_size = new Frag_ItemSize();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder, item_size);
                transaction.commit();

            }
        });




    }
}
