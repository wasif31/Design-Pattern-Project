package com.example.addmovie;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.addmovie.DecoratorTest.BasicText;
import com.example.addmovie.DecoratorTest.EndAgainText;
import com.example.addmovie.DecoratorTest.iEndingText;
import com.example.addmovie.Template.iRefresh;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import static com.example.addmovie.SingleResponsibility.AirplaneMoodDetect.isAirplaneModeOn;

public class MainActivity  extends AppCompatActivity implements iRefresh {

    private RecyclerView mBloglist;
    private DatabaseReference mDatabase;
    private StringBuilder sb = new StringBuilder();
    private iEndingText endTxt = new BasicText();

    int clickcount=0;

    private boolean airplaneMood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Community");

        mBloglist = (RecyclerView)findViewById(R.id.blog_list);
        mBloglist.setHasFixedSize(true);
        mBloglist.setLayoutManager(new LinearLayoutManager(this));

        airplaneMood = isAirplaneModeOn(getApplicationContext());


        if (airplaneMood){
            Toast.makeText(MainActivity.this, "Please Turn off Airplane Mood", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Blog, BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Blog, BlogViewHolder>(Blog.class,
                R.layout.blog_row,
                BlogViewHolder.class,
                mDatabase) {

            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Blog model, int position) {
                final String post_key = getRef(position).getKey();

                viewHolder.setTitle(model.getTitle());
                viewHolder.setGenre(model.getGenre());
                viewHolder.setRating(model.getRating());
                viewHolder.setRelease_year(model.getRelease_year());
                viewHolder.setImage(getApplicationContext(), model.getImage());

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Post_inner_part.class);
                        intent.putExtra("blog_id", post_key);
                        startActivity(intent);
                    }
                });
            }
        };
        mBloglist.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public void refresh() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        finish();
        startActivity(intent);
    }


    //Set title, genre etc
    public static class BlogViewHolder extends ViewHolder {
        View mView;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
        }

        public void setTitle(String title){
            TextView post_title = (TextView)mView.findViewById(R.id.item_movie_title);
            post_title.setText(title);
        }
        public void setRating(String rating) {
            TextView mRating = (TextView)mView.findViewById(R.id.item_movie_rating);
            mRating.setText(rating);
        }

        public void setGenre(String genre) {
            TextView mgenre = (TextView)mView.findViewById(R.id.item_movie_genre);
            mgenre.setText(genre);
        }

        public void setRelease_year(String release_year) {
            TextView rel_year = (TextView)mView.findViewById(R.id.item_movie_release_date);
            rel_year.setText(release_year);
        }

        public void setImage(Context ctx, String Image){
            ImageView post_image = (ImageView)mView.findViewById(R.id.item_movie_poster);
            Picasso.with(ctx).load(Image).into(post_image);
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.add_button){
            startActivity(new Intent(MainActivity.this, PostActivity.class));
        }

        if (item.getItemId() == R.id.action_refresh){
            refresh();
        }

        if (item.getItemId() == R.id.action_Home){
            clickcount++;

            if (clickcount == 1){
                sb = endTxt.show();
                Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();
            }

            if (clickcount == 2){
                endTxt = new EndAgainText(new BasicText());
                sb = endTxt.show();
                Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();
            }


        }

        if (item.getItemId() == R.id.action_Movie_news){
            startActivity(new Intent(MainActivity.this, MainMovieNews.class));
        }

        if (item.getItemId() == R.id.action_setting){

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        if (airplaneMood){
            Toast.makeText(MainActivity.this, "Please Turn off Airplane Mode", Toast.LENGTH_LONG).show();
        }
        super.onResume();
    }
}
