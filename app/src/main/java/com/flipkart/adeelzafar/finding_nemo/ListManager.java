package com.flipkart.adeelzafar.finding_nemo;

import java.util.ArrayList;
import java.util.List;

//import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.BaseColumns;

//import com.kaju.helo.R;

public class ListManager extends SQLiteOpenHelper {

    private final Context mCtx;

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "prefs";

    // Device name table
    public static final String TABLE_RED_DEVICE = "red_devices";
    public static final String TABLE_ORANGE_DEVICE = "orange_devices";
    public static final String TABLE_YELLOW_DEVICE = "yellow_devices";

    private static final String COLUMN_ADDR = "addr";
    private static final String COLUMN_NAME = "name";

    public ListManager(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);

        mCtx = ctx;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // tables created since version 1
        String CREATE_RED_TABLE = "CREATE TABLE " + TABLE_RED_DEVICE + "("
                + COLUMN_ADDR + " TEXT UNIQUE,"
                + COLUMN_NAME + " TEXT" + ")";
        db.execSQL(CREATE_RED_TABLE);

        String CREATE_ORANGE_TABLE = "CREATE TABLE " + TABLE_ORANGE_DEVICE + "("
                + COLUMN_ADDR + " TEXT UNIQUE,"
                + COLUMN_NAME + " TEXT" + ")";
        db.execSQL(CREATE_ORANGE_TABLE);

        String CREATE_YELLOW_TABLE = "CREATE TABLE " + TABLE_YELLOW_DEVICE + "("
                + COLUMN_ADDR + " TEXT UNIQUE,"
                + COLUMN_NAME + " TEXT" + ")";
        db.execSQL(CREATE_YELLOW_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }

    public List<DeviceInfo> getDevicesFromList(String tableName) {
        List<DeviceInfo> devices = new ArrayList<DeviceInfo>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(tableName, new String[] {COLUMN_NAME, COLUMN_ADDR}, null, null,
                null, null, null);

        while (cursor.moveToNext()) {
            devices.add(new DeviceInfo(cursor.getString(0), cursor.getString(1)));
        }

        db.close();

        return devices;

    }

    public int addDeviceToList(String tableName, DeviceInfo device) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, device.mName);
        values.put(COLUMN_ADDR, device.mAddress);

        long rowId = db.insert(tableName, null, values);
        db.close();

        int rowsAffected = (rowId == -1 ? 0 : 1);
        return rowsAffected;
    }

    public int removeDeviceFromList(String tableName, DeviceInfo device) {

        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(tableName, COLUMN_ADDR + " = ?",
                new String[] { device.mAddress });
        db.close();

        return rowsDeleted;
    }

}