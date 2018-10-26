package com.bawei.dsover.mvp.shou.presenter;

import com.bawei.dsover.mvp.shou.model.HomeModel;
import com.bawei.dsover.mvp.shou.view.IView;
import com.bawei.dsover.mvp.utils.ICallBack;
import com.bawei.dsover.ui.bean.Banner;
import com.bawei.dsover.ui.bean.MessageBean;
import com.bawei.dsover.ui.bean.Shopper;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by 小哥 on 2018/10/25.
 */

public class HomePresenter {
    private IView iv;
    private HomeModel model;
    public void attach(IView iv){
        this.iv = iv;
        model = new HomeModel();
    }
    public void getBanner(){
        String url = "http://www.zhaoapi.cn/ad/getAd";
        Type type = new TypeToken<MessageBean<List<Banner>>>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                MessageBean<List<Banner>> data = (MessageBean<List<Banner>>) obj;
                iv.getBanner(data);
            }

            @Override
            public void onFailed(Exception e) {
                iv.failed(e);
            }
        },type);
    }
    public void getProduct(){
        String url = "http://www.zhaoapi.cn/product/getCarts?uid=71";
        Type type = new TypeToken<MessageBean<List<Shopper>>>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                MessageBean<List<Shopper>> data = (MessageBean<List<Shopper>>) obj;
                iv.getProduct(data);
            }

            @Override
            public void onFailed(Exception e) {
                iv.failed(e);
            }
        },type);
    }
    public void detach(){
        if (iv!= null){
            iv = null;
        }
    }
}
