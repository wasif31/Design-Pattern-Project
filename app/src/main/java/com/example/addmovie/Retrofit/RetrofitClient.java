package com.example.addmovie.Retrofit;

import com.example.addmovie.CommentModel.Post;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitClient {


    @GET("everything")
    Observable<Post> getPostfromWeb(@Query("q") String category,
                                          @Query("from") String date,
                                          @Query("sortBy") String Sorting,
                                          @Query("apiKey") String ApiKey
    );



}
