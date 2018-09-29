package com.example.mvpdemo;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvpdemo.base.BaseActivity;
import com.example.mvpdemo.contract.MainContract;
import com.example.mvpdemo.presenter.MainPresenter;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    public Button myButton;
    public Button mainNetwork;
    public TextView content;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPersenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void initEventAndData() {
        myButton=findViewById(R.id.main_btn);
        mainNetwork=findViewById(R.id.main_network);
        content=findViewById(R.id.content);
    }

    @Override
    protected void setListeners() {
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.toMyName();
            }
        });
        mainNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getNetwork();
            }
        });
    }

    @Override
    public String getName() {
        return "HelloJack";
    }

    @Override
    public void getBaiDu(String data) {
        content.setText(data);
    }


}


