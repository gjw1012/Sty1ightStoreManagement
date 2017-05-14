package jnj.com.sty1ightstoremanagement.appdata;

/**
 * Created by gjw on 2017-05-13.
 */

public class Marchandise {
    private String mCode;
    private String mName_users; // 사용자가 쓰는 물품명
    private String mName_cooperators; // 거래처에서 쓰는 물품명
    private String mCooperator_name; // 상호명
    private String mCooperator_telephone;
    private String mCooperator_address;
    private String mCooperator_bankAccount;
    private String mPurchaseDate;
    private String mColor;
    private String mSize;
    private int mPrice_origin;
    private int mPrice_forSale;
    private int mQuantity;
    private int mTotal;
    private int mSalesCnt;
    private int mReturnsCnt;
    private int mChangesCnt;
    private int mDefectedCnt;

    private int mMargin; // mMargin = mPrice_forSale*0.95*0.9-mPrice_origin;



    Marchandise(String code, String name_users, String cooperator_name, String name_cooperators, String cooperator_telephone,
                String cooperator_address, String cooperator_bankAccount, String purchaseDate, String color, String size, int price_origin,
                int price_forsale, int quantity, int total, int salesCnt, int returnsCnt, int changesCnt, int defectedCnt){
        mCode = code; mName_users = name_users; mName_cooperators = name_cooperators; mCooperator_name = cooperator_name; mCooperator_telephone = cooperator_telephone;
        mCooperator_address = cooperator_address; mCooperator_bankAccount = cooperator_bankAccount; mPurchaseDate = purchaseDate; mColor = color; mSize = size;
        mPrice_origin = price_origin; mPrice_forSale = price_forsale; mQuantity = quantity; mTotal = total; mSalesCnt = salesCnt; mReturnsCnt = returnsCnt;
        mChangesCnt = changesCnt; mDefectedCnt = defectedCnt;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmName_users() {
        return mName_users;
    }

    public void setmName_users(String mName_users) {
        this.mName_users = mName_users;
    }

    public String getmName_cooperators() {
        return mName_cooperators;
    }

    public void setmName_cooperators(String mName_cooperators) {
        this.mName_cooperators = mName_cooperators;
    }

    public String getmCooperator_name() {
        return mCooperator_name;
    }

    public void setmCooperator_name(String mCooperator_name) {
        this.mCooperator_name = mCooperator_name;
    }

    public String getmCooperator_telephone() {
        return mCooperator_telephone;
    }

    public void setmCooperator_telephone(String mCooperator_telephone) {
        this.mCooperator_telephone = mCooperator_telephone;
    }

    public String getmCooperator_address() {
        return mCooperator_address;
    }

    public void setmCooperator_address(String mCooperator_address) {
        this.mCooperator_address = mCooperator_address;
    }

    public String getmCooperator_bankAccount() {
        return mCooperator_bankAccount;
    }

    public void setmCooperator_bankAccount(String mCooperator_bankAccount) {
        this.mCooperator_bankAccount = mCooperator_bankAccount;
    }

    public String getmPurchaseDate() {
        return mPurchaseDate;
    }

    public void setmPurchaseDate(String mPurchaseDate) {
        this.mPurchaseDate = mPurchaseDate;
    }

    public String getmColor() {
        return mColor;
    }

    public void setmColor(String mColor) {
        this.mColor = mColor;
    }

    public String getmSize() {
        return mSize;
    }

    public void setmSize(String mSize) {
        this.mSize = mSize;
    }

    public int getmPrice_origin() {
        return mPrice_origin;
    }

    public void setmPrice_origin(int mPrice_origin) {
        this.mPrice_origin = mPrice_origin;
    }

    public int getmPrice_forSale() {
        return mPrice_forSale;
    }

    public void setmPrice_forSale(int mPrice_forSale) {
        this.mPrice_forSale = mPrice_forSale;
    }

    public int getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }

    public int getmTotal() {
        return mTotal;
    }

    public void setmTotal(int mTotal) {
        this.mTotal = mTotal;
    }

    public int getmSalesCnt() {
        return mSalesCnt;
    }

    public void setmSalesCnt(int mSalesCnt) {
        this.mSalesCnt = mSalesCnt;
    }

    public int getmReturnsCnt() {
        return mReturnsCnt;
    }

    public void setmReturnsCnt(int mReturnsCnt) {
        this.mReturnsCnt = mReturnsCnt;
    }

    public int getmChangesCnt() {
        return mChangesCnt;
    }

    public void setmChangesCnt(int mChangesCnt) {
        this.mChangesCnt = mChangesCnt;
    }

    public int getmDefectedCnt() {
        return mDefectedCnt;
    }

    public void setmDefectedCnt(int mDefectedCnt) {
        this.mDefectedCnt = mDefectedCnt;
    }

    public int getmMargin() {
        return mMargin;
    }

    public void setmMargin(int mMargin) {
        this.mMargin = mMargin;
    }
}
