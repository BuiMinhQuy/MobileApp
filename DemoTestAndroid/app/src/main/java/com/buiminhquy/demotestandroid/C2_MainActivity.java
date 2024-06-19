package com.buiminhquy.demotestandroid;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class C2_MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<SanPham> mylist =new ArrayList<>();
    ArrayAdapter<SanPham> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c2);

        listView = findViewById(R.id.lv);
        mylist = SanPhamDao.getAll(C2_MainActivity.this);
        adapter =new ArrayAdapter<>(C2_MainActivity.this,android.R.layout.simple_list_item_1,mylist);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog();
                return true;
            }
        });

    }

    private void Dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(C2_MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.c2_dialog, null);
        builder.setView(view);
        Dialog dialog=builder.create();
        dialog.show();

        EditText ma_sp = view.findViewById(R.id.edtmasp);
        EditText ten_sp = view.findViewById(R.id.edttensp);
        EditText gia_sp = view.findViewById(R.id.edtgiasp);

        //Button btn_delete = view.findViewById(R.id.btn);
        Button btn_luu = view.findViewById(R.id.btnLuu);
        Button btn_thoat = view.findViewById(R.id.btnBack);

        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = ma_sp.getText().toString();
                String ten = ten_sp.getText().toString();
                int gia = Integer.parseInt(gia_sp.getText().toString());
                if(SanPhamDao.inserts(C2_MainActivity.this, ma, ten, gia)){
                    Toast.makeText(C2_MainActivity.this, "Save Success", Toast.LENGTH_SHORT);
                    mylist.add(new SanPham(ma, ten, gia));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
                else{
                    Toast.makeText(C2_MainActivity.this, "Save Faile", Toast.LENGTH_SHORT);
                    dialog.dismiss();
                }
            }
        });
    }
}
