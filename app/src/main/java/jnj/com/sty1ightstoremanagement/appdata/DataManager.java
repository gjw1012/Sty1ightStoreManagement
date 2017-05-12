package jnj.com.sty1ightstoremanagement.appdata;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by gjw on 2017-05-13.
 */

public class DataManager extends AppCompatActivity{
    public static Context mContext;

    private List<Marchandise> allDataList = new CopyOnWriteArrayList<>();

    DataManager(){
        mContext = DataManager.this;
    }
    public static DataManager getInstance() {
        return (DataManager) mContext;
    }

    public List<Marchandise> getList() {
        return allDataList;
    }

}
