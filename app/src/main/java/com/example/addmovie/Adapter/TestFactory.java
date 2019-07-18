package com.example.addmovie.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public abstract class TestFactory extends RecyclerView.Adapter<PostViewHolder>{

    public abstract PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);
    public abstract void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i);
    public abstract int getItemCount();
}
