package com.example.android_test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity implements View.OnClickListener {


    private Button btn;
    private EditText User, Pass, CFpass, Email;
    private TextView show_err;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        User = findViewById(R.id.etUsername);
        Pass = findViewById(R.id.etPass);
        CFpass = findViewById(R.id.etCFpass);
        Email = findViewById(R.id.etEmail);
        show_err = findViewById(R.id.tvError_regis);


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
                if (BatLoiSua()) {
                    ModelData.listUsers.add(new ListUser(username, pass, email));
                    Toast.makeText(this, "ĐĂNG KÍ THÀNH CÔNG !", Toast.LENGTH_SHORT).show();
                    for (ListUser a : ModelData.listUsers) {
                        Log.i("HTC", a.getUser());
                    }
                }
                break;
        }
    }

    boolean BatLoiSua() {
        //Bat loi du lieu
        String username = User.getText().toString();
        String pass = Pass.getText().toString();
        String cfpass = CFpass.getText().toString();
        String email = Email.getText().toString();

        if (username.isEmpty() || pass.isEmpty() || cfpass.isEmpty() || email.isEmpty()) {
            show_err.setText("KHÔNG BỎ TRỐNG DỮ LIỆU !");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    show_err.setText("");
                }
            }, 1500);
//            Toast.makeText(this, "NHẬP ĐỦ TRƯỜNG DỮ LIỆU !!", Toast.LENGTH_LONG).show();
            return false;
        }

        String regexTen = "[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{0,50}";
        if (!username.matches(regexTen)) {
            show_err.setText("CHỈ NHẬP TÊN BẰNG CHỮ !");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    show_err.setText("");
                }
            }, 1500);
            return false;
        }
        if (!pass.equalsIgnoreCase(cfpass)) {
            show_err.setText("HAI PASSWORD PHẢI TRÙNG NHAU!");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    show_err.setText("");
                }
            }, 1500);
            return false;
        }
        String regexEmail = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";
        if (!email.matches(regexEmail)) {
            show_err.setText("NHẬP ĐÚNG ĐỊNH DẠNG EMAIL !");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    show_err.setText("");
                }
            }, 1500);
            return false;
        }
        return true;
    }

}

