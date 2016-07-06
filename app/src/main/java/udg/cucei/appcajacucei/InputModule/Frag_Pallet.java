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

import java.util.ArrayList;
import java.util.List;

import udg.cucei.appcajacucei.R;


public class Frag_Pallet extends Fragment {

    Spinner spn_palletSizes;

    public Frag_Pallet() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_pallet, container, false);

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
        //TODO: send the selected thing in a interface and show the results in this frag

        //test
        Log.d("selected pos",String.valueOf(P) );
    }

}


