package com.example.android_test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ThongTinAdapter extends RecyclerView.Adapter<ThongTinAdapter.ThongTinViewHoder> {

    private List<InfoStudent> mInfoStudent;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public ThongTinAdapter(List<InfoStudent> mInfoStudent) {
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
        holder.sdt.setText(infoStudent.getNamsinh());
        holder.xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInfoStudent.remove(holder.getAbsoluteAdapterPosition());
                notifyItemRemoved(holder.getAbsoluteAdapterPosition());

            }

        });
        holder.sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                ThongTin.Sua(position);
                notifyDataSetChanged();
//                Log.i("HTC", "onClick: " + position);
//                Intent intent = new Intent(v.getContext(), InfoListView.class); // Intent trong onBindViewHolder không dùng "this" mà dùng "v.getContext()"
//                InfoStudent dataSend = mInfoStudent.get(position);
//                if (dataSend != null) {
//                    intent.putExtra("data", (Serializable) dataSend);
//                    v.getContext().startActivity(intent);
//                }

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
        public TextView sua, xoa, username, sdt;
        ImageView avatar;

        public ThongTinViewHoder(@NonNull @NotNull View itemView) {
            super(itemView);
            swipeRevealLayout = itemView.findViewById(R.id.Swipe_Layout);
            sua = itemView.findViewById(R.id.btntvSua);
            xoa = itemView.findViewById(R.id.btntvXoa);
            username = itemView.findViewById(R.id.id_name);
            sdt = itemView.findViewById(R.id.id_namsinh);
            avatar = itemView.findViewById(R.id.id_avatar);

        }
    }
}
