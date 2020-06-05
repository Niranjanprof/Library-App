package com.neeru.library;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.util.Util;

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
        Utils.getInstance(this);
        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });
        btnWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WishlistActivity.class);
                startActivity(intent);
            }
        });
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FavActivity.class);
                startActivity(intent);
            }
        });
        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CurrentlyActivity.class);
                startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Made By Niranjan\nCode :-Github(github.com/Niranjanprof)Page");
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,WebsiteActivity.class);
                        intent.putExtra("url","https://github.com/Niranjanprof");
                        startActivity(intent);
                    }
                });
                builder.create().show();
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
