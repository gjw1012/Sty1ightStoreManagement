package jnj.com.sty1ightstoremanagement.account;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import jnj.com.sty1ightstoremanagement.Constants;
import jnj.com.sty1ightstoremanagement.MainActivity;
import jnj.com.sty1ightstoremanagement.MenuActivity;
import jnj.com.sty1ightstoremanagement.R;
import jnj.com.sty1ightstoremanagement.file.FileManager;

/**
 * Created by SJW on 2017-05-07.
 */

public class LoginActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private static final String TAG = "LoginActivity_sty1ight";
    private static LoginActivity sLoginActivity = null;

    EditText idInput, passwordInput;
    CheckBox autoLogin;
    Button loginButton, changePwButton;
    boolean rememberLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FileManager.getInstance(MainActivity.sContext).initAccountFile();

        initObjects();
        checkRememberState();
    }

    public LoginActivity() {
        Log.d(TAG, "LoginActivity Constructor");
    }

    public static LoginActivity getInstance() {
        if (sLoginActivity == null) {
            synchronized (FileManager.class) {
                sLoginActivity = new LoginActivity();
            }
        }
        return sLoginActivity;
    }


    private void initObjects() {
        idInput = (EditText) findViewById(R.id.id_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        autoLogin = (CheckBox) findViewById(R.id.checkbox_remember_login);
        loginButton = (Button) findViewById(R.id.button_login);
        changePwButton = (Button) findViewById(R.id.button_change_pw);

        autoLogin.setOnCheckedChangeListener(this);
        loginButton.setOnClickListener(this);
        changePwButton.setOnClickListener(this);
    }

    private void checkRememberState() {
        if (readLoginDataFromFile(Constants.INDEX_REMEMBER).equals("true")) {
            Log.e("jwoong.song", "onCreate, remember == true");
            autoLogin.setChecked(true);
            rememberLogin = true;
            passwordInput.setText(readLoginDataFromFile(Constants.INDEX_PASSWORD));
        } else {
            Log.e("jwoong.song", "onCreate, remember == false");
            autoLogin.setChecked(false);
            rememberLogin = false;
            passwordInput.setText("");
        }
    }

    private void loginCheck() {
        String id, password;
        id = readLoginDataFromFile(Constants.INDEX_ID);
        password = readLoginDataFromFile(Constants.INDEX_PASSWORD);
        if (idInput.getText().toString().equals(id)
                && passwordInput.getText().toString().equals(password)) {
            //login success
            editFile(null, rememberLogin + "");

            Intent intent1 = new Intent(this, MenuActivity.class);
            startActivity(intent1);
            finish();
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()) {
            case R.id.checkbox_remember_login:
                if (isChecked) {
                    rememberLogin = true;
                } else {
                    // if unChecked, removeAll
                    rememberLogin = false;
                }
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                loginCheck();
                break;
            case R.id.button_change_pw:
                Intent intent = new Intent(this, ChangePasswordActivity.class);
                startActivity(intent);
                finish();
                //makeFile();
                break;
        }
    }

    public void editFile(String pw, String remember) {
        String defaultPw = readLoginDataFromFile(Constants.INDEX_PASSWORD);
        String defaultRemember = rememberLogin + "";
        if (pw != null) defaultPw = pw;
        if (remember != null) defaultRemember = remember;


        String filePath = MainActivity.sContext.getFilesDir().getPath().toString() + "/AccountData.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            FileWriter wr = new FileWriter(file, false);
            PrintWriter writer = new PrintWriter(wr);
            writer.print("sty1ight_admin:");
            writer.print(defaultPw + ":");
            writer.println(defaultRemember);
            //((DropBoxActivity) DropBoxActivity.mContext).overwriteLoginData(defaultPw, defaultRemember);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String readLoginDataFromFile(int index) {
        String filePath = MainActivity.sContext.getFilesDir().getPath().toString() + "/AccountData.txt";
        File file = new File(filePath);
        String tempData = null;

        //StringBuffer buffer = new StringBuffer();
        try {
            FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);
            String str = reader.readLine();

            while (str != null) {
                tempData = str.split(":")[index];
                str = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tempData;
    }
}