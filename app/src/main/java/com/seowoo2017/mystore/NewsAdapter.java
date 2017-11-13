package com.seowoo2017.mystore;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo06-21 on 2017-11-13.
 */

public class NewsAdapter extends RecyclerView.Adapter {

    ArrayList<News> news = new ArrayList<>();
    LayoutInflater inflater;

    public NewsAdapter(ArrayList<News> news, LayoutInflater inflater) {
        this.news = news;
        this.inflater = inflater;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.cardview,parent,false);

        VH_news vh_news = new VH_news(v);

        return vh_news;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final VH_news vh = (VH_news) holder;
        vh.news_title.setText(news.get(position).getTitle());
        vh.news_desc.setText("");


    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class VH_news extends RecyclerView.ViewHolder{

        TextView news_title;
        TextView news_desc;
        ImageView image_news;


        public VH_news(View itemView) {
            super(itemView);
            this.news_title =(TextView) itemView.findViewById(R.id.news_title);
            this.news_desc =(TextView) itemView.findViewById(R.id.news_desc);
            this.image_news = (ImageView) itemView.findViewById(R.id.image_news);

        }
    }
}
