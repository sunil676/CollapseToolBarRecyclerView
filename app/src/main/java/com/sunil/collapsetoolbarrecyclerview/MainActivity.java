package com.sunil.collapsetoolbarrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.collaspeToorbar)
    Button collaspeToorbar;
    @BindView(R.id.quick_return_toolbar)
    Button quickReturnToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.collaspeToorbar)
    public void clickCollapseToolbar(){
        startActivity(new Intent(this, CollapsingToolBarActivity.class));
    }

    @OnClick(R.id.quick_return_toolbar)
    public void clickQuickReturnToolbar(){
        startActivity(new Intent(this, QuickReturnToolBarActivity.class));
    }
}
