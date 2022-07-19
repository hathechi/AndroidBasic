package com.example.android_test;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ActivityNew extends AppCompatActivity {
    RadioButton rbJS, rbJava, rbC;
    Switch aSwitch;
    CheckBox box1, box2;
    ArrayList<String> arrayList = new ArrayList<>();
    TextView checked;
    LinearLayout linearLayout;

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
        linearLayout =findViewById(R.id.layoutNightmode);
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
    }
}