package jnj.com.sty1ightstoremanagement.appdata;

/**
 * Created by gjw on 2017-05-13.
 */

public class Merchandise {
    private String mCode;
    private String mNameForUsers; // 사용자가 쓰는 물품명
    private String mNameForCooperators; // 거래처에서 쓰는 물품명
    private String mCooperatorName; // 상호명
    private String mCooperatorTelephone;
    private String mCooperatorAddress;
    private String mCooperatorBankAccount;
    private String mPurchaseDate;
    private String mColor;
    private String mSize;
    private int mPriceOrigin;
    private int mPriceForSale;
    private int mQuantity;
    private int mTotal;
    private int mSalesCnt;
    private int mReturnsCnt;
    private int mChangesCnt;
    private int mDefectedCnt;

    private int mMargin; // mMargin = mPriceForSale*0.95*0.9-mPriceOrigin;



    public Merchandise(String code, String nameForUsers, String cooperatorName, String nameForCooperators, String cooperatorTelephone,
                String cooperatorAddress, String cooperatorBankAccount, String purchaseDate, String color, String size, int priceOrigin,
                int priceForSale, int quantity, int total, int salesCnt, int returnsCnt, int changesCnt, int defectedCnt){
        mCode = code; mNameForUsers = nameForUsers; mNameForCooperators = nameForCooperators; mCooperatorName = cooperatorName; mCooperatorTelephone = cooperatorTelephone;
        mCooperatorAddress = cooperatorAddress; mCooperatorBankAccount = cooperatorBankAccount; mPurchaseDate = purchaseDate; mColor = color; mSize = size;
        mPriceOrigin = priceOrigin; mPriceForSale = priceForSale; mQuantity = quantity; mTotal = total; mSalesCnt = salesCnt; mReturnsCnt = returnsCnt;
        mChangesCnt = changesCnt; mDefectedCnt = defectedCnt;
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode;
    }

    public String getmNameForUsers() {
        return mNameForUsers;
    }

    public void setmNameForUsers(String mNameForUsers) {
        this.mNameForUsers = mNameForUsers;
    }

    public String getmNameForCooperators() {
        return mNameForCooperators;
    }

    public void setmNameForCooperators(String mNameForCooperators) {
        this.mNameForCooperators = mNameForCooperators;
    }

    public String getmCooperatorName() {
        return mCooperatorName;
    }

    public void setmCooperatorName(String mCooperatorName) {
        this.mCooperatorName = mCooperatorName;
    }

    public String getmCooperatorTelephone() {
        return mCooperatorTelephone;
    }

    public void setmCooperatorTelephone(String mCooperatorTelephone) {
        this.mCooperatorTelephone = mCooperatorTelephone;
    }

    public String getmCooperatorAddress() {
        return mCooperatorAddress;
    }

    public void setmCooperatorAddress(String mCooperatorAddress) {
        this.mCooperatorAddress = mCooperatorAddress;
    }

    public String getmCooperatorBankAccount() {
        return mCooperatorBankAccount;
    }

    public void setmCooperatorBankAccount(String mCooperatorBankAccount) {
        this.mCooperatorBankAccount = mCooperatorBankAccount;
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

    public int getmPriceOrigin() {
        return mPriceOrigin;
    }

    public void setmPriceOrigin(int mPriceOrigin) {
        this.mPriceOrigin = mPriceOrigin;
    }

    public int getmPriceForSale() {
        return mPriceForSale;
    }

    public void setmPriceForSale(int mPriceForSale) {
        this.mPriceForSale = mPriceForSale;
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
