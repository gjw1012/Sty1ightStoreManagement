package jnj.com.sty1ightstoremanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

        allBtn.setOnClickListener(this);
        orderBtn.setOnClickListener(this);
        taxBillBtn.setOnClickListener(this);
        graphBtn.setOnClickListener(this);
        stockBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_all:
                break;
            case R.id.button_order:
                break;
            case R.id.button_tax_bill:
                break;
            case R.id.button_graph:
                break;
            case R.id.button_stock:
                break;
        }
    }
}
