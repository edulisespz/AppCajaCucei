package udg.cucei.appcajacucei.InputModule;


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

import java.util.ArrayList;
import java.util.List;

import udg.cucei.appcajacucei.R;


public class Frag_Pallet extends Fragment {

    Spinner spn_palletSizes;
    TextView lbl_pall_largo;
    TextView lbl_pall_Alto;
    TextView lbl_pall_Ancho;
    boolean flag_shwbkgrnd;

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
        flag_shwbkgrnd=true;


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


    private void saveSelectedPallet(int P){


        //if(!flag_shwbkgrnd){
        //    spn_palletSizes.setBackgroundResource(0);
        //}
        switch (P){
            case 0:
                if(flag_shwbkgrnd) {
                    flag_shwbkgrnd = false;
                }
                else {
                    lbl_pall_Alto.setText("ALTO");
                    lbl_pall_largo.setText("LARGO");
                    lbl_pall_Ancho.setText("ANCHO");
                    //spn_palletSizes.setBackgroundResource(R.drawable.input_module_pallet_dropmenu);
                    flag_shwbkgrnd = true;
                }

                break;
            case 1:
                lbl_pall_Alto.setText("200mm");
                lbl_pall_largo.setText("200mm");
                lbl_pall_Ancho.setText("200mm");
                break;
            case 2:
                lbl_pall_Alto.setText("300mm");
                lbl_pall_largo.setText("150mm");
                lbl_pall_Ancho.setText("100mm");
                break;
            case 3:
                lbl_pall_Alto.setText("200mm");
                lbl_pall_largo.setText("150mm");
                lbl_pall_Ancho.setText("400mm");
                break;
            case 4:
                lbl_pall_Alto.setText("200mm");
                lbl_pall_largo.setText("400mm");
                lbl_pall_Ancho.setText("150mm");
                break;
            case 5:
                lbl_pall_Alto.setText("200mm");
                lbl_pall_largo.setText("200mm");
                lbl_pall_Ancho.setText("200mm");
                break;
            case 6:
                lbl_pall_Alto.setText("400mm");
                lbl_pall_largo.setText("150mm");
                lbl_pall_Ancho.setText("200mm");
                break;
        }
        if(P!=0){
            //spn_palletSizes.setBackgroundResource(0);
            flag_shwbkgrnd = false;
        }

        //TODO: send the selected thing in a interface

        //test
        Log.d("selected pos",String.valueOf(P) );
    }

}


