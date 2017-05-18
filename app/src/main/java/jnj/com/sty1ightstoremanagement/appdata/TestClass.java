package jnj.com.sty1ightstoremanagement.appdata;

import android.content.Context;

/**
 * Created by gjw on 2017-05-13.
 */

public class TestClass {
    private static volatile TestClass sTestClass = null;

    public TestClass() {

    }

    public static TestClass getInstance() {
        if (sTestClass == null) {
            synchronized (TestClass.class) {
                sTestClass = new TestClass();
            }
        }
        return sTestClass;
    }

    public void test() {
        DataManager.getInstance().getList();
    }

}


