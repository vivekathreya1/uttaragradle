package com.indian.uttara.commondb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.indian.uttara.apimodel.ServicesRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivekathreya on 9/4/2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    private Context context;

    public DbHelper(Context context) {
        super(context, DbConstants.DATABASE_NAME, null, DbConstants.DATABASE_VERSION);
        this.context = context;
        this.db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(DbConstants.CREATE_SERVICES_TABLE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DbConstants.TABLE_SERVICES);
        onCreate(db);
    }

    /**
     * All services list from Database
     */

    public long insertAllServicesList(List<ServicesRepo> servicesList) {

        try {
            ContentValues values = new ContentValues();
            SQLiteDatabase db = this.getWritableDatabase();

            for (ServicesRepo serviceListObj : servicesList) {
                values.put(DbConstants.KEY_SERVICE_NAME, serviceListObj.getServiceName());
                values.put(DbConstants.KEY_SERVICE_ID, serviceListObj.getServiceNameId());
                values.put(DbConstants.KEY_SERVICE_AVBL_QUANTITY, serviceListObj.getServiceAvlQnt());
                values.put(DbConstants.KEY_SERVICE_BRIEF_DESC, serviceListObj.getServiceSDecp());
                values.put(DbConstants.KEY_SERVICE_FULL_DESC, serviceListObj.getServiceLDecp());
                values.put(DbConstants.KEY_SERVICE_PRICE, serviceListObj.getServicePrice());
                values.put(DbConstants.KEY_SERVICE_SPEC, serviceListObj.getServiceSpec());
                values.put(DbConstants.KEY_SERVICE_TYPE, serviceListObj.getServiceType());
                db.insert(DbConstants.TABLE_SERVICES, null, values);
            }
            db.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<ServicesRepo> getServicesList(String ServiceType) {

//        try {
//            ArrayList<ServicesRepo> servicesList = new ArrayList<>();
//            String selectQuery;
//            selectQuery = "SELECT * FROM " + DbConstants.TABLE_SERVICES;
//            SQLiteDatabase sqLiteDb = this.getReadableDatabase();
//           Cursor cursor = sqLiteDb.rawQuery(selectQuery, null);
//
////            Cursor cursor =  db.query(DbConstants.TABLE_SERVICES, allColumns, DbConstants.KEY_SERVICE_TYPE
////                    + "= ?", new String[] { ServiceType }, null, null, null);
//
//            if (cursor != null && cursor.getCount() > 0) {
//                ServicesRepo productDb = new ServicesRepo();
//                cursor.moveToFirst();
//                do {
//
//                    productDb.setServiceNameId(cursor.getInt(cursor.getColumnIndexOrThrow(DbConstants.KEY_SERVICE_ID)));
//                    productDb.setServiceName(cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.KEY_SERVICE_NAME)));
//                    productDb.setServiceAvlQnt(cursor.getInt(cursor
//                            .getColumnIndexOrThrow(DbConstants.KEY_SERVICE_AVBL_QUANTITY)));
//                    productDb.setServicePrice(cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.KEY_SERVICE_PRICE)));
//                    productDb.setServiceSDecp(cursor.getString(cursor
//                            .getColumnIndexOrThrow(DbConstants.KEY_SERVICE_BRIEF_DESC)));
//                    productDb.setServiceLDecp(cursor.getString(cursor
//                            .getColumnIndexOrThrow(DbConstants.KEY_SERVICE_FULL_DESC)));
//                    productDb.setServiceSpec(cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.KEY_SERVICE_SPEC)));
//                    productDb.setServiceType(cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.KEY_SERVICE_TYPE)));
//                    servicesList.add(productDb);
//
//                } while (cursor.moveToNext());
//            }
//            cursor.close();
//            sqLiteDb.close();
//            return servicesList;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        ArrayList<ServicesRepo> servicesList = new ArrayList<>();
        /***********************FOr testing UI only************/ //TODO remove it later
        for (int i = 0; i < 100; i++) {
            ServicesRepo productDb = new ServicesRepo();

            productDb.setServiceNameId(i);
            productDb.setServiceName("VIvek");
            productDb.setServiceAvlQnt(200);
            productDb.setServicePrice("200");
            productDb.setServiceSDecp("hoshsdhoshsid sdifhosid");
            productDb.setServiceLDecp(" Allstar Electrical Services has vast experience on the commercial side in providing top-notch electrical work for the specialized industrial sector. Industrial buildings today have more electrical requirements than ever before in construction history. These types of commercial facilities often go beyond a typical office building for electrical service needs, with specialized dedicated power systems to operate complex machinery, and work-space lighting requirements to meet specific and unique needs. We understand how important it is to keep an industrial business in fully functioning operation and we take great pains to see that our Industrial clients’ needs are completely met no matter how complex the challenge.\n" +
                    "\n" +
                    "Allstar Electrical Services' Construction treats each customer with unparalleled professionalism, attention to detail and respect, whether it is a design/build or bid/build project\n" +
                    "\n" +
                    "Our industrial services include:\n" +
                    "\n" +
                    "    General electrical\n" +
                    "    New construction\n" +
                    "    Remodel & retrofits\n" +
                    "    Troubleshooting\n" +
                    "    PLC & motor controls\n" +
                    "    Data cabling\n" +
                    "    Equipment moves, additions & changes\n" +
                    "    Exit signs & egress lights\n" +
                    "    Infrared panel scanning\n" +
                    "    Standby and UPS systems\n" +
                    "    Harmonic remediation & surge protection\n" +
                    "    Preventative maintenance\n" +
                    "    Computer circuits\n" +
                    "    Neon and florescent repairs\n" +
                    "    CCTV and card access systems\n" +
                    "    Parking lot lighting—new and repair\n" +
                    "    Serving property management companies and HOAs\n" +
                    "    LED lighting design services\n" +
                    "    Service upgrades\n" +
                    "    Code corrections\n" +
                    "    Lighting maintenance\n" +
                    "    Signs\n" +
                    "    Outdoor lighting and controls\n" +
                    "    Security lighting\n" +
                    "    Bucket truck service\n" +
                    "    Generator installations\n" +
                    "    Machine hook-ups\n" +
                    "    Insurance claims\n" +
                    "    Inspections and testing\n");
            productDb.setServiceSpec("dfhoisdfhdoihsdnsoiho");
            productDb.setServiceType("hdhdieeieospsp");
            servicesList.add(productDb);
        }


        return servicesList;

    }


}
