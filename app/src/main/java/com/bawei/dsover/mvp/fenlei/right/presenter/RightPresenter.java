package com.bawei.dsover.mvp.fenlei.right.presenter;

import com.bawei.dsover.mvp.fenlei.right.inter.IView;
import com.bawei.dsover.mvp.fenlei.right.model.RightModel;
import com.bawei.dsover.mvp.utils.ICallBack;
import com.bawei.dsover.ui.bean.RightBean;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by 小哥 on 2018/10/25.
 */

public class RightPresenter {
    private IView iv;
    private RightModel rightModel;
    public void attch(IView iv){
        this.iv = iv;
        rightModel = new RightModel();
    }
    public void getright(String url){
        Type type = new TypeToken<RightBean>(){}.getType();
        rightModel.getrights(url, new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                RightBean rightBean = (RightBean) obj;
                if (rightBean!=null){
                    iv.getrights(rightBean.getData());
                }
            }

            @Override
            public void onFailed(Exception e) {
                iv.failed(e);
            }
        },type);
    }
    public void detach(){
        if (iv !=null){
            iv = null;
        }
    }
}
