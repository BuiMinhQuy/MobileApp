package com.buiminhquy.de_2_test;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class C2_MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<SanPham> mylist = new ArrayList<>();
    ArrayAdapter<SanPham> adapter;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.c2_item);
        listView = findViewById(R.id.lv);
        mylist = SanPhamDao.getAll(C2_MainActivity.this);
        adapter = new ArrayAdapter<>(C2_MainActivity.this, android.R.layout.simple_list_item_1, mylist);
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
        AlertDialog.Builder builder =new AlertDialog.Builder(C2_MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.c2_dialog, null);
        builder.setView(view);
        Dialog dialog= builder.create();
        dialog.show();

        EditText ma_sp = view.findViewById(R.id.edtmasp);
        EditText ten_sp = view.findViewById(R.id.editTENSP);
        EditText gia_sp = view.findViewById(R.id.edtgiasp);

        Button btn_xoa = view.findViewById(R.id.btnXoa);
        Button btn_back = view.findViewById(R.id.btnBack);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ma = ma_sp.getText().toString();
                if(SanPhamDao.delete(C2_MainActivity.this, ma)){
                    Toast.makeText(C2_MainActivity.this , "Delete Success" , Toast.LENGTH_SHORT).show();
                    for(int i = 0 ; i < mylist.size() ; i++){
                        if(mylist.get(i).getMasp().equals(ma)){
                            mylist.remove(i);
                            break;
                        }
                    }
                }
            }
        });
    }
}
