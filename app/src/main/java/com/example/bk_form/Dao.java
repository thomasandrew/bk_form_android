package com.example.bk_form;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    private Context context;
    private Cursor cursor;
    private SQLiteDatabase db;
    private ConfigDB data;
    private Bean bean;

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

    public List<Bean> load() {
        db = data.getReadableDatabase();
        List<Bean> list = new ArrayList<>();
        try {
            cursor = db.rawQuery("SELECT * FROM " + Bean.FORM, null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    int id = Integer.parseInt(cursor.getString(0));
                    String name = cursor.getString(1);
                    String last_name = cursor.getString(2);
                    String email = cursor.getString(3);
                    String password = cursor.getString(4);
                    String cpf = cursor.getString(5);
                    String cnpj = cursor.getString(6);
                    String address = cursor.getString(7);

                    list.add(new Bean(id, name, last_name, email, password, cpf, cnpj, address));
                } while (cursor.moveToNext());
            } else {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (cursor != null) {
            cursor.close();
        }

        db.close();
        return list;
    }

    public void del(int id) {
        db = data.getWritableDatabase();
        try {
            db.execSQL("DELETE FROM " + Bean.FORM + " WHERE ID = " + id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}
