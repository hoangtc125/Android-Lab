package com.example.email;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    List<mailModel> items;
    ItemClickInterface itemClickInterface;

    public RVAdapter(Activity context, List<mailModel> items, ItemClickInterface clickInterface) {
        this.context = context;
        this.items = items;
        this.itemClickInterface = clickInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.emal_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        mailModel item = items.get(position);
        ((MyViewHolder)holder).title.setText(item.getTitle());
        ((MyViewHolder)holder).avatar.setText(item.getAvatar());
        ((MyViewHolder)holder).date.setText(item.getDate());
        ((MyViewHolder)holder).content.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        Button avatar;
        TextView title, date, content;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            avatar = itemView.findViewById(R.id.avatar);
            title = itemView.findViewById(R.id.tit);
            date = itemView.findViewById(R.id.date);
            content = itemView.findViewById(R.id.content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if (itemClickInterface != null)
                        itemClickInterface.OnItemClick(pos);
                }
            });
        }
    }

    public interface ItemClickInterface {
        void OnItemClick(int position);
    }
}
