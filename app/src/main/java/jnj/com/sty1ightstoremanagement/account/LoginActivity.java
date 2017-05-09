package jnj.com.sty1ightstoremanagement.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
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

import jnj.com.sty1ightstoremanagement.MenuActivity;
import jnj.com.sty1ightstoremanagement.R;

/**
 * Created by SJW on 2017-05-07.
 */

public class LoginActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    EditText idInput, passwordInput;
    CheckBox autoLogin;
    Button loginButton, changePwButton;
    boolean rememberLogin;
    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;

        initObjects();
        checkRememberState();
    }

    public static LoginActivity getInstance() {
        return (LoginActivity) mContext;
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
        if (readLoginDataFromFile("remember").equals("true")) {
            Log.e("jwoong.song","onCreate, remember == true");
            autoLogin.setChecked(true);
            rememberLogin = true;
            passwordInput.setText(readLoginDataFromFile("pw"));
        } else {
            Log.e("jwoong.song","onCreate, remember == false");
            autoLogin.setChecked(false);
            rememberLogin = false;
            passwordInput.setText("");
        }
    }

    private void loginCheck() {
        String id, password;
        id = readLoginDataFromFile("id");
        password = readLoginDataFromFile("pw");
        if (idInput.getText().toString().equals(id)
                && passwordInput.getText().toString().equals(password)) {
            //login success
            editFile(null, null, rememberLogin+"");

            Intent intent1 = new Intent(this, MenuActivity.class);
            startActivity(intent1);
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
                //makeFile();
                break;
        }
    }

    public void makeFile() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String newPath = absolutePath + "/sty1ight";
        File file = new File(newPath, "data.txt");
        try {
            FileWriter wr = new FileWriter(file, false);
            PrintWriter writer = new PrintWriter(wr);
            writer.println("id:" + idInput.getText());
            writer.println("pw:" + passwordInput.getText());
            writer.println("remember:" + false);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void editFile(String id, String pw, String remember) {
        String defaultId = idInput.getText().toString();
        String defaultPw = passwordInput.getText().toString();
        String defaultRemember = rememberLogin+"";
        if (id != null) defaultId = id;
        if (pw != null) defaultPw = pw;
        if (remember != null) defaultRemember = remember;

        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String newPath = absolutePath + "/sty1ight";
        File file = new File(newPath, "data.txt");

        try {
            file.createNewFile();
            FileWriter wr = new FileWriter(file, false);
            PrintWriter writer = new PrintWriter(wr);
            writer.println("id:" + defaultId);
            writer.println("pw:" + defaultPw);
            writer.println("remember:" + defaultRemember);
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String readLoginDataFromFile(String index) {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String newPath = absolutePath + "/sty1ight";
        File file = new File(newPath, "data.txt");

        //StringBuffer buffer = new StringBuffer();
        try {
            FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);
            String str = reader.readLine();

            while (str != null) {
                if (str.split(":")[0].equals(index)) {
                    return str.split(":")[1];
                }
                //buffer.append(str + "\n");
                str = reader.readLine();
            }
            //loginButton.setText(buffer.toString());
            reader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}