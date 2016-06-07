package udg.cucei.appcajacucei.InputModule;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import udg.cucei.appcajacucei.R;

public class ItemInputBase extends AppCompatActivity implements Frag_ItemSize.IntefaceData {

    StateMachine machine;//TODO: implement the min and the present state


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_input_base);

        machine=new StateMachine();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            machine.minState = extras.getInt("state"); // get initial state
            machine.presentState= machine.minState;
        }

        //set statemachine Frag
        if (findViewById(R.id.fragment_Holder) != null) {
            if (savedInstanceState != null) {
                return;
            }
            switch (machine.presentState) {
                case 0:
                    Frag_ItemSize item_size = new Frag_ItemSize();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_Holder, item_size).commit();// initialize item frag
                    break;
                case 1:
                    Frag_BoxSize boxSize = new Frag_BoxSize();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_Holder, boxSize).commit();// initialize box frag
                    break;
            }
        }





        // check this:   http://stackoverflow.com/questions/24371007/get-fragments-edittext-values-on-activity-button-click-event

        //State Machine Implementation
        ImageButton BTNnext = (ImageButton) findViewById(R.id.ImgBtnSig);
        BTNnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (machine.presentState) {
                    case 0:
                        Frag_BoxSize box_size = new Frag_BoxSize();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_Holder, box_size);
                        transaction.commit();

                        machine.presentState=1;
                        break;

                    case 1:

                        break;


                }

            }
        });

        ImageButton BTNprev = (ImageButton) findViewById(R.id.ImgBtnAnt);
        BTNprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(machine.presentState==0 && machine.minState>= machine.presentState){


                }else if(machine.presentState==1 && machine.minState>= machine.presentState){ //TODO: chek >= OR > for the validation
                    Frag_ItemSize item_size = new Frag_ItemSize();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_Holder, item_size);
                    transaction.commit();

                    machine.presentState=0;
                }else if(machine.presentState==2 && machine.minState>= machine.presentState){

                }

            }
        });

    }// end onCreate


    // Interface Functions
    public void geDataSizes(int alto, int ancho, int Grueso, int peso ){
        machine.itemAlto= alto;
        machine.itemAncho= ancho;
        Log.d("itemTest","alto: "+ Integer.toString(alto));
        Log.d("itemTest","ancho: "+ Integer.toString(ancho));
    }





}
