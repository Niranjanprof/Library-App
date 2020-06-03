package com.neeru.library;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

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

        if(books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expanded.setVisibility(View.VISIBLE);
            holder.up.setVisibility(View.GONE);
        }else{
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expanded.setVisibility(View.GONE);
            holder.up.setVisibility(View.VISIBLE);
        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BookActivity.class);
                context.startActivity(intent);
            }
        });

        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.desc.setText(books.get(position).getShortDesc());
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
        private ImageView imgBook,down,up;
        private RelativeLayout expanded;
        private TextView txtName,desc,txtAuthor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent =itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtName = itemView.findViewById(R.id.txtName);

            down = itemView.findViewById(R.id.downarrow);
            up = itemView.findViewById(R.id.uparrow);
            desc = itemView.findViewById(R.id.desc);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            expanded = itemView.findViewById(R.id.expanded);

            down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            up.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
