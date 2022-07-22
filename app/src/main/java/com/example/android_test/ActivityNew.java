package com.example.android_test;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class ActivityNew extends AppCompatActivity {
    private static final int MY_PERMISSION_REQUEST_CODE_CALL_PHONE = 555;
    private static final String LOG_TAG = "AndroidExample";
    RadioButton rbJS, rbJava, rbC;
    Switch aSwitch;
    CheckBox box1, box2;
    ArrayList<String> arrayList = new ArrayList<>();
    TextView checked;
    LinearLayout linearLayout;
    EditText etNameweb, etSdt;
    Button btnChuyentrang, btnCall;
    private int MY_PERMISSIONS_REQUEST_CALL_PHONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        getSupportActionBar().hide();




        rbC = findViewById(R.id.rbCplusplus);
        rbJava = findViewById(R.id.rbJava);
        rbJS = findViewById(R.id.rbJS);
        box1 = findViewById(R.id.checkBox);
        box2 = findViewById(R.id.checkBox2);
        checked = findViewById(R.id.tvChecked_test);
        linearLayout = findViewById(R.id.layoutNightmode);
        etNameweb = findViewById(R.id.etSdt);
        etSdt = findViewById(R.id.etSdt);
        btnChuyentrang = findViewById(R.id.btn_new);
        btnCall = findViewById(R.id.btn_call);
        rbJS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ActivityNew.this, "JS", Toast.LENGTH_SHORT).show();
//                rbC.setChecked(false);
//                rbJava.setChecked(false);
            }
        });
        rbJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ActivityNew.this, "Java", Toast.LENGTH_SHORT).show();
//                rbC.setChecked(false);
//                rbJS.setChecked(false);
            }
        });
        rbC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ActivityNew.this, "C++", Toast.LENGTH_SHORT).show();
//                rbJS.setChecked(false);
//                rbJava.setChecked(false);
            }
        });


        box1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    arrayList.add(box1.getText().toString());
                } else {
                    arrayList.remove(box1.getText().toString());
                }
            }
        });
        box2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    arrayList.add(box2.getText().toString());
                } else {
                    arrayList.remove(box2.getText().toString());
                }

            }
        });

        aSwitch = findViewById(R.id.switchChon);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (aSwitch.isChecked()) {
                    if (arrayList != null) {
                        String text = "";
                        for (String a : arrayList) {
                            text += a + " , ";
                        }
                        checked.setText(text);
                    }
                    linearLayout.setBackground(getDrawable(R.drawable.br2));
//                    linearLayout.setBackgroundColor(getColor(R.color.purple_200));
                } else {
                    linearLayout.setBackgroundColor(getColor(R.color.white));

                }
            }
        });

        btnChuyentrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nameweb = etNameweb.getText().toString();
                if (Nameweb.isEmpty()) {
                    Toast.makeText(ActivityNew.this, "aa", Toast.LENGTH_SHORT).show();

                } else if (Nameweb.contains("https://")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Nameweb));
                    startActivity(intent);
                }

            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                askPermissionAndCall();
                String sdt = etSdt.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + sdt));
                if (ActivityCompat.checkSelfPermission(ActivityNew.this,android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(ActivityNew.this,
                            android.Manifest.permission.CALL_PHONE)) {
                    } else {
                        ActivityCompat.requestPermissions(ActivityNew.this,
                                new String[]{android.Manifest.permission.CALL_PHONE},
                                MY_PERMISSIONS_REQUEST_CALL_PHONE);
                    }
                }
                startActivity(callIntent);
            }
            
        });
    }


}