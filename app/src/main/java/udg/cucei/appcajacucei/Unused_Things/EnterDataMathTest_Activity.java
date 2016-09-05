package udg.cucei.appcajacucei.Unused_Things;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

import udg.cucei.appcajacucei.Calculations.ListStorage;
import udg.cucei.appcajacucei.R;

public class EnterDataMathTest_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data_math_test_);

        final Button buttonTest = (Button) findViewById(R.id.btn_algoritmTest);

        assert buttonTest != null;// dammint compiler askink for verification
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ListStorage box = new ListStorage(-1);//constructor with number of elemnts
                //int result = box.StorageKind(3, 5, 1, 6, 8, 1);
                //int numofAreas = box.size();
                //Log.d("num of layers", String.valueOf(numofAreas));
                //
                //int Numofelemts = box.get(0).amount;
                //
                //Log.d("result", String.valueOf(result));
                //Log.d("num of elemnts", String.valueOf(Numofelemts));
                //
                //// TODO: remove after fixing the algoritm
                //buttonTest.setAlpha(.5f);
                //buttonTest.setClickable(false);

                int variablequeagregue = 0;
                variablequeagregue++;

            }
        });


    }
}


