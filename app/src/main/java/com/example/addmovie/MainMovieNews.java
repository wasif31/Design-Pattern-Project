package com.example.addmovie;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.addmovie.Adapter.Factory;
import com.example.addmovie.Adapter.PostAdapter;
import com.example.addmovie.CommentModel.Articles;
import com.example.addmovie.CommentModel.Post;
import com.example.addmovie.Retrofit.RetrofitBuilder;
import com.example.addmovie.Retrofit.RetrofitClient;
import com.example.addmovie.Template.iRefresh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;



public class MainMovieNews extends AppCompatActivity implements iRefresh {

    private List<Articles> artList;

    RetrofitClient iClient;
    RecyclerView recyclerView_posts;
    CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_new);
        Retrofit retrofit = RetrofitBuilder.getRetrofit();
        iClient = retrofit.create(RetrofitClient.class);
        recyclerView_posts = (RecyclerView)findViewById(R.id.recycler_post);
        recyclerView_posts.setHasFixedSize(true);
        recyclerView_posts.setLayoutManager(new LinearLayoutManager(this));





        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(iClient.getPostfromWeb("movies","2019-06-13", "publishedAt", "f07c892dd3df437ba7788e047e0ebdb5")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Post>() {
                               @Override
                               public void accept(Post posts) throws Exception {
                                   displayData(posts);

                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                 Toast.makeText(MainMovieNews.this, ""+throwable.getMessage(), Toast.LENGTH_SHORT).show();
                               }
                           }
                )
        );
    }



    private void displayData(Post posts) {
        artList = new ArrayList<>(Arrays.asList(posts.getArticles()));
        PostAdapter adapter = (PostAdapter) Factory.get(this, artList,1);
        recyclerView_posts.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.add_button){
            startActivity(new Intent(MainMovieNews.this, PostActivity.class));
        }

        if (item.getItemId() == R.id.action_refresh){
            refresh();
        }

        if (item.getItemId() == R.id.action_Home){
            startActivity(new Intent(MainMovieNews.this, MainActivity.class));


        }

        if (item.getItemId() == R.id.action_Movie_news){

        }

        if (item.getItemId() == R.id.action_setting){

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    public void refresh() {
        Intent intent = new Intent(MainMovieNews.this, MainMovieNews.class);
        finish();
        startActivity(intent);
    }


}
