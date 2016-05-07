package com.wang.www.swipelayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.daimajia.swipe.SwipeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private MyAdapter adapter;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);
//        lv.setEmptyView(findViewById(R.id.loading));//progressbar不能转化成view
        initData();
        adapter = new MyAdapter(this,list);

//        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((SwipeLayout)(lv.getChildAt(position - lv.getFirstVisiblePosition())))
                        .open(true);
            }
        });
    }
    private void initData() {
        for (int i = 0; i < 20; i++) {
            list.add(Integer.toString(i));
        }
    }
}
