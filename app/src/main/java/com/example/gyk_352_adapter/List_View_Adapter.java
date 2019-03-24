package com.example.gyk_352_adapter;


import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class List_View_Adapter extends ArrayAdapter<Book> {

    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder viewHolder;
    private final ArrayList<Book> book_list;

    // list item view içindeki nesnelere erişmek için bu sınıfı oluşturduk
    public static class ViewHolder
    {
        TextView tv_book_name, tv_book_author;

    }

    public List_View_Adapter(Context context, ArrayList<Book> book_list) {
        super(context, 0,book_list);
        this.context = context;
        this.book_list = book_list;

        inflater = LayoutInflater.from(context);
    }


    // book listin size ını döner
    @Override
    public int getCount() {
        return book_list.size();
    }

// listedeki her itemın özellğini döner
    @Override
    public Book getItem(int position) {
        return book_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        convertView = inflater.inflate(R.layout.list_item_view,null); // arayüzü belirttik. listemizin her bir itemına erişiyoruz.
        viewHolder = new ViewHolder(); // arayüzün sınıfını tanımlıyoruz
        viewHolder.tv_book_name = convertView.findViewById(R.id.tv_book_name); // arayüzdeki nesneleri attık.
        viewHolder.tv_book_author = convertView.findViewById(R.id.tv_book_author);

        convertView.setTag(viewHolder); // arayüzüme hangi sınıftaki değişkenlerle eşleştirdimi gösterdim.

        Book book = book_list.get(position); // listedeki her elemanla yeni bir book nesnesi yarattım.

        viewHolder.tv_book_name.setText(book.getBook_name()); // listedeki her elemana name özelliğini atadık
        viewHolder.tv_book_author.setText(book.getBook_author());

        return convertView;
    }


}
