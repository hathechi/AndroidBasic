package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import JavaClass.History;
import com.example.android_test.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {

    final LayoutInflater layoutInflater;
    private ArrayList<History> historyArrayList;
    private Context context1;

    public HistoryAdapter(Context context, ArrayList<History> historyArrayList) {
        this.context1 = context;
        this.historyArrayList = historyArrayList;
        this.layoutInflater = LayoutInflater.from(context);
    }

//    public HistoryAdapter(ImgViewTest context, ArrayList<History> historyArrayList) {
//    }

    @Override
    public int getCount() {
        return historyArrayList.size();
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_listview_nguoiyeu, null);
        }
        TextView time = convertView.findViewById(R.id.tvTimeNguoiYeu);

        TextView ketqua = convertView.findViewById(R.id.tvKetQuaNguoiYeu);

        ImageView hinh = convertView.findViewById(R.id.imvNguoiYeu);
        ImageView hinh2 = convertView.findViewById(R.id.imvNguoiYeu2);

        hinh.setImageResource(historyArrayList.get(position).getHinh());
        hinh2.setImageResource(historyArrayList.get(position).getHinh2());
//in thời gian
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM//yyyy");
        String strDate = dateFormat.format(historyArrayList.get(position).getTime());
        time.setText(strDate);
        String thongbao = "";

        thongbao += "BẠN CHỌN TÊN " + historyArrayList.get(position).getTendoan() + " VÀ ĐÃ CHỌN " + historyArrayList.get(position).getKetqua();

        ketqua.setText(thongbao);


        return convertView;
    }
}
