package udg.cucei.appcajacucei.InputModule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import udg.cucei.appcajacucei.R;


public class Frag_BoxSize extends Fragment {


    public Frag_BoxSize() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_box_size, container, false);
    }

}
