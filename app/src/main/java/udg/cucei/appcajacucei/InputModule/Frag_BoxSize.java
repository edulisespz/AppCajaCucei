package udg.cucei.appcajacucei.InputModule;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import udg.cucei.appcajacucei.R;


public class Frag_BoxSize extends Fragment {

    IntefaceData_Box intf_DataCallBack_Box;

    EditText editAlto;
    EditText editAncho;
    EditText editGrosor;
    EditText editPeso;
    boolean isAmarre;
    ImageView btnAmarre;
    boolean isCartonDouble;
    ImageView btnCarton;

    public Frag_BoxSize() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_box_size, container, false);

        editAlto = (EditText)rootView.findViewById(R.id.box_editText_Alto);
        editAlto.addTextChangedListener(mTextEditorWatcher);

        editAncho= (EditText)rootView.findViewById(R.id.box_editText_Ancho);
        editAncho.addTextChangedListener(mTextEditorWatcher);

        editGrosor= (EditText)rootView.findViewById(R.id.box_editText_Grosor);
        editGrosor.addTextChangedListener(mTextEditorWatcher);

        editPeso= (EditText)rootView.findViewById(R.id.box_editText_Peso);
        editPeso.addTextChangedListener(mTextEditorWatcher);

        btnAmarre=(ImageView)rootView.findViewById(R.id.imageButtonAmarre);

        btnCarton=(ImageView)rootView.findViewById(R.id.imageButtonCarton);


        isAmarre= false;
        btnAmarre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isAmarre){
                    btnAmarre.setImageResource(R.drawable.input_module_caja_master_desamarre);
                    isAmarre= false;
                }else {
                    btnAmarre.setImageResource(R.drawable.input_module_caja_master_amarre);
                    isAmarre=true;
                }

                intf_DataCallBack_Box.getIsAmarred_Box(isAmarre);
            }
        });

        isCartonDouble= false;
        btnCarton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isCartonDouble){
                    btnCarton.setImageResource(R.drawable.input_module_caja_master_carton_simple);
                    isCartonDouble= false;
                }else {
                    btnCarton.setImageResource(R.drawable.input_module_caja_master_carton_doble);
                    isCartonDouble=true;
                }

                intf_DataCallBack_Box.getIsDoubleCartonBox(isCartonDouble);
            }
        });




        return rootView;
    }

    private final TextWatcher mTextEditorWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            int _alto= checkData( editAlto.getText().toString() );
            int _ancho= checkData( editAncho.getText().toString() );
            int _grueso=checkData( editGrosor.getText().toString() );
            int _peso= checkData( editPeso.getText().toString() );


            intf_DataCallBack_Box.geDataSizes_Box(_alto,_ancho,_grueso,_peso);
        }
    };

    public interface IntefaceData_Box{
        public void geDataSizes_Box(int alto, int ancho, int Grueso, int peso);
        public void getIsAmarred_Box(boolean isAmarred);
        public void getIsDoubleCartonBox(boolean isCartonDouble);
    }

    @Override
    public  void onAttach(Activity activity){
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            intf_DataCallBack_Box = (IntefaceData_Box) activity;
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
