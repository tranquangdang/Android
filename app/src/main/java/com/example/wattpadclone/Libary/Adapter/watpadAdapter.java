package com.example.wattpadclone.Libary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wattpadclone.Chung.Bean.Book;
import com.example.wattpadclone.R;

import java.util.ArrayList;
import java.util.List;

public class watpadAdapter extends BaseAdapter {
 Context mContext;
    public ArrayList<Book> arraylistListener;
    private List<Book> mListenerList;
    public watpadAdapter( List<Book> mListenerList,Context context) {
        mContext = context;
        this.mListenerList = mListenerList;
        this.arraylistListener = new ArrayList<Book>();
        this.arraylistListener.addAll(mListenerList);
    }
    public class ViewHolder {
        ImageView mImage;
        TextView mTitle;
        TextView mName;
    }
    @Override
    public int getCount() {
        return mListenerList.size();
    }

    @Override
    public Object getItem(int i) {
        return mListenerList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout2_watpad, null);
            holder = new ViewHolder();
            holder.mImage = (ImageView) view.findViewById(R.id.gr_anh);
            holder.mTitle=(TextView)view.findViewById(R.id.gr_title);
            holder.mName=view.findViewById(R.id.gr_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        try {
            String image = mListenerList.get(i).getBookImg();
            holder.mImage.setImageResource(Integer.parseInt(mListenerList.get(i).getBookImg()));
            holder.mTitle.setText(mListenerList.get(i).getBookName());
            holder.mName.setText(mListenerList.get(i).getAuthor());
        }catch (Exception ex){

        }
        return view;
    }
}
