package com.neeru.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BookActivity extends AppCompatActivity {

    private Button btnAlreadyRead,btnWishlist,btnCurrentlyReading,btnFavorite;
    private ImageView bookImage;
    private TextView name,author,pages,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();


    }

    private void initViews() {
        btnAlreadyRead = findViewById(R.id.alreadyread);
        btnWishlist = findViewById(R.id.wishlist);
        btnCurrentlyReading = findViewById(R.id.currentlyreading);
        btnFavorite = findViewById(R.id.fav);
        bookImage = findViewById(R.id.coverImageView);
        name = findViewById(R.id.namefield);
        author = findViewById(R.id.authorfield);
        pages = findViewById(R.id.pagesfield);
        description = findViewById(R.id.desc);
    }
}