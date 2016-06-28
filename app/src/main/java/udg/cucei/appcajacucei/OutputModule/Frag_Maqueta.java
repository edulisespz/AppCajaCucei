package udg.cucei.appcajacucei.OutputModule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import udg.cucei.appcajacucei.R;


public class Frag_Maqueta extends Fragment {


    public Frag_Maqueta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int x=0,y=0;
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frag__maqueta, container, false);


        //LinearLayOut Setup
        LinearLayout linearLayout=(LinearLayout) rootView.findViewById(R.id.LinLayTopView);

        LinearLayout linearLayout_line[]= new LinearLayout[4];
        ImageView imageView;
        while (x<4){
            linearLayout_line[x]= new LinearLayout(getActivity());
            linearLayout_line[x].setOrientation(LinearLayout.HORIZONTAL);

            //linearLayout_line[x].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            //        LinearLayout.LayoutParams.WRAP_CONTENT));

            y=0;
            while ( y < 3) {
                //ImageView Setup
                imageView = new ImageView(getActivity());

                //setting image resource
                imageView.setImageResource(R.drawable.frag_maque_latasuperior);

                //setting image position
                imageView.setLayoutParams(new LinearLayout.LayoutParams(75, 25) );
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);

                //adding view to layout
                linearLayout_line[x].addView(imageView);
                y++;
            }

            linearLayout.addView(linearLayout_line[x], new ViewGroup.LayoutParams(
                                                            ViewGroup.LayoutParams.WRAP_CONTENT,
                                                             ViewGroup.LayoutParams.WRAP_CONTENT)
                                                    );

            x++;
        }



        //linearLayout.setOrientation(LinearLayout.VERTICAL);
        //
        //linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
        //        LinearLayout.LayoutParams.MATCH_PARENT));










        return rootView;
    }

}
