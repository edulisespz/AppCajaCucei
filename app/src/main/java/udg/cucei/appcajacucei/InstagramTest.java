package udg.cucei.appcajacucei;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by adolfo on 8/03/16.
 */
public class InstagramTest extends Activity implements Runnable {

    String type = "image/*";
    String filename = "/myPhoto.jpg";
    String mediaPath = Environment.getExternalStorageDirectory() + filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instagram_test_layout);

        Button btnimagen = (Button) findViewById(R.id.btnimagen);
        Button btnshareinstagram = (Button) findViewById(R.id.btnshareinstagram);

        btnimagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String picLocation = getIntent().getStringExtra("PICTURE_LOCATION");

                // Instantiate the ImageView object:
                ImageView imageViewer = (ImageView) findViewById(R.id.imageView);

                // Convert the Uri string into a usable Uri:
                Uri temp = Uri.parse(picLocation);
                imageViewer.setImageURI(temp);
            }
        });
        btnshareinstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(InstagramTest.this).start();
            }
        });
    }

    private void createInstagramIntent(String type, String mediaPath) {

        // Create the new Intent using the 'Send' action.
        Intent share = new Intent(Intent.ACTION_SEND);

        // Set the MIME type
        share.setType(type);

        // Create the URI from the media
        File media = new File(mediaPath);
        Uri uri = Uri.fromFile(media);

        // Add the URI to the Intent.
        share.putExtra(Intent.EXTRA_STREAM, uri);

        // Broadcast the Intent.
        startActivity(Intent.createChooser(share, "Share to"));
    }

    @Override
    public void run() {
        createInstagramIntent(type, mediaPath);
    }
}
