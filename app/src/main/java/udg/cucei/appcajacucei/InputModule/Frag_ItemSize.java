package udg.cucei.appcajacucei.InputModule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import udg.cucei.appcajacucei.R;


public class Frag_ItemSize extends Fragment {

    boolean isVertical;
    ImageView btnOrientation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_item_size, container, false);

        btnOrientation = (ImageView) rootView.findViewById(R.id.imageViewOrientation);

        isVertical= true;

        btnOrientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isVertical){
                    btnOrientation.setImageResource(R.drawable.frag_item_boton_horizontal);
                    isVertical= false;
                }else {
                    btnOrientation.setImageResource(R.drawable.frag_item_boton_vertical);
                    isVertical=true;
                }

            }
        });


        return rootView;


    }

}
