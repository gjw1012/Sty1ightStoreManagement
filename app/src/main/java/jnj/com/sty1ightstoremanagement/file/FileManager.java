package jnj.com.sty1ightstoremanagement.file;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by SJW on 2017-05-18.
 */

public class FileManager {
    private static volatile FileManager sFileManager = null;
    private static final String TAG = "FileManager_sty1ight";
    private Context mContext;

    public FileManager(Context context) {
        Log.d(TAG, "FileManager Constructor");
        mContext = context;
    }

    public static FileManager getInstance(Context context) {
        if (sFileManager == null) {
            synchronized (FileManager.class) {
                sFileManager = new FileManager(context);
            }
        }
        return sFileManager;
    }

    public void initAccountFile() {
        Log.d(TAG, "initAccountFile called");
        String filePath = mContext.getFilesDir().getPath().toString() + "/AccountData.txt";
        File file = new File(filePath);
        if (!file.exists()) { // if file is not exist
            try {
                FileWriter writer = new FileWriter(file, false);
                writer.append("sty1ight_admin:aaaa1111:false\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
