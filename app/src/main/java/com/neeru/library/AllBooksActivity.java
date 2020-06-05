package com.neeru.library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView bookRecView;
    private bookRecyclerViewAdapter adapter;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);

        bookRecView = findViewById(R.id.booksRecyclerView);
        adapter = new bookRecyclerViewAdapter(this,"allBooks");
        bookRecView.setAdapter(adapter);
        bookRecView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setBooks(Utils.getInstance(this).getAllbooks());



    }
}