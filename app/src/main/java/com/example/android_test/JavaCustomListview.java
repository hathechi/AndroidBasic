package com.example.android_test;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class JavaCustomListview extends BaseAdapter {
    //    final Context context;
    final ThongTin context;
    final ArrayList<InfoStudent> list;
    final LayoutInflater layoutInflater;

    public JavaCustomListview(ThongTin context, ArrayList<InfoStudent> list) {
        this.context = context;
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_listview, null);
        }
        TextView Ten = convertView.findViewById(R.id.id_name);
        ImageView avatar = convertView.findViewById(R.id.id_avatar);
        TextView namsinh = convertView.findViewById(R.id.id_namsinh);
        TextView gioitinh = convertView.findViewById(R.id.id_gioitinh);
        ImageButton btnSua = convertView.findViewById(R.id.ibtn_Sua);
        ImageButton btnXoa = convertView.findViewById(R.id.ibtn_Xoa);
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.Sua(position);
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.Xoa(position);
            }
        });
        Ten.setText(list.get(position).getName());
        avatar.setImageResource(list.get(position).getImage());
        namsinh.setText(list.get(position).getNamsinh());
        gioitinh.setText(list.get(position).getGioitinh());

        return convertView;
    }
}
