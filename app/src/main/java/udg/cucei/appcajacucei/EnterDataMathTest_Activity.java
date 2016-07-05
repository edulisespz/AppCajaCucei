package udg.cucei.appcajacucei;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

import udg.cucei.appcajacucei.Calculations.ListStorage;

public class EnterDataMathTest_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data_math_test_);

        Button buttonTest = (Button) findViewById(R.id.btn_algoritmTest);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListStorage box = new ListStorage();
                int result= box.StorageKind(10,5,10,100,15,10);

                Log.d("result", String.valueOf(result));

            }
        });

        // TODO: remove after fixing the algoritm
        buttonTest.setAlpha(.5f);
        buttonTest.setClickable(false);


    }
}
