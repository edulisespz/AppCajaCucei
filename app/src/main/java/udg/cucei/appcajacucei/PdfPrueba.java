package udg.cucei.appcajacucei;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfDocument.Page;
import android.graphics.pdf.PdfDocument.PageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.Resolution;
import android.print.pdf.PrintedPdfDocument;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Edgar Ulises on 14/03/2016.
 */
public class PdfPrueba extends Activity implements Runnable {

        private Intent mShareIntent;

        private OutputStream os;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pdf_prueba_layout);
        }

        /** PDF Gen should run in own thread to not slow the GUI */
        public void makeAndSharePDF(View buttonSource) {
            new Thread(this).start();
        }

        public void run() {

            // Create a shiny new (but blank) PDF document in memory
            // We want it to optionally be printable, so add PrintAttributes
            // and use a PrintedPdfDocument. Simpler: new PdfDocument().
            PrintAttributes printAttrs = new PrintAttributes.Builder().
                    setColorMode(PrintAttributes.COLOR_MODE_COLOR).
                    setMediaSize(PrintAttributes.MediaSize.NA_LETTER).
                    setResolution(new Resolution("zooey", PRINT_SERVICE, 300, 300)).
                    setMinMargins(Margins.NO_MARGINS).
                    build();
            PdfDocument document = new PrintedPdfDocument(this, printAttrs);

            // crate a page description
            PageInfo pageInfo = new PageInfo.Builder(300, 300, 1).create();

            // create a new page from the PageInfo
            Page page = document.startPage(pageInfo);

            // repaint the user's text into the page
            View content = findViewById(R.id.textArea);
            content.draw(page.getCanvas());

            // do final processing of the page
            document.finishPage(page);

            // Here you could add more pages in a longer doc app, but you'd have
            // to handle page-breaking yourself in e.g., write your own word processor...

            // Now write the PDF document to a file; it actually needs to be a file
            // since the Share mechanism can't accept a byte[]. though it can
            // accept a String/CharSequence. Meh.
            try {
                File pdfDirPath = new File(Environment.getExternalStorageDirectory(), "pdfs");

                boolean a= pdfDirPath.mkdirs();

                Log.d("mkdirs",String.valueOf(a));

                Log.d("path: ", pdfDirPath.toString());

                File file = new File(pdfDirPath, "pdfsend.pdf");
                //Uri contentUri = FileProvider.getUriForFile(this, "udg.cucei.fileprovider", file);


                Log.d("Exist: ", String.valueOf(file.exists()) );

                os = new FileOutputStream(file);
                document.writeTo(os);
                document.close();
                os.close();

                // TODO: PDF share thing
                //shareDocument(contentUri);

                runOnUiThread(new Runnable() {
                    public void run() {

                        Toast.makeText(getApplicationContext(), "File Created",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            } catch (IOException e) {
                throw new RuntimeException("Error generating file", e);
            }
        }

        private void shareDocument(Uri uri) {
            //TODO: pdf share thing2

            mShareIntent = new Intent();
            mShareIntent.setAction(Intent.ACTION_SEND);
            mShareIntent.setType("application/pdf");
            // Assuming it may go via eMail:
            //mShareIntent.putExtra(Intent.EXTRA_SUBJECT, "Here is a PDF from PdfSend");
            // Attach the PDf as a Uri, since Android can't take it as bytes yet.
            //mShareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(mShareIntent);
            return;
        }


    }