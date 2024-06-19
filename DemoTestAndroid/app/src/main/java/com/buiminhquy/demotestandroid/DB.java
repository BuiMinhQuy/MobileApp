package com.buiminhquy.demotestandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context) {
        super(context, "SanPham" , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table SanPham(masp text Primary key, tensp text, gia text)";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp1' , 'SamSung1' , '10000')";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp2' , 'SamSung2' , '10000')";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp3' , 'SamSung3' , '10000')";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp4' , 'SamSung4' , '10000')";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp5' , 'SamSung5' , '10000')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "Drop table if exists SanPham";
        onCreate(db);
    }
}
