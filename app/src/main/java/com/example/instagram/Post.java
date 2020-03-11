package com.example.instagram;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseClassName;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import android.widget.Toast;

import java.util.List;

@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String TAG = "Post";
    public static final String KEY_CAPTION = "Caption";
    public static final String KEY_IMAGE = "Image";
    public static final String KEY_USER = "Username";

    public String getCaption(){
        return getString(KEY_CAPTION);
    }

    public void setCaption(String caption){
        put(KEY_CAPTION, caption);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUsername(ParseUser username){
        put(KEY_USER, username);
    }


}
