package com.example.mvvm.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvm.repository.ArticleRepository;
import com.example.mvvm.response.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {
    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);


        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getDashBoardNews();
    }

    public LiveData<ArticleResponse> getBashboardNewsLiveData(){
        return  articleResponseLiveData;
    }

}
