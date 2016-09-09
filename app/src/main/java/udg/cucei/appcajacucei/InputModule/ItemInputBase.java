package udg.cucei.appcajacucei.InputModule;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import udg.cucei.appcajacucei.OutputModule.Frag_ContenedorResutls;
import udg.cucei.appcajacucei.OutputModule.Frag_EmpaquetadoResults;
import udg.cucei.appcajacucei.OutputModule.Frag_EntarimadoResults;
import udg.cucei.appcajacucei.PdfModule.PdfClass;
import udg.cucei.appcajacucei.Unused_Things.ReportActivity;
import udg.cucei.appcajacucei.R;

public class ItemInputBase extends AppCompatActivity implements Frag_ItemSize.IntefaceData,Frag_BoxSize.IntefaceData_Box,
        Frag_McKee.Inteface_Data_McKee,Frag_Pallet.Inteface_Data_fragPallet,Frag_Container.Inteface_Data_fragContainer {

    StateMachine machine;
    ImageView ProgresBar;

    ImageButton BTNnext;
    ImageButton BTNprev;

    LinearLayout InputBaseBackGround;
    FragmentTransaction transaction;

    boolean ignoreFrag_empaqRes;
    boolean ignoreFrag_EntarimRes;
    boolean ignoreFrag_ContainerRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_input_base);

        machine=new StateMachine();

        ProgresBar=(ImageView)findViewById(R.id.imageView_bar);
        InputBaseBackGround = (LinearLayout)findViewById(R.id.Activity_itemBase_Layout);
        BTNnext = (ImageButton) findViewById(R.id.ImgBtnSig);
        BTNprev = (ImageButton) findViewById(R.id.ImgBtnAnt);

        ignoreFrag_empaqRes = false;
        ignoreFrag_EntarimRes = false;
        ignoreFrag_ContainerRes = false;



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

                    ignoreFrag_empaqRes = true;
                    break;
                case 4:
                    Frag_Pallet palletSize = new Frag_Pallet();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_Holder, palletSize).commit();// initialize pallet frag
                    ProgresBar.setImageResource(R.drawable.input_module_barra_75);
                    InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_pallet);
                    BTNprev.setVisibility(View.INVISIBLE);

                    ignoreFrag_EntarimRes = true;
                    break;

                case 6:
                    Frag_Container cont = new Frag_Container();
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_Holder, cont).commit();
                    ProgresBar.setImageResource(R.drawable.input_module_barra_100);
                    InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_contenedor);
                    BTNprev.setVisibility(View.INVISIBLE);
                    BTNnext.setVisibility(View.INVISIBLE);

                    ignoreFrag_ContainerRes = true;
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

                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_Holder, box_size);
                    transaction.commit();
                    ProgresBar.setImageResource(R.drawable.input_module_barra_50);
                    InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_caja_master);
                    BTNprev.setVisibility(View.VISIBLE);

                    machine.presentState=1;
                    break;

                case 1:

                    Frag_McKee mckee = new Frag_McKee();
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_Holder,mckee);
                    transaction.commit();
                    InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_mckee);
                    BTNprev.setVisibility(View.VISIBLE);

                    machine.presentState=2;
                    break;

                case 2:

                    if (ignoreFrag_empaqRes == true) {
                        Frag_Pallet palletSize = new Frag_Pallet();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_Holder,palletSize);
                        transaction.commit();
                        ProgresBar.setImageResource(R.drawable.input_module_barra_75);
                        ProgresBar.setVisibility(View.VISIBLE);
                        InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_pallet);

                        machine.presentState=4;
                    }else {

                        Frag_EmpaquetadoResults maqueta = new Frag_EmpaquetadoResults();
                        //pass the MAchine object
                        Bundle bund = new Bundle();
                        bund.putParcelable(StateMachine.KEY_DATA, machine);
                        maqueta.setArguments(bund);

                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_Holder, maqueta);
                        transaction.commit();
                        ProgresBar.setVisibility(View.GONE);
                        InputBaseBackGround.setBackgroundResource(R.color.MaquetaBackgroundColor);
                        BTNprev.setVisibility(View.VISIBLE);

                        machine.presentState = 3;
                    }

                    break;

                case 3:

                    //dialog message
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(ItemInputBase.this);
                    builder1.setMessage(R.string.inputBase_continuar_Crear);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            R.string.inputBase_continuar,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    Frag_Pallet palletSize = new Frag_Pallet();
                                    transaction = getSupportFragmentManager().beginTransaction();
                                    transaction.replace(R.id.fragment_Holder,palletSize);
                                    transaction.commit();
                                    ProgresBar.setImageResource(R.drawable.input_module_barra_75);
                                    ProgresBar.setVisibility(View.VISIBLE);
                                    InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_pallet);

                                    machine.presentState=4;

                                }
                            });
                    builder1.setNegativeButton(
                            R.string.inputBase_crear,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    //create output activity
                                    //Intent intent = new Intent(ItemInputBase.this, ReportActivity.class);
                                    //Bundle bund = new Bundle();
                                    //bund.putParcelable("MachineData",machine);
                                    //intent.putExtras(bund);
                                    //startActivity(intent);

                                    PdfClass pdf = new PdfClass();
                                    pdf.createPDF(getApplicationContext(),machine);


                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();


                    break;

                case 4:



                    if(machine.PalleAlto==-1){
                        Toast.makeText(getApplicationContext(), R.string.inputBase_plzSelectOpt,
                                Toast.LENGTH_SHORT).show();
                    }else {

                        if(ignoreFrag_EntarimRes == true){
                            Frag_Container container = new Frag_Container();
                            transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.fragment_Holder, container);
                            transaction.commit();
                            ProgresBar.setImageResource(R.drawable.input_module_barra_100);
                            ProgresBar.setVisibility(View.VISIBLE);
                            InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_contenedor);
                            BTNprev.setVisibility(View.VISIBLE);

                            machine.presentState = 6;
                        }else {

                            Frag_EntarimadoResults results = new Frag_EntarimadoResults();
                            transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.fragment_Holder, results);
                            transaction.commit();
                            ProgresBar.setVisibility(View.GONE);
                            InputBaseBackGround.setBackgroundResource(R.color.MaquetaBackgroundColor);
                            BTNprev.setVisibility(View.VISIBLE);

                            machine.presentState = 5;
                        }

                    }


                    break;


                case 5:

                    Frag_Container container = new Frag_Container();
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_Holder, container);
                    transaction.commit();
                    ProgresBar.setImageResource(R.drawable.input_module_barra_100);
                    ProgresBar.setVisibility(View.VISIBLE);
                    InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_contenedor);

                    machine.presentState = 6;

                    break;

                case 6:

                    if(machine.ContainerAncho==-1){
                        Toast.makeText(getApplicationContext(), R.string.inputBase_plzSelectOpt, //TODO: error
                                Toast.LENGTH_SHORT).show();
                    }else{

                        if(ignoreFrag_ContainerRes== true){

                        }else {

                            Frag_ContenedorResutls resultsCont = new Frag_ContenedorResutls();
                            transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.fragment_Holder, resultsCont);
                            transaction.commit();
                            ProgresBar.setVisibility(View.GONE);
                            InputBaseBackGround.setBackgroundResource(R.color.MaquetaBackgroundColor);
                            BTNprev.setVisibility(View.VISIBLE);

                            machine.presentState = 7;
                        }
                    }

            }

                Log.i( "Min_state ",Integer.toString(machine.minState) );
                Log.i( "Pres_state ",Integer.toString(machine.presentState) );

            }
        });


        BTNprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            if(machine.presentState==0 && machine.minState<= machine.presentState-1){
                //this wold never do nothing, i just write it for better code understanding

            }else if(machine.presentState==1 && machine.minState<= machine.presentState-1){
                Frag_ItemSize item_size = new Frag_ItemSize();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder, item_size);
                transaction.commit();
                ProgresBar.setImageResource(R.drawable.input_module_barra);
                InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_caja);
                BTNprev.setVisibility(View.INVISIBLE);

                machine.presentState=0;

            }else if(machine.presentState==2 && machine.minState<= machine.presentState-1){
                Frag_BoxSize box_size = new Frag_BoxSize();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder, box_size);
                transaction.commit();
                InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_caja_master);

                if(machine.minState==machine.presentState-1){
                    BTNprev.setVisibility(View.INVISIBLE);
                }


                machine.presentState=1;

            }else if(machine.presentState==3 && machine.minState<= machine.presentState-1){
                Frag_McKee mckee = new Frag_McKee();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder,mckee);
                transaction.commit();
                InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_mckee);
                ProgresBar.setVisibility(View.VISIBLE);


                machine.presentState=2;

            }else if(machine.presentState==4 && machine.minState<= machine.presentState-1){

                if (ignoreFrag_empaqRes == true) {

                    Frag_McKee mckee = new Frag_McKee();
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_Holder,mckee);
                    transaction.commit();
                    InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_mckee);
                    BTNprev.setVisibility(View.VISIBLE);

                    machine.presentState=2;

                }else {

                    Frag_EmpaquetadoResults maqueta = new Frag_EmpaquetadoResults();
                    //pass the MAchine object
                    Bundle bund = new Bundle();
                    bund.putParcelable(StateMachine.KEY_DATA, machine);
                    maqueta.setArguments(bund);

                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_Holder, maqueta);
                    transaction.commit();
                    ProgresBar.setVisibility(View.GONE);
                    InputBaseBackGround.setBackgroundResource(R.color.MaquetaBackgroundColor);
                    BTNprev.setVisibility(View.VISIBLE);

                    machine.presentState = 3;
                }

            }else if(machine.presentState==5 && machine.minState<= machine.presentState-1){
                Frag_Pallet palletSize = new Frag_Pallet();
                //pass the MAchine object
                Bundle bund = new Bundle();
                bund.putParcelable(StateMachine.KEY_DATA,machine);
                palletSize.setArguments(bund);

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder,palletSize);
                transaction.commit();
                ProgresBar.setImageResource(R.drawable.input_module_barra_75);
                ProgresBar.setVisibility(View.VISIBLE);
                InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_pallet);

                if(machine.minState==machine.presentState-1){
                    BTNprev.setVisibility(View.INVISIBLE);
                }

                machine.presentState=4;

            }else if(machine.presentState==6 && machine.minState<= machine.presentState-1){
                if(ignoreFrag_EntarimRes){
                    Frag_Pallet palletSize = new Frag_Pallet();
                    //pass the MAchine object
                    Bundle bund = new Bundle();
                    bund.putParcelable(StateMachine.KEY_DATA,machine);
                    palletSize.setArguments(bund);

                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_Holder,palletSize);
                    transaction.commit();
                    ProgresBar.setImageResource(R.drawable.input_module_barra_75);
                    ProgresBar.setVisibility(View.VISIBLE);
                    InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_pallet);

                    machine.presentState=4;

                }else {
                    Frag_EntarimadoResults results = new Frag_EntarimadoResults();
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_Holder, results);
                    transaction.commit();
                    ProgresBar.setVisibility(View.GONE);
                    InputBaseBackGround.setBackgroundResource(R.color.MaquetaBackgroundColor);
                    BTNprev.setVisibility(View.VISIBLE);

                    machine.presentState = 5;
                }

            }else if(machine.presentState==7 && machine.minState<= machine.presentState-1){

                Frag_Container container = new Frag_Container();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder, container);
                transaction.commit();
                ProgresBar.setImageResource(R.drawable.input_module_barra_100);
                ProgresBar.setVisibility(View.VISIBLE);
                InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_contenedor);

                if(machine.minState==machine.presentState-1){
                    BTNprev.setVisibility(View.INVISIBLE);
                }

                machine.presentState = 6;


            }

            Log.i( "Min_state ",Integer.toString(machine.minState) );
            Log.i( "Pres_state ",Integer.toString(machine.presentState) );

            }
        });


    }// end onCreate

    @Override
    public void onBackPressed()
    {
        if(machine.presentState==machine.minState){
            this.finish();

        }else if(machine.presentState==1 && machine.minState<= machine.presentState-1){
            Frag_ItemSize item_size = new Frag_ItemSize();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_Holder, item_size);
            transaction.commit();
            ProgresBar.setImageResource(R.drawable.input_module_barra);
            InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_caja);
            BTNprev.setVisibility(View.INVISIBLE);

            machine.presentState=0;

        }else if(machine.presentState==2 && machine.minState<= machine.presentState-1){
            Frag_BoxSize box_size = new Frag_BoxSize();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_Holder, box_size);
            transaction.commit();
            InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_caja_master);

            if(machine.minState==machine.presentState-1){
                BTNprev.setVisibility(View.INVISIBLE);
            }


            machine.presentState=1;

        }else if(machine.presentState==3 && machine.minState<= machine.presentState-1){
            Frag_McKee mckee = new Frag_McKee();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_Holder,mckee);
            transaction.commit();
            InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_mckee);
            ProgresBar.setVisibility(View.VISIBLE);


            machine.presentState=2;

        }else if(machine.presentState==4 && machine.minState<= machine.presentState-1){
            if(ignoreFrag_empaqRes==true){

                Frag_McKee mckee = new Frag_McKee();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder,mckee);
                transaction.commit();
                InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_mckee);
                BTNprev.setVisibility(View.VISIBLE);

                machine.presentState=2;

            }else {

                Frag_EmpaquetadoResults maqueta = new Frag_EmpaquetadoResults();
                //pass the MAchine object
                Bundle bund = new Bundle();
                bund.putParcelable(StateMachine.KEY_DATA, machine);
                maqueta.setArguments(bund);

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder, maqueta);
                transaction.commit();
                ProgresBar.setVisibility(View.GONE);
                InputBaseBackGround.setBackgroundResource(R.color.MaquetaBackgroundColor);
                BTNprev.setVisibility(View.VISIBLE);

                machine.presentState = 3;
            }

        }else if(machine.presentState==5 && machine.minState<= machine.presentState-1){
            Frag_Pallet palletSize = new Frag_Pallet();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_Holder,palletSize);
            transaction.commit();
            ProgresBar.setImageResource(R.drawable.input_module_barra_75);
            ProgresBar.setVisibility(View.VISIBLE);
            InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_pallet);

            if(machine.minState==machine.presentState-1){
                BTNprev.setVisibility(View.INVISIBLE);
            }

            machine.presentState=4;

        }else if(machine.presentState==6 && machine.minState<= machine.presentState-1){

            if(ignoreFrag_EntarimRes){
                Frag_Pallet palletSize = new Frag_Pallet();
                //pass the MAchine object
                Bundle bund = new Bundle();
                bund.putParcelable(StateMachine.KEY_DATA,machine);
                palletSize.setArguments(bund);

                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder,palletSize);
                transaction.commit();
                ProgresBar.setImageResource(R.drawable.input_module_barra_75);
                ProgresBar.setVisibility(View.VISIBLE);
                InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_pallet);

                machine.presentState=4;
            }else {

                Frag_EntarimadoResults results = new Frag_EntarimadoResults();
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_Holder, results);
                transaction.commit();
                ProgresBar.setVisibility(View.GONE);
                InputBaseBackGround.setBackgroundResource(R.color.MaquetaBackgroundColor);
                BTNprev.setVisibility(View.VISIBLE);

                machine.presentState = 5;
            }

        }else if(machine.presentState==7 && machine.minState<= machine.presentState-1){

            Frag_Container container = new Frag_Container();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_Holder, container);
            transaction.commit();
            ProgresBar.setImageResource(R.drawable.input_module_barra_100);
            ProgresBar.setVisibility(View.VISIBLE);
            InputBaseBackGround.setBackgroundResource(R.drawable.input_module_fondo_contenedor);

            if(machine.minState==machine.presentState-1){
                BTNprev.setVisibility(View.INVISIBLE);
            }

            machine.presentState = 6;


        }

        Log.i( "Min_state ",Integer.toString(machine.minState) );
        Log.i( "Pres_state ",Integer.toString(machine.presentState) );

    } //OnBackPressed

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            this.finish();
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }


    // Interface Functions
    public void geDataSizes_Item(int quantity,int alto, int ancho, int Grueso, int peso,boolean orientation, boolean MetricSys ){
        machine.itemQuantity=quantity;

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
    public void getIsDoubleCartonBox(boolean isCartonDouble){
        machine.boxCartonisDouble = isCartonDouble;
        Log.d("is double", Boolean.toString(isCartonDouble) );
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


    public void geDataSizes_Mckee(int calibre, int largo, int ancho, int etc){
        machine.mckeeCalibre = calibre;
        machine.mckeeLargo = largo;
        machine.mckeeAncho = ancho;
        machine.mckeeEtc = etc;

        Log.d("McKee calibre:", String.valueOf(calibre));
    }


    public void geDatatype_Pallet(int Palto, int Plargo, int Pancho){
        machine.PalleAlto=Palto;
        machine.PalleLargo=Plargo;
        machine.PalleAncho=Pancho;

    }

    public void geDatatype_Container(int Cancho, int Clargo, int Calto, int Capacity, int Cpesomax){
        machine.ContainerAncho = Cancho;
        machine.ContainerLargo = Clargo;
        machine.ContainerAlto = Calto;
        machine.ContainerCap = Capacity;
        machine.ContainerMaxpeso = Cpesomax;

    }









}
