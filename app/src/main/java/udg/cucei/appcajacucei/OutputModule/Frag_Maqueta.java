package udg.cucei.appcajacucei.OutputModule;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

import udg.cucei.appcajacucei.R;


public class Frag_Maqueta extends Fragment {

    int layTop_h;
    int layTop_w;

    public Frag_Maqueta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frag__maqueta, container, false);


        //LinearLayOut Setup
        final LinearLayout linearLayout=(LinearLayout) rootView.findViewById(R.id.LinLayTopView);

        ViewTreeObserver observer = linearLayout.getViewTreeObserver();
            observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    layTop_h=linearLayout.getHeight();
                    layTop_w=linearLayout.getWidth();
                    Log.d("params","H= "+Integer.toString(layTop_h) +" W= "+Integer.toString(layTop_w)  );

                    setNumberOfItemsOnTOPLayout(linearLayout, 65, 22);// CORE

                    linearLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                }
            });

        //setNumberOfItemsOnTOPLayout(linearLayout, 50, 50);




        return rootView;
    }



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
                imageView = new ImageView(getActivity());

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
