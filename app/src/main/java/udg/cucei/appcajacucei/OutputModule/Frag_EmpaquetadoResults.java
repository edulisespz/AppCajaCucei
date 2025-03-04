package udg.cucei.appcajacucei.OutputModule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import udg.cucei.appcajacucei.Calculations.ListStorage;
import udg.cucei.appcajacucei.Calculations.Shape;
import udg.cucei.appcajacucei.Calculations.Storage;
import udg.cucei.appcajacucei.InputModule.StateMachine;
import udg.cucei.appcajacucei.R;


public class Frag_EmpaquetadoResults extends Fragment {

    int layTop_h;
    int layTop_w;

    StateMachine objMachime;

    TextView lbl_numitems;
    TextView lbl_volpack;
    TextView lbl_numpacks;

    public Frag_EmpaquetadoResults() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_empaquetado_results, container, false);


        //get the ObjectData
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            objMachime = bundle.getParcelable(StateMachine.KEY_DATA);
        }

        lbl_numitems = (TextView) rootView.findViewById(R.id.lbl_numitems); //TODO: LO DEMAS
        lbl_volpack = (TextView) rootView.findViewById(R.id.lbl_volpack);
        lbl_numpacks = (TextView) rootView.findViewById(R.id.lbl_numPacks);

        assert objMachime != null:"Shall never be Null, this is the obj that passes between activities/fragments";
        Shape element = objMachime.getItemShape();
        Shape box= objMachime.getBoxShape();
        int elements2store= objMachime.itemQuantity;

        //int elements2store= objMachime.getnumberOfitemsinBoxes(element, box);

        //int elements2store= 500 / objMachime.getnumberOfitemsinBoxes(element, box); //500 numItems

        //
        //
        if( objMachime.itemItsBigger(element, box)==true ){
            Toast.makeText(getActivity(), R.string.itemMasGrandequeCaja,
                    Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }
        //
        //
        

        if(elements2store == -1){
            Log.e("no number of items","Quiting activity");
            Toast.makeText(getActivity(), R.string.cantidadMissing,
                    Toast.LENGTH_SHORT).show();

            //getActivity().finish(); //TODO: add later
        }else{
            //int num_ofarrangements=0;
            //
            //ListStorage l = new ListStorage(element, box, elements2store);
            //
            ////if (l.storageKind() == 1)
            //{
            //    Log.i("espacio suficiente: ","");
            //    for (Storage s : l)
            //    {
            //        Log.i("","    acomoda " + s.getAmount() + " objetos de la forma x=" + s.getX()
            //                + " y=" + s.getY() + " z=" + s.getZ() );
            //        num_ofarrangements++;
            //    }
            //
            //}
            //else
            //{
            //    int e = (elements2store - 1) / l.getTotalAmount() + 1;
            //    Log.i("","espacio insuficiente, necesitas " + e + " cajas"  );
            //}
            //Log.i("",l.getTotalAmount() + " elementos acomodados" );


            //lbl_numitems.setText( String.format("%d",l.getTotalAmount() ) );
            lbl_numitems.setText( String.format("%d",objMachime.getnumberOfitemsinBoxes(element, box) ) );

            //this line seems triki, i put the locale canada to make 2.66 instead of 2,66
            lbl_volpack.setText( String.format(Locale.CANADA , "%1$.2f", objMachime.getVolPorcentage(element,box) ) + " %" );

            lbl_numpacks.setText( Integer.toString( objMachime.getnumberOfContainers(element,box, elements2store) ) );


        }







        //foo_procesData();





        ////LinearLayOut Setup
        //final LinearLayout linearLayout=(LinearLayout) rootView.findViewById(R.id.LinLayTopView);
        //
        //ViewTreeObserver observer = linearLayout.getViewTreeObserver();
        //    observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        //        @Override
        //        public void onGlobalLayout() {
        //            layTop_h=linearLayout.getHeight();
        //            layTop_w=linearLayout.getWidth();
        //            Log.d("params","H= "+Integer.toString(layTop_h) +" W= "+Integer.toString(layTop_w)  );
        //
        //
        //
        //            setNumberOfItemsOnTOPLayout(linearLayout, 25,75);// CORE
        //
        //            linearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        //
        //        }
        //    });
        //
        ////setNumberOfItemsOnTOPLayout(linearLayout, 50, 50);




        return rootView;
    }

    private void foo_procesData() {
        Shape element = new Shape(3,5,1);
        Shape box=new Shape(8,6,1);
        int elements2store= 3;

        ListStorage l = new ListStorage(element, box, elements2store);

        if (l.storageKind() == 1)
        {
            Log.i("espacio suficiente: ","");
            for (Storage s : l)
            {
                Log.i("","    acomoda " + s.getAmount() + " objetos de la forma x=" + s.getX()
                        + " y=" + s.getY() + " z=" + s.getZ() );
            }
        }
        else
        {
            int e = (elements2store - 1) / l.getTotalAmount() + 1;
            Log.i("","espacio insuficiente, necesitas " + e + " cajas"  );
        }
        Log.i("",l.getTotalAmount() + " elementos acomodados" );
    }


    //this function was for the dinamic layouts, but i dont find it practical
    private void setNumberOfItemsOnTOPLayout(LinearLayout linearLayout, int item_H,int item_W){

        int rows=1,columns=1;

        LinearLayout linearLayout_line;
        ImageView imageView;
        while (rows*item_H < layTop_h){//adds rows
            linearLayout_line= new LinearLayout(getActivity());
            linearLayout_line.setOrientation(LinearLayout.HORIZONTAL);

            columns=1;
            while ( columns*item_W < layTop_w) {//adds columns

                //ImageView Setup
                imageView = new ImageView(getActivity() );

                //setting image resource
                imageView.setImageResource(R.drawable.frag_maque_latasuperior);

                //setting image position
                imageView.setLayoutParams(new LinearLayout.LayoutParams(item_W, item_H) );
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                //adding view to layout
                linearLayout_line.addView(imageView);
                columns++;
            }

            linearLayout.addView(linearLayout_line, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)
            );

            rows++;
        }
        Log.d("column&Rows","C= "+Integer.toString(columns-1) +" R= "+Integer.toString(rows-1)  );

    }

}
