package com.example.android_test;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import Adapter.HistoryAdapter;
import JavaClass.History;

public class ImgViewTest extends AppCompatActivity {


    int[] hinh = new int[]{R.drawable.i5, R.drawable.i8, R.drawable.i26, R.drawable.i42, R.drawable.i27, R.drawable.i28, R.drawable.i34};
    String chon;
    int so;
    String text;

    //    int randomInt;
    private ImageView imageView, nhanCuoi;
    private TextView love;
    private Spinner spinner;
    private ListView listView1;
    //    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayList<History> historyArrayList = new ArrayList<>();
    private HistoryAdapter historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_view_test);
        getSupportActionBar().hide();
        imageView = findViewById(R.id.imageView);
        love = findViewById(R.id.tvLove);
        nhanCuoi = findViewById(R.id.imvnhancuoi);
        listView1 = findViewById(R.id.list_test);


        Handler handler = new Handler();
        nhanCuoi.setVisibility(View.INVISIBLE);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nhanCuoi.setVisibility(View.INVISIBLE);
                imageView.setImageResource(hinh[4]);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageResource(hinh[2]);
                        love.setText("AI SẼ MAY MẮN CÓ ĐƯỢC MÌNH ĐÂY ???");
                    }
                }, 300);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageResource(hinh[1]);
                    }
                }, 600);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageResource(hinh[3]);
                    }
                }, 900);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageResource(hinh[0]);
                    }
                }, 1200);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageResource(hinh[5]);
                        love.setText("VÀ ĐÓ LÀ ....... ");
                    }
                }, 1500);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageResource(hinh[6]);
                    }
                }, 1800);
                handler.postDelayed(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void run() {
                        loadHinh();
                        setAdapter();
                        nhanCuoi.setVisibility(View.VISIBLE);
                    }
                }, 3300);
            }
        });
        nhanCuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reFresh();
            }
        });


        /////////////    SPINNER   ///////////
        spinner = findViewById(R.id.spinner);
        String[] spin = {
                "MINH", "UYÊN", "TÚ", "HỒNG", "OANH", "QUYÊN", "MY"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                spin);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chon = spinner.getSelectedItem().toString();
                so = position;
                Log.i("htc", so + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
// onclick listview
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ImgViewTest.this, InforListviewNguoiYeu.class);
                intent.putExtra("dataNguoiYeu", (Serializable) historyArrayList.get(position));
                startActivity(intent);
            }
        });

    }

    private void reFresh() {
        imageView.setImageResource(R.drawable.traitim);
        love.setText("THỬ CHỌN TÊN NGƯỜI YÊU RỒI ẤN VÀO TRÁI TIM ĐỂ TÌM NGƯỜI YÊU CỦA BẠN !");
        nhanCuoi.setVisibility(View.INVISIBLE);
    }

    private void loadHinh() {
        double randomDouble = Math.random();
        randomDouble = randomDouble * 7;
        int randomInt = (int) randomDouble;
//        Log.i("HTC", randomInt + "");

        //DỰ ĐOÁN
        if (so == randomInt) {
            love.setText("CHÍNH LÀ CÔ GÁI NÀY =)) BẠN CHỌN ĐÚNG RỒI :))");
            text = "ĐÚNG";
        } else {

            love.setText("CHÍNH LÀ CÔ GÁI NÀY =)) NHƯNG BẠN CHỌN SAI MẤT RỒI :(");
            text = "SAI";
        }

        //set hình
        for (int i = 0; i < hinh.length; i++) {
            if (randomInt == i) {
                imageView.setImageResource(hinh[i]);

                // add dữ liệu vào arraylist
                Date date2 = new Date(System.currentTimeMillis());
                historyArrayList.add(new History(hinh[so], hinh[i], date2, chon, text));
            }
        }
        Log.i("HTC", so + " " + randomInt + " " + chon);

    }


    private void setAdapter() {


        if (historyArrayList == null) {
            return;
        } else {
            historyAdapter = new HistoryAdapter(ImgViewTest.this, historyArrayList);
            listView1.setAdapter(historyAdapter);
            historyAdapter.notifyDataSetChanged();
        }

    }

}