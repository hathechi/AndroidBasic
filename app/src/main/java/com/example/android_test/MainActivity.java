package com.example.android_test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public EditText username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ModelData.listUsers.add(new ListUser("admin", "123", "abc")); //tạo dữ liệu ban đầu cho array user

//Ẩn thanh bar
        getSupportActionBar().hide();

        username = findViewById(R.id.etUserName);
        password = findViewById(R.id.etPassword);
        TextView error = findViewById(R.id.tvError);
        Button listview = findViewById(R.id.btn_listview);
        listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, ThongTin.class);
                startActivity(intent1);
            }
        });
        Button signup = findViewById(R.id.btnRegister);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }


    public void btnLogin_onclick(View view) {
        TextView error = findViewById(R.id.tvError);

        String user = username.getText().toString();
        String pass = password.getText().toString();

        //tạo Handler làm khoảng delay cho sự kiện
        Handler handler = new Handler();

        if (user.equals("") || pass.equals("")) {
            error.setText("KHÔNG BỎ TRỐNG DỮ LIỆU !");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    error.setText("");
                }
            },1500);
//            Toast.makeText(this, "KHÔNG BỎ TRỐNG DỮ LIỆU !", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = 0; i < ModelData.listUsers.size(); i++) {
                if (user.equals(ModelData.listUsers.get(i).getUser()) && pass.equals(ModelData.listUsers.get(i).getPassword())) {
                    Intent intent1 = new Intent(this, MayTinh.class);
                    startActivity(intent1);

                } else {
                    error.setText("SAI TÀI KHOẢN HOẶC MẬT KHẨU!");
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            error.setText("");
                        }
                    },1500);
                }
            }
        }
    }
}