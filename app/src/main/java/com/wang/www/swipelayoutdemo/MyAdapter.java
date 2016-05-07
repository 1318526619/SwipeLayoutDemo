package com.wang.www.swipelayoutdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.BaseSwipeAdapter;

import java.util.List;

/**
 * Created by wang on 2016/5/6.
 */
public class MyAdapter extends BaseSwipeAdapter {
    private Context context;
    private List<String> list;

    public MyAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public MyAdapter() {
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(int position, ViewGroup parent) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return rootView;
    }

    @Override
    public void fillValues(int position, View convertView) {
        TextView tv = (TextView) convertView.findViewById(R.id.text_item);
        tv.setText(list.get(position));
        final SwipeLayout swipeLayout = (SwipeLayout) convertView.findViewById(R.id.swipe);
        Button bt = (Button) swipeLayout.findViewById(R.id.delete);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swipeLayout.close();
            }
        });

    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
