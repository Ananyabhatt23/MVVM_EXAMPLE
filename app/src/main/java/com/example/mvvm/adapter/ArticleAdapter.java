package com.example.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvm.R;
import com.example.mvvm.model.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private  final Context context;
    ArrayList<Article> articleArrayList;

    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Article article = articleArrayList.get(position);
        holder.tvtitle.setText(article.getTitle());
        Glide.with(context).load(article.getUrlToImage()).into(holder.cover_img);
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        private  final ImageView cover_img;
        private  final TextView tvtitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cover_img = itemView.findViewById(R.id.cover_img);
            tvtitle = itemView.findViewById(R.id.tvTitle);

        }
    }
}
