package com.example.android_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MayTinh extends AppCompatActivity {
    public EditText so1, so2, so3, so4;
    public TextView ketqua, ketqua2;

    public static boolean checkNguyenTo(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_may_tinh);
        so1 = findViewById(R.id.etSo1);
        so2 = findViewById(R.id.etSo2);
        so3 = findViewById(R.id.etSo3);
        so4 = findViewById(R.id.etSo4);

        ketqua = findViewById(R.id.tvKetQua_maytinh);
        ketqua2 = findViewById(R.id.tvKetQua2);

        //Onclick button
        Button btn_Cong = findViewById(R.id.btnCong);
        Button btn_Tru = findViewById(R.id.btnTru);
        Button btn_Nhan = findViewById(R.id.btnNhan);
        Button btn_Chia = findViewById(R.id.btnChia);
        Button btn_ChanLe = findViewById(R.id.id_chanle);
        Button btn_Bac1 = findViewById(R.id.id_pt1);
        Button btn_Bac2 = findViewById(R.id.id_pt2);
        Button btn_nguyento = findViewById(R.id.id_nguyenTo);

        btn_Cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = so1.getText().toString();
                String input2 = so2.getText().toString();
                if (input1.isEmpty() || input2.isEmpty()) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    Float so_1 = Float.parseFloat(so1.getText().toString());
                    Float so_2 = Float.parseFloat(so2.getText().toString());
                    ketqua.setText(so_1 + " + " + so_2 + " = " + (so_1 + so_2));
                    float ketqua = so_1 + so_2;
                    Intent intent = new Intent(MayTinh.this, TestBundle.class);
                    intent.putExtra("data", ketqua);
                    startActivity(intent);
                }
            }
        });
        btn_Tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((so1.getText().toString()).equalsIgnoreCase("") || (so2.getText().toString()).equalsIgnoreCase("")) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    Float so_1 = Float.parseFloat(so1.getText().toString());
                    Float so_2 = Float.parseFloat(so2.getText().toString());
                    ketqua.setText(so_1 + " - " + so_2 + " = " + (so_1 - so_2));
                    float ketqua = so_1 - so_2;
                    Intent intent = new Intent(MayTinh.this, TestBundle.class);
                    intent.putExtra("data", ketqua);
                    startActivity(intent);
                }
            }
        });
        btn_Nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((so1.getText().toString()).equalsIgnoreCase("") || (so2.getText().toString()).equalsIgnoreCase("")) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    Float so_1 = Float.parseFloat(so1.getText().toString());
                    Float so_2 = Float.parseFloat(so2.getText().toString());
                    ketqua.setText(so_1 + " * " + so_2 + " = " + (so_1 * so_2));
                    float ketqua = so_1 * so_2;
                    Intent intent = new Intent(MayTinh.this, TestBundle.class);
                    intent.putExtra("data", ketqua);
                    startActivity(intent);
                }
            }
        });
        btn_Chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((so1.getText().toString()).equalsIgnoreCase("") || (so2.getText().toString()).equalsIgnoreCase("")) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    Float so_1 = Float.parseFloat(so1.getText().toString());
                    Float so_2 = Float.parseFloat(so2.getText().toString());
                    ketqua.setText(so_1 + " / " + so_2 + " = " + (so_1 / so_2));
                    float ketqua = so_1 / so_2;
                    Intent intent = new Intent(MayTinh.this, TestBundle.class);
                    intent.putExtra("data", ketqua);
                    startActivity(intent);
                }
            }
        });
        btn_ChanLe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String check_So3 = so3.getText().toString();
                if (check_So3.isEmpty()) {
                    Toast.makeText(MayTinh.this, "KHÔNG BỎ TRỐNG DỮ LIỆU", Toast.LENGTH_SHORT).show();
                } else {
                    int So_3 = Integer.parseInt(check_So3);
                    if (So_3 % 2 == 0) {

                        Intent intent = new Intent(MayTinh.this, TestBundle.class);
                        intent.putExtra("ChanLe", true);
                        startActivity(intent);
                    } else {

                        Intent intent = new Intent(MayTinh.this, TestBundle.class);
                        intent.putExtra("ChanLe", false);
                        startActivity(intent);
                    }
                }

            }
        });
        btn_Bac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = so1.getText().toString();
                String input2 = so2.getText().toString();

                String PT1;
                if (input1.isEmpty() || input2.isEmpty()) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    Float so_1 = Float.parseFloat(so1.getText().toString());
                    Float so_2 = Float.parseFloat(so2.getText().toString());
                    if (so_1 == 0) {
                        if (so_2 == 0) {
                            PT1 = "PHƯƠNG TRÌNH CÓ VÔ SỐ NGHIỆM !";
                        } else {
                            PT1 = "PHƯƠNG TRÌNH  VÔ NGHIỆM !";
                        }
                    } else {
                        Float nghiem = -(so_2) / so_1;
                        PT1 = "PHƯƠNG TRÌNH CÓ NGHIỆM = " + nghiem;
                        Log.i("nghiem", PT1);
                    }

                    Intent intent = new Intent(MayTinh.this, TestBundle.class);
                    intent.putExtra("PT1", PT1);
                    startActivity(intent);
                }
            }
        });

        btn_Bac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = so1.getText().toString();
                String input2 = so2.getText().toString();
                String input3 = so3.getText().toString();
                String PT;
                if (input1.isEmpty() || input2.isEmpty() || input3.isEmpty()) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP Đủ DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    Float so_1 = Float.parseFloat(so1.getText().toString());
                    Float so_2 = Float.parseFloat(so2.getText().toString());
                    Float so_3 = Float.parseFloat(so3.getText().toString());

                    if (so_1 == 0) {
                        if (so_2 == 0) {
                            PT = "PHƯƠNG TRÌNH VÔ NGHIỆM !";
                        } else {
                            Float nghiem = -so_3 / so_2;
                            PT = "PHƯƠNG TRÌNH MỘT NGHIỆM PHÂN BIỆT = " + nghiem;
                        }

                    }
                    // tính delta
                    float delta = so_2 * so_2 - 4 * so_1 * so_3;
                    float x1;
                    float x2;
                    // tính nghiệm
                    if (delta > 0) {
                        x1 = (float) ((-so_2 + Math.sqrt(delta)) / (2 * so_1));
                        x2 = (float) ((-so_2 - Math.sqrt(delta)) / (2 * so_1));
                        PT = "PHƯƠNG TRÌNH CÓ 2 NGHIỆM X1 = " + x1 + " VÀ X2 = " + x2;
                    } else if (delta == 0) {
                        x1 = (-so_2 / (2 * so_1));
                        PT = "PHƯƠNG TRÌNH CÓ NGHIỆM KÉP = " + x1;
                    } else {
                        PT = "PHƯƠNG TRÌNH VÔ NGHIỆM !";
                    }

                    Intent intent = new Intent(MayTinh.this, TestBundle.class);
                    intent.putExtra("PT1", PT);
                    startActivity(intent);
                }
            }
        });

        btn_nguyento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = so1.getText().toString();
                String input2 = so2.getText().toString();

                if (input1.isEmpty() || input2.isEmpty()) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    int so_1 = Integer.parseInt(so1.getText().toString());
                    int so_2 = Integer.parseInt(so2.getText().toString());
                    ListView listView = findViewById(R.id.id_listView_ketqua);
                    ArrayList<Integer> SoNT = new ArrayList<>();

                    for (int i = so_1; i <= so_2; i++) {
                        if (checkNguyenTo(i)) {
                            SoNT.add(i);
                        }
                    }
                    if (SoNT != null) {
                        Intent intent = new Intent(MayTinh.this, TestBundle.class);
                        intent.putExtra("NT", SoNT);
                        startActivity(intent);
                    }
                }
            }
        });
        Button btnXoa = findViewById(R.id.btnXoa);
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                so1.setText("");
                so2.setText("");
                so3.setText("");
                ketqua.setText("");
            }
        });
        Button btnChialaydu;
        btnChialaydu = findViewById(R.id.id_chialaydu);
        btnChialaydu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = so1.getText().toString();
                String input2 = so2.getText().toString();
                if (input1.isEmpty() || input2.isEmpty()) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    int so_1 = Integer.parseInt(so1.getText().toString());
                    int so_2 = Integer.parseInt(so2.getText().toString());
                    int layDu = so_1 % so_2;
                    ketqua.setText("Chia lấy dư = " + layDu);
                }
            }
        });
        Button btnKiemTra;
        btnKiemTra = findViewById(R.id.id_ktchanle);
        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = so1.getText().toString();
                String input2 = so2.getText().toString();


                if (input1.isEmpty() || input2.isEmpty()) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    int so_1 = Integer.parseInt(so1.getText().toString());
                    int so_2 = Integer.parseInt(so2.getText().toString());
                    if (so_1 % 2 == 0 && so_2 % 2 == 0) {
                        ketqua.setText(so_1 + " và " + so_2 + " Là số chẵn ");
                    } else if (so_1 % 2 != 0 && so_2 % 2 != 0) {
                        ketqua.setText(so_1 + " và " + so_2 + " Là số lẻ ");


                    } else {
                        if (so_1 % 2 == 0) {
                            ketqua.setText(so_1 + " Là số chẵn ");
                            ketqua2.setText(so_2 + " Là số lẻ ");
                        } else {
                            ketqua.setText(so_1 + " Là số lẻ ");
                            ketqua2.setText(so_2 + " Là số chẵn ");
                        }
                        if (so_2 % 2 == 0) {
                            ketqua.setText(so_1 + " Là số lẻ ");
                            ketqua2.setText(so_2 + " Là số chẵn ");


                        } else {
                            ketqua.setText(so_1 + " Là số chẵn ");
                            ketqua2.setText(so_2 + " Là số lẻ ");

                        }
                    }

                }
            }
        });
        Button btnSosanh;
        btnSosanh = findViewById(R.id.id_sosanh);
        btnSosanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = so1.getText().toString();
                String input2 = so2.getText().toString();


                if (input1.isEmpty() || input2.isEmpty()) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    int so_1 = Integer.parseInt(so1.getText().toString());
                    int so_2 = Integer.parseInt(so2.getText().toString());
                    if (so_1 > so_2) {
                        ketqua.setText(so_1 + " lớn hơn  " + so_2);
                    } else if (so_1 < so_2) {
                        ketqua.setText(so_1 + " bé hơn  " + so_2);
                    } else {
                        ketqua.setText(so_1 + " bằng   " + so_2);
                    }
                }
            }
        });

        Button btnktThang;
        btnktThang = findViewById(R.id.id_ktThang);
        btnktThang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = so1.getText().toString();
                String input2 = so2.getText().toString();


                if (input1.isEmpty() || input2.isEmpty()) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    int thang = Integer.parseInt(so1.getText().toString());
                    int nam = Integer.parseInt(so2.getText().toString());
                    if (checkYear(nam)) {
                        if (thang == 2) {
                            ketqua.setText("29 ngày ");
                        }

                    } else {
                        ketqua.setText("28 ngày ");
                    }


                    if (thang == 1 || thang == 3 || thang == 5 || thang == 8 || thang == 10 || thang == 12) {
                        ketqua.setText("31 ngày ");
                    } else if (thang == 4 || thang == 6 || thang == 9 || thang == 11) {
                        ketqua.setText("30 ngày ");
                    }
                }

            }
        });
        Button btnTongdayso;
        btnTongdayso = findViewById(R.id.id_Tongdayso);
        btnTongdayso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = so4.getText().toString();
                if (input1.isEmpty()) {
                    Toast.makeText(MayTinh.this, "BẠN CHƯA NHẬP DỮ LIỆU !", Toast.LENGTH_SHORT).show();
                } else {
                    int Tong = 0;
                    String[] words = input1.split(",");
                    for (String a : words) {
                        Log.i("cc", a);
                        Tong = Tong + (Integer.parseInt(a));
                        Log.i("cc", String.valueOf(Tong));

                    }
                    Float Dem = Float.valueOf((words.length));
                    Float TBCong = Float.valueOf(Tong / Dem);
                    Log.i("cc", String.valueOf(TBCong));
                    ketqua.setText("Tổng : " + Tong);
                    ketqua2.setText("TBC : " + TBCong);
                }
            }
        });
    }

    boolean checkYear(int year) {
// Nếu số năm chia hết cho 400,
// đó là 1 năm nhuận
        if (year % 400 == 0)
            return true;
// Nếu số năm chia hết cho 4 và không chia hết cho 100,
// đó không là 1 năm nhuận
        if (year % 4 == 0 && year % 100 != 0)
            return true;
// trường hợp còn lại
// không phải năm nhuận
        return false;
    }
}