package com.example.android_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class TestBundle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bundle);
        TextView textView = findViewById(R.id.id_ketqua);
        Intent intent = getIntent();
        Float ketqua = (Float) intent.getSerializableExtra("data");
        Boolean ChanLe = (Boolean) intent.getBooleanExtra("ChanLe", true);
        String PT = (intent.getStringExtra("PT1"));
        ArrayList<Integer> NguyenTo = new ArrayList<>();
        NguyenTo = (ArrayList<Integer>) intent.getSerializableExtra("NT");

        if(NguyenTo != null){
            Log.i("xxx", String.valueOf((NguyenTo)));
            ListView listView = findViewById(R.id.id_listView_ketqua);
            ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter(TestBundle.this, R.layout.color_text_listiew, NguyenTo);
            listView.setAdapter(arrayAdapter);
        }


        if (PT != null) {
            textView.setText(PT);
        }else {
            if (ChanLe) {
                textView.setText("KẾT QUẢ : CHẴN ");
            } else {
                textView.setText("KẾT QUẢ : LẺ ");
            }
        }

        if (ketqua != null) {
            textView.setText("KẾT QUẢ :  " + ketqua);
            Log.d("HTC", String.valueOf(ketqua));
        }


        Button button = findViewById(R.id.id_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}