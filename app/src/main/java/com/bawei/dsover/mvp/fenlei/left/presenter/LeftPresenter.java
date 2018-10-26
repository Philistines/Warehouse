package com.bawei.dsover.mvp.fenlei.left.presenter;

import android.view.View;

import com.bawei.dsover.mvp.fenlei.left.inter.IView;
import com.bawei.dsover.mvp.fenlei.left.model.LeftModel;
import com.bawei.dsover.mvp.utils.ICallBack;
import com.bawei.dsover.ui.bean.LeftBean;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by 小哥 on 2018/10/25.
 */

public class LeftPresenter {
    private IView iv;
    private LeftModel leftModel;
    public void attch(IView iv){
        this.iv = iv;
        leftModel = new LeftModel();
    }

    public void getLeft() {
        Type type = new TypeToken<LeftBean>() {
        }.getType();
        leftModel.getlefts("http://www.zhaoapi.cn/product/getCatagory", new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                LeftBean leftBean = (LeftBean) obj;
                if (leftBean != null){
                    iv.getLeft(leftBean.getData());
                }
            }
            @Override
            public void onFailed(Exception e) {
                iv.failed(e);
            }
        },type);
    }
    public void datach(){
        if (iv != null){
            iv = null;
        }
    }
}
