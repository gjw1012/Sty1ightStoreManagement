package jnj.com.sty1ightstoremanagement.appdata;

/**
 * Created by gjw on 2017-05-13.
 */

public class Marchandise {
    private int mCode;
    private String mName;
    Marchandise(int code){
        mCode = code;
    }
    public void setCode(int code, String name){
        mCode = code;
    }
    public int getCode(){
        return mCode;
    }
}
