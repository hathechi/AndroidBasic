package com.example.android_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;

public class ThongTin extends AppCompatActivity {
    EditText Name, Sdt;
    Button btnThem;
    ArrayList<InfoStudent> arrayList = new ArrayList<InfoStudent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);

        arrayList.add(new InfoStudent("Đại Nghĩa", R.drawable.emone, "0234455677"));
        arrayList.add(new InfoStudent("Trung Quân", R.drawable.emtwo, "0345666777"));
        arrayList.add(new InfoStudent("Hữu Nam", R.drawable.emthree, "0334564666"));
        arrayList.add(new InfoStudent("Văn Việt", R.drawable.emone, "0334564666"));

        ListView list = findViewById(R.id.id_listview);

        JavaCustomListview custom = new JavaCustomListview(ThongTin.this, arrayList);
        list.setAdapter(custom);

        Name = findViewById(R.id.etName_thongtin);
        Sdt = findViewById(R.id.etSdt_thongtin);
        btnThem = findViewById(R.id.btnAdd_thongtin);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = Name.getText().toString();
                String sdt = Sdt.getText().toString();
                if (name.isEmpty() || sdt.isEmpty()) {
                    Toast.makeText(ThongTin.this, "NHẬP ĐỦ DỮ LIỆU!", Toast.LENGTH_SHORT).show();
                } else {
                    arrayList.add(new InfoStudent(name, R.drawable.emtwo, sdt));

                    custom.notifyDataSetChanged();
                }
            }
        });


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