package com.seowoo2017.mystore;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by alfo06-21 on 2017-11-01.
 */

public class BookAdapter extends RecyclerView.Adapter {


        ArrayList<Book> books;
        LayoutInflater inflater;


    public BookAdapter(ArrayList<Book> books, LayoutInflater inflater) {

        this.books = books;
        this.inflater = inflater;

        Log.i("zzz","cons");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.cardview_book,parent,false);
        VH holder = new VH(v);

        Log.i("ddd","create");

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final VH vh = (VH)holder;
        vh.textTitle.setText(books.get(position).getTitle());
        vh.textAuthor.setText(books.get(position).getAuthor());
        vh.ratingBar.setRating(books.get(position).getRating());
        //vh.imageView.setImageURI(Uri.parse(books.get(position).getImgUrl()));

        final int pos = position;

        Picasso.with(vh.imageView.getContext()).load(books.get(position).getImgUrl()).into(vh.imageView);



//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    URL url = new URL(books.get(pos).getImgUrl());
//                    InputStream is = url.openStream();
//
//                    final Bitmap bitmap = BitmapFactory.decodeStream(is);
//
//                    vh.imageView.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            vh.imageView.setImageBitmap(bitmap);
//                        }
//                    });
//
//
//
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();


    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class VH extends RecyclerView.ViewHolder{
        TextView textTitle;
        TextView textAuthor;
        ImageView imageView;
        RatingBar ratingBar;


        public VH(View itemView) {
            super(itemView);
            this.textTitle =(TextView) itemView.findViewById(R.id.text_booktitle);
            this.textAuthor =(TextView) itemView.findViewById(R.id.text_bookauthor);
            this.imageView = (ImageView) itemView.findViewById(R.id.image_book);
            this.ratingBar = (RatingBar) itemView.findViewById(R.id.rating_book);
    }
    }
}
