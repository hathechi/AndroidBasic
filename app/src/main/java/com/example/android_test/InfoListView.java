package com.example.android_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoListView extends AppCompatActivity {

    private InfoStudent infoStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_list_view);

        ImageView imageView=findViewById(R.id.id_img);
        TextView name = findViewById(R.id.id_name);
        TextView sdt = findViewById(R.id.id_sdt);
        //Nhận dữ liệu từ bên gửi

        Intent intent = getIntent();
        infoStudent = (InfoStudent) intent.getSerializableExtra("DATA");

        if (infoStudent != null ) {

            name.setText(infoStudent.getName());
            sdt.setText(infoStudent.getPhone());
            imageView.setImageResource(infoStudent.getImage());

            Log.w("HTC", infoStudent.getPhone() + infoStudent.getName() + infoStudent.getImage());
        } else {
            Log.w("HTC", "Khong co data");

        }

    }
}