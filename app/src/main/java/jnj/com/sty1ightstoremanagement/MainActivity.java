package jnj.com.sty1ightstoremanagement;

import android.content.Context;
import android.util.Log;


import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AppKeyPair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    final static private String APP_KEY = "3ypfwo7vtnfd7t5";
    final static private String APP_SECRET = "xhugpau3102bdlj";
    static private String FilePath;
    private DropboxAPI<AndroidAuthSession> mDBApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // test for github

        AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        AndroidAuthSession session = new AndroidAuthSession(appKeys);
        mDBApi = new DropboxAPI<AndroidAuthSession>(session);
        mDBApi.getSession().startOAuth2Authentication(MainActivity.this);

        Context context = MainActivity.this;
        FilePath = context.getFilesDir().getPath().toString() + "User.txt";
        Upload();
    }
    protected void onResume() {
        super.onResume();

        if (mDBApi.getSession().authenticationSuccessful()) {
            try {
                // Required to complete auth, sets the access token on the session
                mDBApi.getSession().finishAuthentication();

                String accessToken = mDBApi.getSession().getOAuth2AccessToken();
            } catch (IllegalStateException e) {
                Log.i("DbAuthLog", "Error authenticating", e);
            }
        }
    }

    void Upload() {

        try {
            File file = new File(FilePath);
            FileWriter writer = new FileWriter(file,true);
            writer.append("test hi\n\n");
            writer.flush();
            writer.close();
            FileInputStream inputStream = null;
            inputStream = new FileInputStream(file);
            DropboxAPI.Entry response = mDBApi.putFile("/User.txt", inputStream, file.length(), null, null);

            Log.i("DbExampleLog", "The uploaded file's rev is: " + response.rev);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Download() {
        try {
            File file = new File(FilePath);
            FileOutputStream outputStream = new FileOutputStream(file);
            DropboxAPI.DropboxFileInfo info = mDBApi.getFile(FilePath, null, outputStream, null);
            Log.i("DbExampleLog", "The file's rev is: " + info.getMetadata().rev);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
