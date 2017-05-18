package jnj.com.sty1ightstoremanagement.file;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import jnj.com.sty1ightstoremanagement.appdata.DataManager;
import jnj.com.sty1ightstoremanagement.appdata.Merchandise;

/**
 * Created by SJW on 2017-05-18.
 */

public class FileManager {
    private static volatile FileManager sFileManager = null;
    private static final String TAG = "FileManager_sty1ight";
    private Context mContext;
    private DataManager mDataManager = DataManager.getInstance();

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

    public void writeMerchandise() {
        String filePath = mContext.getFilesDir().getPath().toString() + "/MerchandiseData.txt";
        File file = new File(filePath);
        try {
            FileWriter writer = new FileWriter(file, false);
            for (Merchandise md : mDataManager.getList()) {
                writer.append(md.getmCode() + "|" + md.getmNameForUsers() + "|" + md.getmNameForCooperators() + "|" + md.getmCooperatorName() + "|" + md.getmCooperatorTelephone() + "|"
                        + md.getmCooperatorAddress() + "|" + md.getmCooperatorBankAccount() + "|" + md.getmPurchaseDate() + "|" + md.getmColor() + "|" + md.getmSize() + "|" + md.getmPriceOrigin() + "|"
                        + md.getmPriceForSale() + "|" + md.getmQuantity() + "|" + md.getmTotal() + "|" + md.getmSalesCnt() + "|" + md.getmReturnsCnt() + "|" + md.getmChangesCnt() + "|" + md.getmDefectedCnt() + "\n");
                writer.flush();
                writer.close();
            }
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

    public void readMerchandise() {
        String line = "";
        String filePath = mContext.getFilesDir().getPath().toString() + "/MerchandiseData.txt";
        File file = new File(filePath);
        if (!file.exists()) { // if file is not exist
            try {
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                while ((line = br.readLine()) != null) {
                    String merchandiseData[] = line.split("|");
                    Merchandise md = new Merchandise(merchandiseData[0], merchandiseData[1], merchandiseData[2], merchandiseData[3], merchandiseData[4], merchandiseData[5]
                            , merchandiseData[6], merchandiseData[7], merchandiseData[8], merchandiseData[9], Integer.parseInt(merchandiseData[10]), Integer.parseInt(merchandiseData[11])
                            , Integer.parseInt(merchandiseData[12]), Integer.parseInt(merchandiseData[13]), Integer.parseInt(merchandiseData[14]), Integer.parseInt(merchandiseData[15])
                            , Integer.parseInt(merchandiseData[16]), Integer.parseInt(merchandiseData[17]));
                    mDataManager.getList().add(md);
                }
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }
}
