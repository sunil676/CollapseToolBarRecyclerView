package com.sunil.collapsetoolbarrecyclerview;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 12/8/16.
 */

public class CollapsingToolBarActivity extends AppCompatActivity {

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.header)
    ImageView header;
    @BindView(R.id.toolbar_flexible_space)
    Toolbar toolbarFlexibleSpace;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    String imageUrl[] = Constant.image;
    String names[] = Constant.name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        ButterKnife.bind(this);
        
        initView();
    }

    private void initView() {

        toolbarFlexibleSpace.setTitle("Collapse Tool Bar");
        setSupportActionBar(toolbarFlexibleSpace);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbarFlexibleSpace.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CollapsingToolBarActivity.super.onBackPressed();
            }
        });


        List<ItemModel> list = getList();
        RecyclerAdapter adapter = new RecyclerAdapter(this, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
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
