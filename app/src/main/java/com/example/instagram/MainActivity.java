package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private EditText etCaption;
    private Button btnPicture;
    private Button btnSubmit;
    private ImageView ivImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCaption = findViewById(R.id.etCaption);
        btnPicture = findViewById(R.id.btnPicture);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String caption = etCaption.getText().toString();
                if(caption.isEmpty()){
                    Toast.makeText(MainActivity.this, "Caption can't be empty", Toast.LENGTH_SHORT).show();
                }
                ParseUser parseUser = ParseUser.getCurrentUser();
                savePost(caption, parseUser);
            }
        });

    }

    private void savePost(String caption, ParseUser parseUser) {
        Post post = new Post();
        post.setCaption(caption);
        post.setUsername(parseUser);

        post.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null){
                    Log.i(TAG, "Error posting ", e);
                    Toast.makeText(MainActivity.this, "There was an error when trying to post",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    Log.i(TAG, "Succesfully posted!");
                    etCaption.setText("");
                }
            }
        });


    }



//    private void queryPosts() {
//        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
//        query.include(Post.KEY_USER);
//        query.findInBackground(new FindCallback<Post>() {
//            @Override
//            public void done(List<Post> objects, ParseException e) {
//                if(e != null) {
//                    Log.e(TAG, "Issue getting posts", e);
//                }
//            }
//        })
//    }
}
