package udg.cucei.appcajacucei.InputModule;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;


import udg.cucei.appcajacucei.R;


public class Frag_ItemSize extends Fragment {

    boolean isVertical;
    ImageView btnOrientation;

    EditText editAlto;
    EditText editAncho;

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

        editAlto = (EditText)rootView.findViewById(R.id.item_editText_Alto);
        editAlto.addTextChangedListener(mTextEditorWatcher);

        editAncho= (EditText)rootView.findViewById(R.id.item_editText_Ancho);
        editAncho.addTextChangedListener(mTextEditorWatcher);







        return rootView;
    }


    private final TextWatcher  mTextEditorWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            int item_alto= checkData( editAlto.getText().toString() );
            int item_ancho= checkData( editAncho.getText().toString() );


            intf_DataCallBack.geDataSizes(item_alto,item_ancho,0,0);//TODO: set the rest of values
        }
    };

    public interface IntefaceData{
        public void geDataSizes(int alto, int ancho, int Grueso, int peso );
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


    private int checkData(String strVal){
        if( strVal.equals("") ){//fuck you Java, in C# this is the other way around strinf1==strin2
            return -1;
        }else{
            return Integer.parseInt(strVal);
        }
    }



}
