package udg.cucei.appcajacucei.PdfModule;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import udg.cucei.appcajacucei.R;

public class FileChooser extends AppCompatActivity {


    File file[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_chooser);

        final ListView listview = (ListView) findViewById(R.id.listViewFiles);

        final ArrayList<String> list = new ArrayList<String>();


        String path = Environment.getExternalStorageDirectory().toString()+"/pdfdemo_itext";
        Log.d("Files", "Path: " + path);
        File f = new File(path);
        file = f.listFiles();
        Log.d("Files", "Size: "+ file.length);

        if(file.length==0){
            Toast.makeText(getApplicationContext(), "No se encontro ningun archivo",
                    Toast.LENGTH_LONG).show();
        }

        for (int i=0; i < file.length; i++)
        {
            Log.d("Files", "FileName:" + file[i].getName());

            list.add(file[i].getName() );

        }



        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                R.layout.list_item_filechooser, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_SUBJECT,"subject");
                email.putExtra(Intent.EXTRA_TEXT, "text");//TODO: chage later
                Uri uri = Uri.fromFile(file[position]);
                email.putExtra(Intent.EXTRA_STREAM, uri);
                email.setType("message/rfc822");
                startActivity(email);
            }

        });
    }


    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }




}
