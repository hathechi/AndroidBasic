package com.example.android_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity implements View.OnClickListener {


    private Button btn;
    private EditText User, Pass, CFpass, Email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        User = findViewById(R.id.etUsername);
        Pass = findViewById(R.id.etPass);
        CFpass = findViewById(R.id.etCFpass);
        Email = findViewById(R.id.etEmail);




        btn = findViewById(R.id.btnRegister_regis);
        btn.setOnClickListener(this);

        Button btnRegister = findViewById(R.id.btnLogin_regis);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Home.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister_regis:
                String username = User.getText().toString();
                String pass = Pass.getText().toString();
                String cfpass = CFpass.getText().toString();
                String email = Email.getText().toString();


                if (username.isEmpty() || pass.isEmpty() || cfpass.isEmpty() || email.isEmpty()) {
                    Toast.makeText(v.getContext(), "NHẬP ĐỦ TRƯỜNG DỮ LIỆU !!", Toast.LENGTH_LONG).show();
                } else {
                    ModelData.listUsers.add(new ListUser(username, pass, email));
                    Toast.makeText(this, "ĐĂNG KÍ THÀNH CÔNG !", Toast.LENGTH_SHORT).show();
                    for (ListUser a : ModelData.listUsers) {
                        Log.i("HTC", a.getUser());
                    }
                    break;
                }
        }
    }
}

