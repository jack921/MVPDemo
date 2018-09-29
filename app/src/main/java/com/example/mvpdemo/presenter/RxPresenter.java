package com.example.mvpdemo.presenter;

import com.example.mvpdemo.base.BasePresenter;
import com.example.mvpdemo.base.BaseView;
import com.example.mvpdemo.network.RetrofitHelper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    public static RetrofitHelper retrofitHelper;

    public RxPresenter(){
        if(retrofitHelper==null){
            retrofitHelper=new RetrofitHelper();
        }
    }

    private CompositeDisposable mCompositeSubscription;
    T mView;

    private void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
        }
    }

    protected void addSubscribe(Disposable disposable) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeDisposable();
        }
        mCompositeSubscription.add(disposable);
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
