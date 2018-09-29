package com.example.mvpdemo.contract;

import com.example.mvpdemo.base.BasePresenter;
import com.example.mvpdemo.base.BaseView;

public interface MainContract {

    interface View extends BaseView{
        String getName();
        void getBaiDu(String data);
    }

    interface Presenter extends BasePresenter<View>{
        void toMyName();
        void getNetwork();
    }

}
