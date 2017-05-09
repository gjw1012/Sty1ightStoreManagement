package jnj.com.sty1ightstoremanagement.account;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import jnj.com.sty1ightstoremanagement.R;

/**
 * Created by SJW on 2017-05-08.
 */

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher{
    private EditText oldPassword, newPassword1, newPassword2;
    private TextView checkPassword;
    private Button confirmChange;
    private LoginActivity mLoginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        oldPassword = (EditText) findViewById(R.id.editText_original_pw);
        newPassword1 = (EditText) findViewById(R.id.editText_new_pw_1);
        newPassword2 = (EditText) findViewById(R.id.editText_new_pw_2);
        checkPassword = (TextView) findViewById(R.id.textView_check_pw);
        confirmChange = (Button) findViewById(R.id.button_change_pw_confirm);

        confirmChange.setOnClickListener(this);
        oldPassword.addTextChangedListener(this);
        newPassword1.addTextChangedListener(this);
        newPassword2.addTextChangedListener(this);

        mLoginActivity = LoginActivity.getInstance();
    }

    private boolean checkPasswordValidity() {
        return mLoginActivity.readLoginDataFromFile("pw").equals(oldPassword.getText().toString())
                && newPassword1.getText().toString().equals(newPassword2.getText().toString())
                && newPassword1.getText().toString().length() > 5;

    }

    private void savePassword() {
        if (checkPasswordValidity()) {
            mLoginActivity.editFile(null, newPassword1.getText().toString(), false + "");
            Toast.makeText(this, "Change Password Success", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Change Password Failed", Toast.LENGTH_LONG).show();
        }
    }

    private void checkOnKeyDown() {
        if (!mLoginActivity.readLoginDataFromFile("pw").equals(oldPassword.getText().toString())) {

            checkPassword.setText("비밀번호가 틀렸습니다");
        } else if (newPassword1.getText().toString().length() < 5) {
            checkPassword.setText("새 비밀번호가 너무 짧습니다");
        } else if (!newPassword1.getText().toString().equals(newPassword2.getText().toString())) {
            checkPassword.setText("새 비밀번호가 일치하지 않습니다");
        } else {
            checkPassword.setText("변경 가능");
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_change_pw_confirm:
                // save and back to login
                savePassword();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        checkOnKeyDown();
    }
}
