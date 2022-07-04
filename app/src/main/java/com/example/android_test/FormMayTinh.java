package com.example.android_test;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FormMayTinh extends AppCompatActivity {
    Boolean cong = false, tru = false, nhan = false, chia = false,chialaydu=false;
    TextView btnBang, btnCong, btnTru, btnNhan, btnChia,btnChiaLayDu;
    Float input1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_may_tinh);
        getSupportActionBar().hide();

        TextView ketqua = findViewById(R.id.tvKetQua_maytinh);
        TextView btnC = findViewById(R.id.tvMayTinh_C);
        TextView btn1 = findViewById(R.id.tvMayTinh_1);
        TextView btn0 = findViewById(R.id.tvMayTinh_0);
        TextView btn2 = findViewById(R.id.tvMayTinh_2);
        TextView btn3 = findViewById(R.id.tvMayTinh_3);
        TextView btn4 = findViewById(R.id.tvMayTinh_4);
        TextView btn5 = findViewById(R.id.tvMayTinh_5);
        TextView btn6 = findViewById(R.id.tvMayTinh_6);
        TextView btn7 = findViewById(R.id.tvMayTinh_7);
        TextView btn8 = findViewById(R.id.tvMayTinh_8);
        TextView btn9 = findViewById(R.id.tvMayTinh_9);
        btnBang = findViewById(R.id.tvMayTinh_bang);
        btnCong = findViewById(R.id.tvMayTinh_cong);
        btnTru = findViewById(R.id.tvMayTinh_tru);
        btnNhan = findViewById(R.id.tvMayTinh_nhan);
        btnChia = findViewById(R.id.tvMayTinh_chia);

         btnChiaLayDu = findViewById(R.id.tvMayTinh_chialaydu);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText(ketqua.getText() + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText(ketqua.getText() + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText(ketqua.getText() + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText(ketqua.getText() + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText(ketqua.getText()+ "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText(ketqua.getText() + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText(ketqua.getText() + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText(ketqua.getText() + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText(ketqua.getText() + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText(ketqua.getText() + "9");
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ketqua.setText("");
                // Mở lại các nút bấm
                btnCong.setEnabled(true);
                btnTru.setEnabled(true);
                btnNhan.setEnabled(true);
                btnChia.setEnabled(true);
                //Đổi lại màu cũ cho nút
                btnCong.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                btnTru.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                btnNhan.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                btnChia.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                btnBang.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                btnChiaLayDu.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
            }
        });
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1 = Float.parseFloat(ketqua.getText().toString()); // lấy giá trị trên màn hình
                ketqua.setText("");
                colorChange(btnCong); // thay đổi màu nút bấm
                ButtonFalse(); // ngăn cho nút khác được bấm
                cong = true; // chuyển thành true đẻ khi ấn nút = sẽ tính toán
                tru = false;
                nhan = false;
                chia = false;
                chialaydu =false;
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1 = Float.parseFloat(ketqua.getText().toString());
                ketqua.setText("");
                colorChange(btnTru);
                ButtonFalse();
                cong = false;
                tru = true;
                nhan = false;
                chia = false;
                chialaydu =false;
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1 = Float.parseFloat(ketqua.getText().toString());
                ketqua.setText("");
                colorChange(btnNhan);
                ButtonFalse();
                cong = false;
                tru = false;
                nhan = true;
                chia = false;
                chialaydu =false;
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1 = Float.parseFloat(ketqua.getText().toString());
                ketqua.setText("");
                colorChange(btnChia);
                ButtonFalse();
                cong = false;
                tru = false;
                nhan = false;
                chia = true;
                chialaydu =false;
            }
        });
         btnChiaLayDu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input1 = Float.parseFloat(ketqua.getText().toString());
                ketqua.setText("");
                colorChange(btnChiaLayDu);
                ButtonFalse();
                cong = false;
                tru = false;
                nhan = false;
                chia = false;
                chialaydu =true;
            }
        });
        btnBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float input2 = Float.parseFloat(ketqua.getText().toString());
                ketqua.setText("");
                colorChange(btnBang);
                if (cong) {
                    Float result = input1 + input2;
                    ketqua.setText(result + "");

                    btnCong.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                }else if(tru){
                    Float result = input1 - input2;
                    ketqua.setText(result + "");

                    btnTru.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                }else if(nhan){
                    Float result = input1 * input2;
                    ketqua.setText(result + "");

                    btnNhan.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                }else if(chia){
                    Float result = input1 / input2;
                    ketqua.setText(result + "");

                    btnChia.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                }else if(chialaydu){
                    Float result = (input1 % input2);
                    ketqua.setText(result + "");

                    btnChiaLayDu.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                }
            }
        });
    }

    public void ButtonFalse() {
        btnCong.setEnabled(false);
        btnTru.setEnabled(false);
        btnNhan.setEnabled(false);
        btnChia.setEnabled(false);
        btnChiaLayDu.setEnabled(false);
    }

    public void colorChange(TextView btn) {
        btn.setBackgroundColor(getColor(R.color.teal_200));
    }
}