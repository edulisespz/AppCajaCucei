package udg.cucei.appcajacucei.InputModule;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import udg.cucei.appcajacucei.R;

public class Frag_Container extends Fragment {

    Inteface_Data_fragContainer intfContainer;

    Spinner spn_containerSizes;
    TextView lbl_cont_Ancho;
    TextView lbl_cont_largo;
    TextView lbl_cont_Alto;
    TextView lbl_cont_Cap;
    TextView lbl_cont_Peso;
    private boolean flag_notingSelcted;

    public Frag_Container() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_container, container, false);

        lbl_cont_Ancho =(TextView)rootview.findViewById(R.id.textView_frg_cont_ancho_lbl);
        lbl_cont_largo =(TextView)rootview.findViewById(R.id.textView_frg_cont_largo_lbl);
        lbl_cont_Alto =(TextView)rootview.findViewById(R.id.textView_frg_cont_alto_lbl);
        lbl_cont_Cap =(TextView)rootview.findViewById(R.id.textView_frg_cont_capacidad_lbl);
        lbl_cont_Peso =(TextView)rootview.findViewById(R.id.textView_frg_cont_pesomax_lbl);
        flag_notingSelcted =true;


        spn_containerSizes =(Spinner)rootview.findViewById(R.id.spinner_container_sizes);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.container_options, R.layout.spinner_pallete_item);// the item its the same as pallet for the font size

        spn_containerSizes.setAdapter(adapter);

        spn_containerSizes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                saveSelectedContainer(pos);
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        return rootview;
    }


    @Override
    public  void onAttach(Activity activity){
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            intfContainer = (Inteface_Data_fragContainer) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Inteface_Data_Container");
        }
    }

    public interface Inteface_Data_fragContainer{
        void geDatatype_Container(int Cancho, int Clargo, int Calto, int Capacity, int Cpesomax);
    }

    private void saveSelectedContainer(int P){

        switch (P){
            case 0:
                if(flag_notingSelcted) {
                    flag_notingSelcted = false;
                }
                else {//TARIMA
                    lbl_cont_Alto.setText("ANCHO");
                    lbl_cont_largo.setText("LARGO");
                    lbl_cont_Ancho.setText("ALTO");
                    lbl_cont_Cap.setText("CAPACIDAD");
                    lbl_cont_Peso.setText("PESO MAX");


                    intfContainer.geDatatype_Container(-1,-1,-1,-1,-1);

                    flag_notingSelcted = true;
                }

                break;
            case 1://EUR
                lbl_cont_Alto.setText("200mm");
                lbl_cont_largo.setText("200mm");
                lbl_cont_Ancho.setText("200mm");

                lbl_cont_Cap.setText("100");
                lbl_cont_Peso.setText("199");

                intfContainer.geDatatype_Container(200,200,200,100,199);
                break;
            case 2://EUR2
                lbl_cont_Alto.setText("300mm");
                lbl_cont_largo.setText("150mm");
                lbl_cont_Ancho.setText("100mm");

                lbl_cont_Cap.setText("100");
                lbl_cont_Peso.setText("199");
                intfContainer.geDatatype_Container(300,150,100,100,199);
                break;
            case 3://EUR6
                lbl_cont_Alto.setText("200mm");
                lbl_cont_largo.setText("150mm");
                lbl_cont_Ancho.setText("400mm");

                lbl_cont_Cap.setText("100");
                lbl_cont_Peso.setText("199");
                intfContainer.geDatatype_Container(200,150,400,100,199);
                break;
            case 4://North America
                lbl_cont_Alto.setText("200mm");
                lbl_cont_largo.setText("400mm");
                lbl_cont_Ancho.setText("150mm");

                lbl_cont_Cap.setText("100");
                lbl_cont_Peso.setText("199");
                intfContainer.geDatatype_Container(200,400,150,100,199);
                break;
            case 5://Australia
                lbl_cont_Alto.setText("200mm");
                lbl_cont_largo.setText("200mm");
                lbl_cont_Ancho.setText("200mm");

                lbl_cont_Cap.setText("100");
                lbl_cont_Peso.setText("199");
                intfContainer.geDatatype_Container(200,200,200,100,199);
                break;
            case 6://Asia
                lbl_cont_Alto.setText("400mm");
                lbl_cont_largo.setText("150mm");
                lbl_cont_Ancho.setText("200mm");

                lbl_cont_Cap.setText("100");
                lbl_cont_Peso.setText("199");
                intfContainer.geDatatype_Container(400,150,200,100,199);
                break;
        }
        if(P!=0){
            flag_notingSelcted = false;
        }



        //test
        Log.d("selected pos",String.valueOf(P) );
    }



}
