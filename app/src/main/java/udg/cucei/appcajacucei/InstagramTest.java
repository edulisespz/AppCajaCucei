package udg.cucei.appcajacucei;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

/**
 * Created by adolfo on 8/03/16.
 */
public class InstagramTest extends AppCompatActivity {
    private void onCreate(){
        String type = "image/*";
        String filename = "/myPhoto.jpg";
        String mediaPath = Environment.getExternalStorageDirectory() + filename;

        createInstagramIntent(type, mediaPath);

    }

    private void createInstagramIntent(String type, String mediaPath){

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
}


