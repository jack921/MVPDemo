package com.example.mvpdemo.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.mvpdemo.contract.MainContract;
import com.example.mvpdemo.model.Weather;
import com.example.mvpdemo.network.RetrofitHelper;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter {
    private Context context;

    public MainPresenter(Context context){
        this.context=context;
    }

    @Override
    public void toMyName() {
        Toast.makeText(context,mView.getName(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void getNetwork() {
        retrofitHelper.getBaidu()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Weather>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(Weather s) {
                        mView.getBaiDu(s.getLat()+"");
                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }

}
