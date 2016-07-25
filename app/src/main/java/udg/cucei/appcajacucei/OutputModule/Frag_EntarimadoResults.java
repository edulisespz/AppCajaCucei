package udg.cucei.appcajacucei.OutputModule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import udg.cucei.appcajacucei.R;


public class Frag_EntarimadoResults extends Fragment {


    public Frag_EntarimadoResults() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_entarimado_results, container, false);




        return rootview;
    }

}
