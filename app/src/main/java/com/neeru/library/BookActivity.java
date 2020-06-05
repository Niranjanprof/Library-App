package com.neeru.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
            Book book = Utils.getInstance(this).getBookById(bookId);
            if(book != null){
                setData(book);

                handleAlreadyread(book);
                handlewishlist(book);
                handleCurrentlist(book);
                handleFav(book);
            }
        }
    }

    private void handleFav(final Book book) {
        ArrayList<Book> favlist = Utils.getInstance(this).getFav();
        boolean existingInFavlist = false;

        for (Book b:favlist
        ) {
            if(b.getId() == book.getId()){
                existingInFavlist= true;
            }
        }
        if(existingInFavlist){
            btnFavorite.setEnabled(false);
        }else{
            btnFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToFavlist(book)){
                        Toast.makeText(BookActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,FavActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong happened Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlist(final Book book) {
        ArrayList<Book> currlist = Utils.getInstance(this).getCurrentlyreadinglist();
        boolean existingInCurrlist = false;

        for (Book b:currlist
        ) {
            if(b.getId() == book.getId()){
                existingInCurrlist= true;
            }
        }
        if(existingInCurrlist){
            btnCurrentlyReading.setEnabled(false);
        }else{
            btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToCurrlist(book)){
                        Toast.makeText(BookActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,CurrentlyActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong happened Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handlewishlist(final Book book) {
        ArrayList<Book> wishlist = Utils.getInstance(this).getWishlist();
        boolean existingInWishlist = false;

        for (Book b:wishlist
        ) {
            if(b.getId() == book.getId()){
                existingInWishlist= true;
            }
        }
        if(existingInWishlist){
            btnWishlist.setEnabled(false);
        }else{
            btnWishlist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToWishlist(book)){
                        Toast.makeText(BookActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,WishlistActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong happened Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void handleAlreadyread(final Book book) {
        ArrayList<Book> alreadyBooks = Utils.getInstance(this).getAlreadyReadBooks();
        boolean existingAlreadyReadBooks = false;

        for (Book b:alreadyBooks
             ) {
            if(b.getId() == book.getId()){
                existingAlreadyReadBooks= true;
            }
        }
        if(existingAlreadyReadBooks){
            btnAlreadyRead.setEnabled(false);
        }else{
            btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance(BookActivity.this).addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(BookActivity.this, "Something wrong happened Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
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
        btnWishlist = findViewById(R.id.wanttoread);
        btnCurrentlyReading = findViewById(R.id.btncurrentlyreading);
        btnFavorite = findViewById(R.id.fav);
        bookImage = findViewById(R.id.coverImageView);
        name = findViewById(R.id.namefield);
        author = findViewById(R.id.authorfield);
        pages = findViewById(R.id.pagesfield);
        description = findViewById(R.id.longfeild);
    }
}