package com.example.mvvm.retrofit;

import static com.example.mvvm.constants.AppConstant.API_KEY;

import com.example.mvvm.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET(value = "top-headlines?country=us&category=business&apiKey=" + API_KEY)
    Call<ArticleResponse> getTopHeadlines();
}
