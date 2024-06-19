package com.buiminhquy.de_2_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context){
        super(context, "SanPham" , null, 1 );
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "Create table SanPham(masp text Primary key, tensp text, gia text)";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp1' , 'Vertu Constellation' , '100')";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp2' , 'Vertu Constellation' , '2')";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp3' , 'Vertu Constellation' , '300')";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp4' , 'Vertu Constellation' , '400')";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp5' , 'Vertu Constellation' , '500')";
        db.execSQL(sql);
        sql = "insert into SanPham values('sp6' , 'Vertu Constellation' , '600')";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "Drop table if exists SanPham";
        onCreate(db);
    }
}
