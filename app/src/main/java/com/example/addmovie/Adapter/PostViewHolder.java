package  com.example.addmovie.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import  com.example.addmovie.R;

public class PostViewHolder extends ViewHolder {


    TextView movie_name, author, publishedAt, mv_des;
    ImageView mv_img;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        mv_img = (ImageView)itemView.findViewById(R.id.movie_img);
        publishedAt = (TextView)itemView.findViewById(R.id.mv_date);
        movie_name = (TextView)itemView.findViewById(R.id.txt_name);
        author = (TextView)itemView.findViewById(R.id.mv_author);
        mv_des = (TextView)itemView.findViewById(R.id.mv_des);

    }
}
