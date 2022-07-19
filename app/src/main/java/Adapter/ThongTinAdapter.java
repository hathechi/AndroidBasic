package Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.android_test.InfoListView;
import JavaClass.InfoStudent;
import com.example.android_test.R;
import com.example.android_test.ThongTin;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

public class ThongTinAdapter extends RecyclerView.Adapter<ThongTinAdapter.ThongTinViewHoder> {
    // tạo biến môi trường ở đây để gọi hàm ở ativity khác
    private ThongTin thongTin;
    private List<InfoStudent> mInfoStudent;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public ThongTinAdapter(ThongTin thongTin, List<InfoStudent> mInfoStudent) {
        this.thongTin = thongTin;
        this.mInfoStudent = mInfoStudent;
    }

    @NonNull
    @NotNull
    @Override
    public ThongTinViewHoder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_listview_swipe, parent, false);
        return new ThongTinViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ThongTinViewHoder holder, int position) {
        InfoStudent infoStudent = mInfoStudent.get(position);
        if (infoStudent == null) {
            return;
        }
        viewBinderHelper.bind(holder.swipeRevealLayout, infoStudent.getName());
        holder.username.setText(infoStudent.getName());
        holder.avatar.setImageResource(infoStudent.getImage());
        holder.namsinh.setText(infoStudent.getNamsinh());
        holder.gioitinh.setText(infoStudent.getGioitinh());
        holder.xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thongTin.Xoa(position);
//                mInfoStudent.remove(holder.getAbsoluteAdapterPosition());
//                notifyItemRemoved(holder.getAbsoluteAdapterPosition());
            }

        });

        holder.sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thongTin.Sua(position);
            }
        });
// setOnclick item recyclerview 1. đặt id cho layout được click 2. tạo biến toàn cục ở dưới và ánh xạ, xong setOnlick ở đây
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thongTin, InfoListView.class); // Intent trong onBindViewHolder không dùng "this" mà dùng "v.getContext()"
                InfoStudent dataSend = mInfoStudent.get(position);
                if (dataSend != null) {
                    intent.putExtra("data", (Serializable) dataSend);
                    v.getContext().startActivity(intent); // dùng v.getContext() hoặc thongTin trong trường hợp này đều được
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mInfoStudent != null) {
            return mInfoStudent.size();
        }
        return 0;
    }

    public class ThongTinViewHoder extends RecyclerView.ViewHolder {
        public SwipeRevealLayout swipeRevealLayout;
        public LinearLayout linearLayout;
        public TextView sua, xoa, username, gioitinh, namsinh;
        ImageView avatar;

        public ThongTinViewHoder(@NonNull @NotNull View itemView) {
            super(itemView);

            swipeRevealLayout = itemView.findViewById(R.id.Swipe_Layout);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.click_item);
            sua = itemView.findViewById(R.id.btntvSua);
            xoa = itemView.findViewById(R.id.btntvXoa);
            username = itemView.findViewById(R.id.id_name);
            gioitinh = itemView.findViewById(R.id.id_gioitinh);
            namsinh = itemView.findViewById(R.id.id_namsinh);
            avatar = itemView.findViewById(R.id.id_avatar);


        }
    }
}
