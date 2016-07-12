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


public class Frag_Pallet extends Fragment {

    Inteface_Data_fragPallet intfPallet;

    Spinner spn_palletSizes;
    TextView lbl_pall_largo;
    TextView lbl_pall_Alto;
    TextView lbl_pall_Ancho;
    boolean flag_notingSelcted;

    public Frag_Pallet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_pallet, container, false);

        lbl_pall_Alto=(TextView)rootview.findViewById(R.id.textView_frg_pall_alto_lbl);
        lbl_pall_largo=(TextView)rootview.findViewById(R.id.textView_frg_pall_larg_lbl);
        lbl_pall_Ancho=(TextView)rootview.findViewById(R.id.textView_frg_pall_ancho_lbl);
        flag_notingSelcted =true;


        spn_palletSizes=(Spinner)rootview.findViewById(R.id.spinner_pallet_sizes);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.pallets_options, R.layout.spinner_pallete_item);

        spn_palletSizes.setAdapter(adapter);




        spn_palletSizes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                saveSelectedPallet(pos);
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
            intfPallet = (Inteface_Data_fragPallet) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Inteface_Data_fragPallet");
        }
    }

    public interface Inteface_Data_fragPallet{
        void geDatatype_Pallet(int Palto, int Plargo, int Pancho);

    }


    private void saveSelectedPallet(int P){

        switch (P){
            case 0:
                if(flag_notingSelcted) {
                    flag_notingSelcted = false;
                }
                else {//TARIMA
                    lbl_pall_Alto.setText("ALTO");
                    lbl_pall_largo.setText("LARGO");
                    lbl_pall_Ancho.setText("ANCHO");

                    intfPallet.geDatatype_Pallet(-1,-1,-1);

                    flag_notingSelcted = true;
                }

                break;
            case 1://EUR
                lbl_pall_Alto.setText("200mm");
                lbl_pall_largo.setText("200mm");
                lbl_pall_Ancho.setText("200mm");

                intfPallet.geDatatype_Pallet(200,200,200);
                break;
            case 2://EUR2
                lbl_pall_Alto.setText("300mm");
                lbl_pall_largo.setText("150mm");
                lbl_pall_Ancho.setText("100mm");
                intfPallet.geDatatype_Pallet(300,150,100);
                break;
            case 3://EUR6
                lbl_pall_Alto.setText("200mm");
                lbl_pall_largo.setText("150mm");
                lbl_pall_Ancho.setText("400mm");
                intfPallet.geDatatype_Pallet(200,150,400);
                break;
            case 4://North America
                lbl_pall_Alto.setText("200mm");
                lbl_pall_largo.setText("400mm");
                lbl_pall_Ancho.setText("150mm");
                intfPallet.geDatatype_Pallet(200,400,150);
                break;
            case 5://Australia
                lbl_pall_Alto.setText("200mm");
                lbl_pall_largo.setText("200mm");
                lbl_pall_Ancho.setText("200mm");
                intfPallet.geDatatype_Pallet(200,200,200);
                break;
            case 6://Asia
                lbl_pall_Alto.setText("400mm");
                lbl_pall_largo.setText("150mm");
                lbl_pall_Ancho.setText("200mm");
                intfPallet.geDatatype_Pallet(400,150,200);
                break;
        }
        if(P!=0){
            flag_notingSelcted = false;
        }



        //test
        Log.d("selected pos",String.valueOf(P) );
    }

}


