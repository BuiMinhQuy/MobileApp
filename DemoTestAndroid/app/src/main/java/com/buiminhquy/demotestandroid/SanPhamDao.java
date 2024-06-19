package com.buiminhquy.demotestandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SanPhamDao {
    // lấy dữ liệu từ DB lên
    public static ArrayList<SanPham> getAll(Context context) {
        ArrayList<SanPham> mylist = new ArrayList<>();
        DB helper = new DB(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT*FROM SanPham" , null);
        cursor.moveToFirst();
        mylist.clear();
        while (!cursor.isAfterLast()){
            String ma = cursor.getString(0);
            String ten = cursor.getString(1);
            int gia = Integer.parseInt(cursor.getString(2));
            SanPham sanPham = new SanPham(ma, ten, gia);
            mylist.add(sanPham);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return mylist;
    }

    public static boolean inserts (Context context , String ma, String ten, int gia){
        DB helper = new DB(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("masp" , ma);
        values.put("tensp" , ten);
        values.put("gia" , gia);
        long row = db.insert("SanPham" , null , values);
        return row>0;
    }
}
