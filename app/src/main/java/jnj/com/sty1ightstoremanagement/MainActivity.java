package jnj.com.sty1ightstoremanagement;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jnj.com.sty1ightstoremanagement.account.LoginActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button dropboxButton;
    static public Context sContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sContext = getApplicationContext();

        dropboxButton = (Button) findViewById(R.id.button_login);
        dropboxButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
