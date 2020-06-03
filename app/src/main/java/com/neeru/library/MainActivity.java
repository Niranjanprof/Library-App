package com.neeru.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnAllBooks,btnAlreadyRead,btnWishlist,btnCurrentlyReading,btnFavorite,btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        btnAbout = findViewById(R.id.about);
        btnAllBooks = findViewById(R.id.allbooks);
        btnAlreadyRead = findViewById(R.id.btnalreadyread);
        btnCurrentlyReading= findViewById(R.id.currently);
        btnFavorite = findViewById(R.id.fav);
        btnWishlist = findViewById(R.id.wishlist);
    }

}
