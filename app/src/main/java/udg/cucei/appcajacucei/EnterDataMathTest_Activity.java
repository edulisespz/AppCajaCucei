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
                int result= box.StorageKind(100,100,100,1000,1000,1000,1);

                Log.d("result", String.valueOf(result));

            }
        });

        Button buttonLang = (Button) findViewById(R.id.button_lang);

        buttonLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("es");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                Toast.makeText(getBaseContext(), "lenguaje actualizado",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
