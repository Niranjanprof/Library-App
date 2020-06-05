package com.neeru.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.util.Util;

public class WishlistActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);


        RecyclerView recyclerView = findViewById(R.id.wishlistactivity);
        bookRecyclerViewAdapter adapter = new bookRecyclerViewAdapter(this,"wantToRead");
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setBooks(Utils.getInstance(this).getWishlist());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(WishlistActivity.this,MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TASK | intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}