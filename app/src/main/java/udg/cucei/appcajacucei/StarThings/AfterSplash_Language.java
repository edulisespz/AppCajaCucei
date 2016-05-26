package udg.cucei.appcajacucei.StarThings;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import udg.cucei.appcajacucei.R;

public class AfterSplash_Language extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/SourceSansPro-Light.otf"); // font from assets: "assets/fonts/Roboto-Regular.ttf
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_splash__language);

        TextView LblEnglish = (TextView) findViewById(R.id.textViewEnglish);
        LblEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                Toast.makeText(getBaseContext(), "Welcome",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AfterSplash_Language.this, MainActivity.class);
                startActivity(intent);
            }
        });

        TextView LblEspanish = (TextView) findViewById(R.id.textViewEspanol);
        LblEspanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Locale locale = new Locale("es");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());

                Toast.makeText(getBaseContext(), "Bienvenido",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AfterSplash_Language.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
