package jnj.com.sty1ightstoremanagement.appdata;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by gjw on 2017-05-13.
 */

public class TestClass {
    private DataManager mDataManager;

    TestClass() {
        mDataManager = DataManager.getInstance();
    }

    private void test() {
        for (Marchandise m : mDataManager.getList()) {
            if (m.getCode() == 1) {

            }
        }
    }

}
