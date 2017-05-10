package jnj.com.sty1ightstoremanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import jnj.com.sty1ightstoremanagement.dropbox.DropBoxActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button dropboxButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dropboxButton = (Button) findViewById(R.id.button_dropbox);
        dropboxButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_dropbox:
                Intent intent1 = new Intent(this, DropBoxActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
