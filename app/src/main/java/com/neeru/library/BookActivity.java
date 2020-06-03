package com.neeru.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private Button btnAlreadyRead,btnWishlist,btnCurrentlyReading,btnFavorite;
    private ImageView bookImage;
    private TextView name,author,pages,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        Intent intent = getIntent();
        int bookId = -1;
        if(null !=intent){
            bookId = intent.getIntExtra("bookId",-1);
        }
        if(bookId != -1){
            Book book = Utils.getInstance().getBookById(bookId);
            if(book != null){
                setData(book);
            }
        }
    }

    private void setData(Book book) {
        name.setText(book.getName());
        author.setText(book.getAuthor());
        pages.setText(String.valueOf(book.getPages()));
        description.setText(book.getLongDesc());
        Glide.with(this).asBitmap().load(book.getImageurl()).into(bookImage);
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
        description = findViewById(R.id.longfeild);
    }
}