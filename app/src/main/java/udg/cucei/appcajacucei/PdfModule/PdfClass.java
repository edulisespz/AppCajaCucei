package udg.cucei.appcajacucei.PdfModule;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Edgar Ulises on 25/07/2016.
 */
public class PdfClass {



    public void createPDF(Context context){

        try {

            File pdfFolder = new File(Environment.getExternalStorageDirectory(), "pdfdemo_itext");

            pdfFolder.mkdir();
            Log.i("ReportActivity: ", "Pdf Directory created");
            //Create time stamp
            Date date = new Date();
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);
            File myFile = new File(pdfFolder, timeStamp + ".pdf");

            OutputStream output = new FileOutputStream(myFile);

            //Step 1
            Document document = new Document(PageSize.LETTER);
            //Step 2
            PdfWriter.getInstance(document, output);
            //Step 3
            document.open();
            //Step 4 Add content
            document.add(new Paragraph("titulo"));
            document.add(new Paragraph("body"));

            //Step 5: Close the document
            document.close();
            output.close();

            Toast.makeText(context, "File created",
                    Toast.LENGTH_SHORT).show();
        } catch (DocumentException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error in document",
                    Toast.LENGTH_SHORT).show();
            Log.e("Document", "error");
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Error creating file",
                    Toast.LENGTH_SHORT).show();
            Log.e("outputstream", "error");
        }
    }
}
