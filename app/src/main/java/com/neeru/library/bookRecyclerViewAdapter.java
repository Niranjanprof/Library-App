package com.neeru.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class bookRecyclerViewAdapter extends RecyclerView.Adapter<bookRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Book> books = new ArrayList<>();

    public bookRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public bookRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull bookRecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.txtName.setText(books.get(position).getName());
        Glide.with(context).asBitmap().load(books.get(position).getImageurl()).into(holder.imgBook);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, books.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgBook;
        private TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent =itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}
