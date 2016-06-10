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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;


import udg.cucei.appcajacucei.R;


public class Frag_ItemSize extends Fragment implements AdapterView.OnItemSelectedListener {


    ImageView btnOrientation;

    EditText editAlto;
    EditText editAncho;
    EditText editGrosor;
    EditText editPeso;
    boolean  isVertical;

    Spinner mySpinner;
    IntefaceData intf_DataCallBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_size, container, false);

        btnOrientation = (ImageView) rootView.findViewById(R.id.imageViewOrientation);
        mySpinner=(Spinner)rootView.findViewById(R.id.spinner);
        mySpinner.setAdapter(new MySpinnerAdapter() );
        mySpinner.setOnItemClickListener(this);

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



    //things for the spiner---------------------------
    @Override
    public void onItemSelected(AdapterView<?> parent,
                               View view, int position, long id) {
        Toast.makeText(this, "Selected: "
                + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
//        nothing selected
    }

    private static class ViewHolder {
        ImageView imageViewEmoticon;
    }

    //    our custom list adapter
    private class MySpinnerAdapter extends BaseAdapter {

        public int getCount() {
            return emoticons.length;
        }

        @Override
        public Integer getItem(int position) {
            return emoticons[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            ViewHolder emoticonViewHolder;
//            do we have a view
            if (convertView == null) {
//              we don't have a view so create one by inflating the layout
                itemView = getLayoutInflater()
                        .inflate(R.layout.spinner_row, parent, false);

                emoticonViewHolder = new ViewHolder();
                emoticonViewHolder.imageViewEmoticon
                        = (ImageView) itemView.findViewById(R.id.spinnerImage);
//              set the tag for this view to the current image view holder
                itemView.setTag(emoticonViewHolder);

            } else {
//              we have a view so get the tagged view
                emoticonViewHolder = (ViewHolder) itemView.getTag();
            }

//          display the current  image
            emoticonViewHolder.imageViewEmoticon
                    .setImageDrawable(getResources()
                            .getDrawable(emoticons[position]));

            return itemView;
        }
    }



}
