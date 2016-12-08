package com.sunil.collapsetoolbarrecyclerview;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 12/8/16.
 */

public class QuickReturnToolBarActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    String imageUrl[] = Constant.image;
    String names[] = Constant.name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitt_quick_retrun);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        toolbar.setTitle("Quick Return Tool Bar");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuickReturnToolBarActivity.super.onBackPressed();
            }
        });


        List<ItemModel> list = getList();
        RecyclerAdapter adapter = new RecyclerAdapter(this, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    private List<ItemModel> getList() {
        List<ItemModel> list = new ArrayList<>();
        for (int i = 0; i < imageUrl.length; i++) {
            ItemModel model = new ItemModel();
            model.setName(names[i]);
            model.setImagePath(imageUrl[i]);
            list.add(model);
        }
        return list;
    }
}
