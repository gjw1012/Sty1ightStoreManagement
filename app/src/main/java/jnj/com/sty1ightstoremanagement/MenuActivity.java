package jnj.com.sty1ightstoremanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import jnj.com.sty1ightstoremanagement.appdata.DataManager;
import jnj.com.sty1ightstoremanagement.subactivities.AllActivity;
import jnj.com.sty1ightstoremanagement.subactivities.GraphActivity;
import jnj.com.sty1ightstoremanagement.subactivities.OrderActivity;
import jnj.com.sty1ightstoremanagement.subactivities.StockActivity;
import jnj.com.sty1ightstoremanagement.subactivities.TaxBillActivity;

/**
 * Created by SJW on 2017-05-06.
 */

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    // global variables
    private Button allBtn;
    private Button orderBtn;
    private Button taxBillBtn;
    private Button graphBtn;
    private Button stockBtn;
    private Button settingsBtn;
    // end of global variables

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // initialize Buttons
        initButton();
    }

    private void initButton() {
        allBtn = (Button) findViewById(R.id.button_all);
        orderBtn = (Button) findViewById(R.id.button_order);
        taxBillBtn = (Button) findViewById(R.id.button_tax_bill);
        graphBtn = (Button) findViewById(R.id.button_graph);
        stockBtn = (Button) findViewById(R.id.button_stock);
        settingsBtn = (Button) findViewById(R.id.button_settings);

        allBtn.setOnClickListener(this);
        orderBtn.setOnClickListener(this);
        taxBillBtn.setOnClickListener(this);
        graphBtn.setOnClickListener(this);
        stockBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button_all:
                intent = new Intent(this, AllActivity.class);
                startActivity(intent);
                break;
            case R.id.button_order:
                intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                break;
            case R.id.button_tax_bill:
                intent = new Intent(this, TaxBillActivity.class);
                startActivity(intent);
                break;
            case R.id.button_graph:
                intent = new Intent(this, GraphActivity.class);
                startActivity(intent);
                break;
            case R.id.button_stock:
                intent = new Intent(this, StockActivity.class);
                startActivity(intent);
                break;
            case R.id.button_settings:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
