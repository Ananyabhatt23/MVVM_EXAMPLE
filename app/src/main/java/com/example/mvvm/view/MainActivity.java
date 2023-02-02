package com.example.mvvm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvm.R;
import com.example.mvvm.adapter.ArticleAdapter;
import com.example.mvvm.model.Article;
import com.example.mvvm.view_model.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  static  final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recycler_view;
    private ProgressBar progress_bar;
    private LinearLayoutManager layoutManager;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    ArticleViewModel articleViewModel;
    private ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.activity_main);

        init();

        getArticles();
    }

    private void getArticles() {
        articleViewModel.getBashboardNewsLiveData().observe(this,articleResponse -> {
            if(articleResponse!=null && articleResponse.getArticles()!=null &&
            !articleResponse.getArticles().isEmpty()){
                progress_bar.setVisibility(View.GONE);
                List<Article> articleList = articleResponse.getArticles();
                articleArrayList.addAll(articleList);
                adapter.notifyDataSetChanged();
            }
        });

    }

    private  void init(){

        progress_bar = findViewById(R.id.progress_bar);
        recycler_view = findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setHasFixedSize(true);
        adapter = new ArticleAdapter(MainActivity.this,articleArrayList);
        recycler_view.setAdapter(adapter);
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);

    }
}