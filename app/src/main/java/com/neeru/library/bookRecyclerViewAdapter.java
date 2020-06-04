package com.neeru.library;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class bookRecyclerViewAdapter extends RecyclerView.Adapter<bookRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Book> books = new ArrayList<>();
    private String parentActivity;

    public bookRecyclerViewAdapter(Context context, String parentActivity) {
        this.context = context;
        this.parentActivity = parentActivity;
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
            if(parentActivity.equals("allBooks")){
                holder.delete.setVisibility(View.GONE);
            }else if (parentActivity.equals("alreadyRead")){
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to Delete the book");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().removeFromAlreadyRead(books.get(position))){
                                    Toast.makeText(context,"Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(context, "Something wrong happened,Plz Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }else if (parentActivity.equals("currentlyReading")){
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to Delete the book");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().removeFromCurrentlyRead(books.get(position))){
                                    Toast.makeText(context,"Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(context, "Something wrong happened,Plz Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }else if (parentActivity.equals("wantToRead")){
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to Delete the book");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().removeFromWantToRead(books.get(position))){
                                    Toast.makeText(context,"Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(context, "Something wrong happened,Plz Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });

            }else {
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setMessage("Are you sure you want to Delete the book");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance().removeFromFav(books.get(position))){
                                    Toast.makeText(context,"Removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }else{
                                    Toast.makeText(context, "Something wrong happened,Plz Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });
            }
        }else{
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expanded.setVisibility(View.GONE);
            holder.up.setVisibility(View.VISIBLE);
        }

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,BookActivity.class);
                intent.putExtra("bookId",books.get(position).getId());
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
        private TextView txtName,desc,txtAuthor,delete;
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

            delete = itemView.findViewById(R.id.delete);

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
