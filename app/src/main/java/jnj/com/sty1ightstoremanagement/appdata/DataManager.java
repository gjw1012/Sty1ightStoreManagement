package jnj.com.sty1ightstoremanagement.appdata;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by gjw on 2017-05-13.
 */

public class DataManager extends AppCompatActivity {
    private static volatile DataManager sDataManager = null;
    private static final String TAG = "DataManager_sty1ight";

    private List<Marchandise> allDataList = new CopyOnWriteArrayList<>();

    public DataManager() {
        Log.d(TAG, "DataManager Constructor");
    }

    public static DataManager getInstance() {
        if (sDataManager == null) {
            synchronized (DataManager.class) {
                sDataManager = new DataManager();
            }
        }
        return sDataManager;
    }

    public List<Marchandise> getList() {
        return allDataList;
    }
}
