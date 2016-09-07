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

                //deleted some things




            }
        });


    }
}


