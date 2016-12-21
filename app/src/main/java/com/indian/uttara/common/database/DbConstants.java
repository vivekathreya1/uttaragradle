package com.indian.uttara.common.database;

/**
 * Created by Vivekathreya on 9/4/2016.
 */
public class DbConstants {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Uttara.sqlite";
    public static final String TABLE_SERVICES = "TblServices";

    /*
    Services Table Columns
     */
    public static final String KEY_SERVICE_ID = "_id";
    public static final String KEY_SERVICE_NAME = "service";
    public static final String KEY_SERVICE_AVBL_QUANTITY = "quantity";
    public static final String KEY_SERVICE_TYPE = "servicetype";
    public static final String KEY_SERVICE_BRIEF_DESC = "briefdesc";
    public static final String KEY_SERVICE_FULL_DESC = "fulldesc";
    public static final String KEY_SERVICE_PRICE = "price";
    public static final String KEY_SERVICE_SPEC = "prodspec";


    public static final String CREATE_SERVICES_TABLE = "CREATE TABLE " + TABLE_SERVICES + "(" + KEY_SERVICE_ID
            + " INTEGER ," + KEY_SERVICE_NAME + " TEXT," + KEY_SERVICE_TYPE + " STRING,"
            + KEY_SERVICE_BRIEF_DESC + " TEXT," + KEY_SERVICE_FULL_DESC + " TEXT," + KEY_SERVICE_PRICE + " TEXT,"
            + KEY_SERVICE_SPEC + " TEXT," + KEY_SERVICE_AVBL_QUANTITY + " INTEGER" + ")";


}
