package com.example.mvpdemo.base;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity <T extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected T mPresenter;
    public View rootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = getLayoutInflater().inflate(getLayoutId(), null, false);
        setContentView(rootView);
        mPresenter=getPersenter();
        if(mPresenter!=null){
            mPresenter.attachView(this);
        }
        initEventAndData();
        setListeners();
    }

    protected abstract int getLayoutId();

    protected abstract T getPersenter();

    protected  abstract void initEventAndData();

    protected  abstract void setListeners();

    @Override
    public void showError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
