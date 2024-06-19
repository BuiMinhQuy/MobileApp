package com.buiminhquy.de_2_test;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SanPhamDao {
    public static ArrayList<SanPham> getAll(Context context){
        ArrayList<SanPham> mylist =new ArrayList<>();
        DB helper = new DB(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT*FROM SanPham" , null);
        cursor.moveToFirst();
        mylist.clear();
        while (!cursor.isAfterLast()){
            String ma = cursor.getString(0);
            String ten = cursor.getString(1);
            int gia = Integer.parseInt(cursor.getString(2));
            SanPham sanPham = new SanPham(ma , ten , gia);
            mylist.add(sanPham);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return mylist;
    }

    public static boolean delete(Context context , String ma){
        DB helper = new DB(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        int rowAf= db.delete("SanPham" , "masp = ?" , new String[]{ma});
        return rowAf>0;
    }
}
