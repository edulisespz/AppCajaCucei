package udg.cucei.appcajacucei.OutputModule;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import udg.cucei.appcajacucei.InputModule.StateMachine;
import udg.cucei.appcajacucei.R;



public class ReportActivity extends AppCompatActivity {

    StateMachine machinedata;
    Button Btn_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        Bundle bundl = this.getIntent().getExtras();
        if (bundl != null){
            machinedata = bundl.getParcelable("MachineData");
        }

        Btn_create =(Button)findViewById(R.id.button_activity_report_create);
        Btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPDF();
            }
        });



        Log.d("datas item altu",machinedata.TestdataItemAlto() );
        Log.d("datas item orienta",machinedata.TestdataItemOrint() );


        //// TODO: here i will be something for the pdf or i dont know...

    }





    void createPDF(){

        File pdfFolder = new File(Environment.getExternalStorageDirectory(), "pdfdemo_itext");
        if (!pdfFolder.exists()) {
            pdfFolder.mkdir();
            Log.i("ReportActivity: ", "Pdf Directory created");
        }
        //Create time stamp
        Date date = new Date() ;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);

        File myFile = new File(pdfFolder + timeStamp + ".pdf");

        OutputStream output = null;

        try {
            output = new FileOutputStream(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //Step 1
        Document document = new Document(PageSize.LETTER);

        //Step 2
        try {
            PdfWriter.getInstance(document, output);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        //Step 3
        document.open();

        //Step 4 Add content
        try {
            document.add(new Paragraph("titulo") );
            document.add(new Paragraph("body") );
        } catch (DocumentException e) {
            e.printStackTrace();
        }


        //Step 5: Close the document
        document.close();
    }

























}//end of ReportActivity class
