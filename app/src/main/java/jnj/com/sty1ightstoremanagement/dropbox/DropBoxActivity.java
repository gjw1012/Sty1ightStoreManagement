package jnj.com.sty1ightstoremanagement.dropbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AppKeyPair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

import jnj.com.sty1ightstoremanagement.R;
import jnj.com.sty1ightstoremanagement.account.LoginActivity;

/**
 * Created by SJW on 2017-05-10.
 */

public class DropBoxActivity extends AppCompatActivity implements View.OnClickListener {
    private Button gotoLoginButton;

    // for DropBox
    final static private String APP_KEY = "41y9qa6th3mbvyi";
    final static private String APP_SECRET = "re4sagp55ljt1vx";
    static private String FilePath;
    private DropboxAPI<AndroidAuthSession> mDBApi;

    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropbox);

        mContext = this;

        gotoLoginButton = (Button) findViewById(R.id.button_goto_login);
        gotoLoginButton.setOnClickListener(this);

        AuthorizeDropBox();
    }

    private void AuthorizeDropBox() {
        AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        AndroidAuthSession session = new AndroidAuthSession(appKeys);
        mDBApi = new DropboxAPI<>(session);
        mDBApi.getSession().startOAuth2Authentication(DropBoxActivity.this);
    }

    protected void onResume() {
        super.onResume();

        if (mDBApi.getSession().authenticationSuccessful()) {
            try {
                // Required to complete auth, sets the access token on the session
                mDBApi.getSession().finishAuthentication();

                String accessToken = mDBApi.getSession().getOAuth2AccessToken();
            } catch (IllegalStateException e) {
                Log.i("jwoong.song", "Error authenticating", e);
            }
        }
    }
/*
    public void upload() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String filePath = DropBoxActivity.this.getFilesDir().getPath().toString() + "/AccountData.txt";
                    File file = new File(filePath);
                    FileWriter writer = new FileWriter(file, false);
                    writer.append("test hi1\n\n");
                    writer.flush();
                    writer.close();
                    FileInputStream inputStream;
                    inputStream = new FileInputStream(file);
                    //DropboxAPI.Entry response = mDBApi.putFile("/User.txt", inputStream, file.length(), null, null);
                    DropboxAPI.Entry response = mDBApi.putFileOverwrite("/User.txt", inputStream, file.length(), null);

                    Log.i("jwoong.song", "The uploaded file's rev is: " + response.rev);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void download() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String filePath = DropBoxActivity.this.getFilesDir().getPath().toString() + "/AccountData.txt";
                    File file = new File(filePath);
                    FileOutputStream outputStream = new FileOutputStream(file);
                    DropboxAPI.DropboxFileInfo info = mDBApi.getFile("/AccountData.txt", null, outputStream, null);
                    Log.i("jwoong.song", "The file's rev is: " + info.getMetadata().rev);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
*/

    // read file from server & goto LoginActivity
    private void gotoLogin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String filePath = DropBoxActivity.this.getFilesDir().getPath().toString() + "/AccountData.txt";
                    File file = new File(filePath);
                    FileOutputStream outputStream = new FileOutputStream(file);
                    DropboxAPI.DropboxFileInfo info = mDBApi.getFile("/AccountData.txt", null, outputStream, null);
                    Log.i("jwoong.song", "The file's rev is: " + info.getMetadata().rev);

                    Intent intent = new Intent(DropBoxActivity.this, LoginActivity.class);
                    startActivity(intent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // overwrite login Data to Server when change password or Login remember setting is changed
    public void overwriteLoginData(final String pw, final String remember) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String filePath = DropBoxActivity.this.getFilesDir().getPath().toString() + "/AccountData.txt";
                    File file = new File(filePath);
                    FileWriter writer = new FileWriter(file, false);
                    writer.append("id:sty1ight_admin\n");
                    writer.append("pw:" + pw + "\n");
                    writer.append("remember:" + remember + "\n");
                    writer.flush();
                    writer.close();
                    FileInputStream inputStream;
                    inputStream = new FileInputStream(file);
                    //DropboxAPI.Entry response = mDBApi.putFile("/User.txt", inputStream, file.length(), null, null);
                    DropboxAPI.Entry response = mDBApi.putFileOverwrite("/AccountData.txt", inputStream, file.length(), null);

                    Log.i("jwoong.song", "The uploaded file's rev is: " + response.rev);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_goto_login:
                gotoLogin();
                break;
        }
    }
}
