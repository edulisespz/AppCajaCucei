package udg.cucei.appcajacucei.OutputModule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import udg.cucei.appcajacucei.InputModule.StateMachine;
import udg.cucei.appcajacucei.R;

public class ReportActivity extends AppCompatActivity {

    StateMachine machinedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Bundle bundl = this.getIntent().getExtras();
        if (bundl != null){
            machinedata = bundl.getParcelable("MachineData");
        }


        Log.d("datas item altu",machinedata.TestdataItemAlto() );
        Log.d("datas item orienta",machinedata.TestdataItemOrint() );


        //// TODO: here i will be something for the pdf or i dont know...

    }
}
