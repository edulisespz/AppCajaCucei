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


    ImageView btnOrientation;

    EditText editAlto;
    EditText editAncho;
    EditText editGrosor;
    EditText editPeso;
    boolean  isVertical;

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

        editGrosor= (EditText)rootView.findViewById(R.id.item_editText_Grosor);
        editGrosor.addTextChangedListener(mTextEditorWatcher);

        editPeso= (EditText)rootView.findViewById(R.id.item_editText_Peso);
        editPeso.addTextChangedListener(mTextEditorWatcher);







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
            int item_grueso=checkData( editGrosor.getText().toString() );
            int item_peso= checkData( editPeso.getText().toString() );


            intf_DataCallBack.geDataSizes_Item(item_alto, item_ancho, item_grueso, item_peso, isVertical);
        }
    };

    public interface IntefaceData{
        public void geDataSizes_Item(int alto, int ancho, int Grueso, int peso,boolean orientation );
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


    private int checkData(String strVal){
        if( strVal.equals("") ){//fuck you Java, in C# this is the other way around strinf1==strin2
            return -1;
        }else{
            return Integer.parseInt(strVal);
        }
    }



}
