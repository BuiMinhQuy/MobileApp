package com.buiminhquy.de_2_test;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.buiminhquy.de_2_test.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding bingding;
    Random random = new Random();
    Handler handler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(10,10,10,10);

            ViewGroup.LayoutParams ln = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT);
            LinearLayout ln_parent = new LinearLayout(MainActivity.this);
            ln_parent.setLayoutParams(ln);
            ln_parent.setOrientation(LinearLayout.VERTICAL);

            int rand = random.nextInt(101);

            if (rand % 2 == 0){
                Button button = new Button(MainActivity.this);
                button.setLayoutParams(params);
                button.setText(String.valueOf(rand));
                button.setTextSize(22);

                bingding.lnContainer.addView(button);
            } else {
                EditText editText = new EditText(MainActivity.this);
                editText.setLayoutParams(params);
                editText.setText(String.valueOf(rand));
                editText.setTextSize(22);

                bingding.lnContainer.addView(editText);
            }

        }
    };

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        bingding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bingding.getRoot());

        addEvents();
    }

    private void addEvents(){
        bingding.btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawBackground();
            }
        });
    }

    private void drawBackground(){
        bingding.lnContainer.removeAllViews();
        int numfOfView = Integer.parseInt(bingding.edNumber.getText().toString());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1 ; i < numfOfView ;i++){
                    handler.post(runnable);
                }
            }
        });
        thread.start();
    }
}