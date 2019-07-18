package  com.example.addmovie.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import  com.example.addmovie.CommentModel.Articles;
import  com.example.addmovie.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class PostAdapter extends TestFactory {

    Context context;
    List<Articles> commentList;

    public PostAdapter(Context context, List<Articles> commentList) {
        this.context = context;
        this.commentList = commentList;
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.post_layout, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
        postViewHolder.publishedAt.setText(String.valueOf(commentList.get(i).getPublishedAt()));
        postViewHolder.movie_name.setText(String.valueOf(commentList.get(i).getSource().getName()));
        postViewHolder.author.setText(String.valueOf(commentList.get(i).getAuthor()));
        postViewHolder.mv_des.setText(String.valueOf(commentList.get(i).getDescription()));

        Picasso.with(context).load(String.valueOf(commentList.get(i).getUrlToImage())).into(postViewHolder.mv_img);

    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}
