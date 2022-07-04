package com.example.android_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class ThongTin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        ListView list = findViewById(R.id.id_listview);


        ArrayList<InfoStudent> arrayList = new ArrayList<InfoStudent>();
        arrayList.add(new InfoStudent("Đại Nghĩa", R.drawable.emone, "0234455677"));
        arrayList.add(new InfoStudent("Trung Quân", R.drawable.emtwo, "0345666777"));
        arrayList.add(new InfoStudent("Hữu Nam", R.drawable.emthree, "0334564666"));
        arrayList.add(new InfoStudent("Văn Việt", R.drawable.emone, "0334564666"));
        arrayList.add(new InfoStudent("Văn Lâm", R.drawable.emtwo, "0334564666"));
        JavaCustomListview custom = new JavaCustomListview(this, arrayList);
        list.setAdapter(custom);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ThongTin.this, InfoListView.class);
                InfoStudent dataSend = arrayList.get(position);
                if (dataSend != null) {
                    intent.putExtra("DATA", dataSend);
                    startActivity(intent);

                }
            }
        });
    }
}

// Phải implements Serializable để gửi dữ liệu đi
class InfoStudent implements Serializable {
    private String name;
    private int image;
    private String phone;

    public InfoStudent(String name, int image, String phone) {
        this.name = name;
        this.image = image;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}