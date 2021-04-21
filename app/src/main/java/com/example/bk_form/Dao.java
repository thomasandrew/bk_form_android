package com.example.bk_form;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

public class Dao {
    private Context context;
    private Cursor cursor;
    private SQLiteDatabase db;
    private ConfigDB data;

    public Dao(Context context) {
        this.context = context;
        data = new ConfigDB(context);
        db = data.getReadableDatabase();
    }

    public void insertData(Bean bean) {
        try {
            ContentValues cv;

            cv = new ContentValues();
            cv.put(Bean.NAME, bean.getName());
            cv.put(Bean.LAST_NAME, bean.getLast_name());
            cv.put(Bean.EMAIL, bean.getEmail());
            cv.put(Bean.PASSWORD, bean.getPassword());
            cv.put(Bean.CPF, bean.getCpf());
            cv.put(Bean.CNPJ, bean.getCnpj());
            cv.put(Bean.ADDRESS, bean.getAddress());
            db = data.getWritableDatabase();
            db.insert(Bean.FORM, null, cv);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}
