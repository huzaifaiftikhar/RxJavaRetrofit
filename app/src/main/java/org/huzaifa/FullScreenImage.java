package org.huzaifa.rxjavaretrofit;

/**
 * Created by Huzaifa on 23-Jun-17.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FullScreenImage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        Glide.with(this).load(getIntent().getStringExtra(Country.IMAGE_URL))
                .into((ImageView) findViewById(R.id.full_screen_image));
    }
}