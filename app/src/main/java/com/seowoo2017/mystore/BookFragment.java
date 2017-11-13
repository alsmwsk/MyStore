package com.seowoo2017.mystore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by alfo06-21 on 2017-10-31.
 */

public class BookFragment extends Fragment {

    ArrayList<Book> books = new ArrayList<>();
    RecyclerView recycle_book;
    BookAdapter bookAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Database에서 자료 읽어오기
        loadBookData();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book,container,false);
        recycle_book = (RecyclerView)view.findViewById(R.id.recycler_book);

        //recyclerview의 배치 모양결정매니저.
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,true);
        recycle_book.setLayoutManager(manager);

        bookAdapter = new BookAdapter(books,inflater);
        recycle_book.setAdapter(bookAdapter);

        Log.i("ccc",""+books.size());

        return view;
    }

    public void loadBookData(){

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL("http://alsmwsk.dothome.co.kr/loaddb.php");
                    InputStream is = url.openStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    BufferedReader reader = new BufferedReader(isr);

                    String str = "";
                    String line = reader.readLine();
                    while (line != null){
                        str += line+"\n";
                        line= reader.readLine();
                    }

                    String[] rows = str.split(";");

                    for (int i = 0; i < rows.length-1; i++)
                    {
                       String[] row = rows[i].split("&");

                        if(row.length !=6) {
                           continue;
                        }

                        String title = row[0];
                        int price = Integer.parseInt(row[1]);
                        String desc = row[2];
                        float rating = Float.parseFloat(row[3]);
                        String author = row[4];
                        String uri = row[5];

                        books.add(new Book(uri,title,price,desc,rating,author));

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                bookAdapter.notifyDataSetChanged();
                            }
                        });


                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();


    }
}
