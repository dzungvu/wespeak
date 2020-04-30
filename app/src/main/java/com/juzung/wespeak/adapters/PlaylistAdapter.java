package com.juzung.wespeak.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.juzung.wespeak.R;
import com.juzung.wespeak.listeners.RecyclerViewItemClickListener;
import com.juzung.wespeak.models.PlaylistItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by VTDung on 5/1/20.
 */
public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHolder> {
    private Context context;
    private RecyclerViewItemClickListener itemClickListener;
    private ArrayList<PlaylistItem> listData;

    public PlaylistAdapter(Context context, RecyclerViewItemClickListener itemClickListener) {
        this.context = context;
        this.itemClickListener = itemClickListener;
        this.listData = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_playlist, parent, false);
        return new ViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlaylistItem item = listData.get(position);
        holder.tvTitle.setText(item.getTitle());
        try {
            holder.clContainer.setBackgroundColor(Color.parseColor(item.getBgColor()));
        } catch (Exception ex) {
            Log.e("PlaylistAdapter", "Color load failed");
        }
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public void setListData(List<PlaylistItem> listData) {
        this.listData.clear();
        this.listData.addAll(listData);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle;
        ConstraintLayout clContainer;

        public ViewHolder(@NonNull View itemView, RecyclerViewItemClickListener itemClickListener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            clContainer = itemView.findViewById(R.id.cl_container);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClickListener(view, getAdapterPosition());
        }
    }
}
