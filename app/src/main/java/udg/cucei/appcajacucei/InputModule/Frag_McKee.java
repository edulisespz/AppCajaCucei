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

import udg.cucei.appcajacucei.R;


public class Frag_McKee extends Fragment {

    Inteface_Data_McKee intMcKeeData;

    EditText editCalibre;
    EditText editLargo;
    EditText editAncho;
    EditText editEtc;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frag__mc_kee, container, false);

        editCalibre = (EditText)rootView.findViewById(R.id.McKee_edit_calibre);
        editCalibre.addTextChangedListener(mTextEditorWatcher);

        editLargo = (EditText)rootView.findViewById(R.id.McKee_edit_largo);
        editLargo.addTextChangedListener(mTextEditorWatcher);

        editAncho = (EditText)rootView.findViewById(R.id.McKee_edit_ancho);
        editAncho.addTextChangedListener(mTextEditorWatcher);

        editEtc = (EditText)rootView.findViewById(R.id.McKee_edit_etc);
        editEtc.addTextChangedListener(mTextEditorWatcher);





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

            int _calibre = checkData( editCalibre.getText().toString() );
            int _largo = checkData( editLargo.getText().toString() );
            int _ancho =checkData( editAncho.getText().toString() );
            int _etc = checkData( editEtc.getText().toString() );

            intMcKeeData.geDataSizes_Mckee( _calibre, _largo, _ancho, _etc );

        }
    };

    public interface Inteface_Data_McKee{
        void geDataSizes_Mckee(int calibre, int largo, int ancho, int etc);

    }

    @Override
    public  void onAttach(Activity activity){
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            intMcKeeData = (Inteface_Data_McKee) activity;
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
