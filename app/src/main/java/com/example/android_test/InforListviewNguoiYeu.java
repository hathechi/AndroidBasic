package com.example.android_test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import JavaClass.History;

public class InforListviewNguoiYeu extends AppCompatActivity {
    private ImageView imvNguoiyeu,imvNguoiyeu2;
    private TextView tvTenDuDoanNguoiYeu, tvKetQuaNguoiYeu, tvTimeNguoiYeu;
    private History history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_listview_nguoi_yeu);
        tvKetQuaNguoiYeu = findViewById(R.id.id_ketqua_nguoiyeu);
        tvTenDuDoanNguoiYeu = findViewById(R.id.id_name_nguoiyeu);
        tvTimeNguoiYeu = findViewById(R.id.id_time_nguoiyeu);
        imvNguoiyeu = findViewById(R.id.id_img_nguoiyeu);
        imvNguoiyeu2 = findViewById(R.id.id_img_nguoiyeu2);

        Intent intent = getIntent();
        history = (History) intent.getSerializableExtra("dataNguoiYeu");
        if (history != null) {
            //in thời gian
            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM//yyyy");
            String strDate = dateFormat.format(history.getTime());
            tvTimeNguoiYeu.setText(strDate);
            tvTenDuDoanNguoiYeu.setText(history.getTendoan());
            tvKetQuaNguoiYeu.setText(history.getKetqua());
            imvNguoiyeu2.setImageResource(history.getHinh2());
            imvNguoiyeu.setImageResource(history.getHinh());
        }

    }
}