package com.example.myfirstapplication.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfirstapplication.R;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {

    private final Context context;
    private final List<Cat> catList;

    public CatAdapter(Context context, List<Cat> catList) {
        this.context = context;
        this.catList = catList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cat cat = catList.get(position);
        holder.textViewCatName.setText(cat.getName());
        holder.imageViewCat.setImageResource(cat.getImage());
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewCat;
        TextView textViewCatName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewCat = itemView.findViewById(R.id.imageViewCat);
            textViewCatName = itemView.findViewById(R.id.textViewCatName);
        }
    }

}
