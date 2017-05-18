package jnj.com.sty1ightstoremanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import jnj.com.sty1ightstoremanagement.dropbox.DropBoxActivity;

/**
 * Created by SJW on 2017-05-19.
 */

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnConnectDropbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnConnectDropbox = (Button) findViewById(R.id.button_connect_dropbox);
        btnConnectDropbox.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_connect_dropbox:
                Intent intent = new Intent(this, DropBoxActivity.class);
                startActivity(intent);
                break;
        }
    }
}
