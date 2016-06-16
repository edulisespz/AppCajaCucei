package udg.cucei.appcajacucei.InputModule;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


import udg.cucei.appcajacucei.R;

public class ItemInputBase extends AppCompatActivity implements Frag_ItemSize.IntefaceData,Frag_BoxSize.IntefaceData_Box {

    StateMachine machine;
    ImageView ProgresBar;

    ImageButton BTNnext;
    ImageButton BTNprev;

    LinearLayout InputBaseBackGround;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_input_base);

        machine=new StateMachine();

        ProgresBar=(ImageView)findViewById(R.id.imageView_bar);
        InputBaseBackGround = (LinearLayout)findViewById(R.id.Activity_itemBase_Layout);
        BTNnext = (ImageButton) findViewById(R.id.ImgBtnSig);
        BTNprev = (ImageButton) findViewById(R.id.ImgBtnAnt);



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
            switch (machine.minState) {
                case 0:
                    Frag_ItemSize item_size = new Frag_ItemSize();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_Holder, item_size).commit();// initialize item frag
                    BTNprev.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    Frag_BoxSize boxSize = new Frag_BoxSize();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_Holder, boxSize).commit();// initialize box frag
                    ProgresBar.setImageResource(R.drawable.input_module_barra_50);
                    InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_caja_master);
                    BTNprev.setVisibility(View.INVISIBLE);
                    break;
            }
        }





        // check this:   http://stackoverflow.com/questions/24371007/get-fragments-edittext-values-on-activity-button-click-event

        //State Machine Implementation

        BTNnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (machine.presentState) {
                    case 0:
                        Frag_BoxSize box_size = new Frag_BoxSize();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_Holder, box_size);
                        transaction.commit();
                        ProgresBar.setImageResource(R.drawable.input_module_barra_50);
                        InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_caja_master);
                        BTNprev.setVisibility(View.VISIBLE);

                        machine.presentState=1;
                        break;

                    case 1:

                        break;


                }

            }
        });


        BTNprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(machine.presentState==0 && machine.minState<= machine.presentState-1){
                    //this wold never do nothing, i just write it for better code understanding

                }else if(machine.presentState==1 && machine.minState<= machine.presentState-1){ //TODO: chek <= OR < for the validation
                    Frag_ItemSize item_size = new Frag_ItemSize();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_Holder, item_size);
                    transaction.commit();
                    ProgresBar.setImageResource(R.drawable.input_module_barra);
                    InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_caja);
                    BTNprev.setVisibility(View.INVISIBLE);

                    machine.presentState=0;
                }else if(machine.presentState==2 && machine.minState>= machine.presentState-1){

                }

            }
        });

    }// end onCreate


    // Interface Functions
    public void geDataSizes_Item(int alto, int ancho, int Grueso, int peso,boolean orientation, boolean MetricSys ){
        machine.itemAlto= alto;
        machine.itemAncho= ancho;
        machine.itemGrosor= Grueso;
        machine.itempeso=peso;
        machine.itemOreintation=orientation;
        machine.Item_MetricSys= MetricSys;

        Log.d("itemTest", "alto: " + Integer.toString(alto));
        Log.d("itemTest", "ancho: " + Integer.toString(ancho));
        Log.d("item Metric", String.valueOf(MetricSys));
    }

    public void getMetricSys_Item(boolean MetricSystem){
        machine.Item_MetricSys=MetricSystem;
        Log.d("item Metric Callback", String.valueOf(MetricSystem));
    }


    public void geDataSizes_Box(int alto, int ancho, int Grueso, int peso){

        machine.boxAlto=alto;
        machine.boxAncho=ancho;
        machine.boxGrosor=Grueso;
        machine.boxPeso=peso;

    }

    public void getIsAmarred_Box(boolean isAmarred){
        machine.boxAmarred = isAmarred;
        Log.d("is amarred", Boolean.toString(isAmarred) );
    }

    public void ScrollViewChanger(String itemSelcted){
        machine.itemTipe = itemSelcted;
        if(itemSelcted.equals("square")){
            InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_caja);
        }else if(itemSelcted.equals("cilinder")){
            InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_lata);
        }else{
            InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_bottle);
        }

        Log.d("itemType: ", itemSelcted);
    }





}
