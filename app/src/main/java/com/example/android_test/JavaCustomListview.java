package com.example.android_test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class JavaCustomListview extends BaseAdapter {
    final Context context;
    final ArrayList<InfoStudent> list;
    final LayoutInflater layoutInflater;

    public JavaCustomListview(Context context, ArrayList<InfoStudent> list) {
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
        TextView textView = convertView.findViewById(R.id.id_name);
        ImageView imageView = convertView.findViewById(R.id.id_avatar);
        TextView sdt = convertView.findViewById(R.id.id_sdt);
        textView.setText(list.get(position).getName());
        imageView.setImageResource(list.get(position).getImage());
        sdt.setText(list.get(position).getPhone());
        return convertView;
    }
}
