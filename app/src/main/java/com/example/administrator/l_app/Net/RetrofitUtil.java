package com.example.administrator.l_app.Net;

import com.example.administrator.l_app.bean.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HP on 2018/5/21.
 */

public class RetrofitUtil {
    public static void getNews(Callback<HttpResult<List<News>>> callback){
        //创建retrofit实例
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://211.67.147.26")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<HttpResult<List<News>>> call = apiService.getNews();
        call.enqueue(callback);
    }
}
