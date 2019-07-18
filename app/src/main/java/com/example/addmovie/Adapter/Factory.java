package com.example.addmovie.Adapter;

import android.content.Context;

import com.example.addmovie.CommentModel.Articles;

import java.util.List;

public class Factory {

    public static TestFactory get(Context context, List<Articles>list, int type){
        if(type==1)
            return new PostAdapter(context,list);
        return null;
    }
}
