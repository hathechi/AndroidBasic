package com.example.android_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register2 extends AppCompatActivity {
TextView user,pass,cfpass,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        Intent intent = getIntent();
        String Array[]=intent.getStringArrayExtra("data");
        user =findViewById(R.id.id_user_regis);
        pass =findViewById(R.id.id_pass_regis);
        cfpass =findViewById(R.id.id_cfpass_regis);
        email =findViewById(R.id.id_email_regis);
        user.setText("USER : "+Array[0]);
        pass.setText("PASSWORD : " + Array[1]);
        cfpass.setText("CF PASSWORD : " + Array[2]);
        email.setText("EMAIL : " + Array[3]);
        Button button = findViewById(R.id.button_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}