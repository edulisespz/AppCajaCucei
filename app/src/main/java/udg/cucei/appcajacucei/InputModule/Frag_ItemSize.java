package udg.cucei.appcajacucei.InputModule;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import udg.cucei.appcajacucei.R;


public class Frag_ItemSize extends Fragment {

    boolean isVertical;
    ImageView btnOrientation;

    IntefaceData intf_DataCallBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

    public interface IntefaceData{
        public void geDataSizes(int alto, int ancho, int Grueso, int peso );
        public void getAlto(int alto);
    }


    @Override
    public  void onAttach(Activity activity){
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            intf_DataCallBack = (IntefaceData) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement IntefaceData");
        }
    }

    /*example for call the interface
    public void onListItemClick( int position) {
        // Send the event to the host activity
        intf_DataCallBack.getAlto(position);
    }
    */

    //http://www.learn-android-easily.com/2013/06/using-textwatcher-in-android.html
    //TODO: sent,get the values with TextWatcher
    /*
    public void afterTextChanged(Editable s)
                    {
                        public void getAlto( edittextAlto.toint() ); //something like that
                    }
     */

}
