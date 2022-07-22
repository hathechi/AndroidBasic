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
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
import java.util.List;

import Adapter.HistoryAdapter;
import DAO.HistoryDAO;
import JavaClass.History;

public class ImgViewTestNguoiYeu extends AppCompatActivity {
    int[] hinh = new int[]{R.drawable.i5, R.drawable.i8, R.drawable.i26, R.drawable.i42, R.drawable.i27, R.drawable.i28, R.drawable.i34};
    String chon;
    int so;
    String text;
    private HistoryDAO historyDAO;
    private List<History> list;
    //    int randomInt;
    private ImageView imageView, nhanCuoi;
    private TextView love;
    private Spinner spinner;
    private ListView listView1;
    //    private ArrayList<String> arrayList = new ArrayList<>();
//    private ArrayList<History> historyArrayList = new ArrayList<>();
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

//chạy SQLite
        HistoryDAO DAO = new HistoryDAO(getBaseContext());

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
                list = historyDAO.getAll();
                Intent intent = new Intent(ImgViewTestNguoiYeu.this, InforListviewNguoiYeu.class);
                intent.putExtra("dataNguoiYeu", list.get(position));

                startActivity(intent);
            }
        });

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        historyDAO = new HistoryDAO(ImgViewTestNguoiYeu.this);
//        List<History> updateList = historyDAO.getAll();
//        list.clear();
//        for (History item : updateList) {
//            list.add(item);
//        }
//        historyAdapter.notifyDataSetChanged();
//
//    }

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
//                historyArrayList.add(new History(i, hinh[so], hinh[i], date2, chon, text));

                historyDAO = new HistoryDAO(this);
                History history = new History();
//                history.setId(i);
                history.setHinh(hinh[so]);
                history.setHinh2(hinh[i]);
                history.setTime(date2);
                history.setTendoan(chon);
                history.setKetqua(text);
                historyDAO.insertHistory(history);


            }
        }
        Log.i("HTC", so + " " + randomInt + " " + chon);

    }


    private void setAdapter() {
        historyDAO = new HistoryDAO(this);
        list = historyDAO.getAll();
        for (History a : list) {
            Log.i("HTC", a.getId() + " " + a.getHinh() + a.getKetqua() + a.getTime() + a.getTendoan());
        }


//        if (historyArrayList == null) {
//            return;
//        } else {
//            historyAdapter = new HistoryAdapter(ImgViewTestNguoiYeu.this, historyArrayList);
//            listView1.setAdapter(historyAdapter);
//            historyAdapter.notifyDataSetChanged();
//        }

        if (list == null) {
            return;
        } else {
            historyAdapter = new HistoryAdapter(this, list);
            listView1.setAdapter(historyAdapter);
            historyAdapter.notifyDataSetChanged();

        }

    }

    public void DeleteList(String i) {
        historyDAO = new HistoryDAO(this);

        list = historyDAO.getAll();

        int id = list.get(Integer.parseInt(i)).getId();

        Log.i("HTC", "id = " + id);
        historyDAO.delete(String.valueOf(id));
//set lại dữ liệu từ database lên listview
        setChanged();
    }

    public void setChanged() {
        List<History> updateList = historyDAO.getAll();
        list.clear();
        for (History item : updateList) {
            list.add(item);
        }

        historyAdapter = new HistoryAdapter(this, list);
        listView1.setAdapter(historyAdapter);
        historyAdapter.notifyDataSetChanged();
    }
}