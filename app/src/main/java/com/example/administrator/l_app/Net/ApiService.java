package com.example.administrator.l_app.Net;

import com.example.administrator.l_app.bean.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HP on 2018/5/21.
 */

public interface ApiService {
    @GET("getnews.php")
    Call<HttpResult<List<News>>> getNews();
}
