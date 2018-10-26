package com.bawei.dsover.mvp.fenlei.right.model;

import com.bawei.dsover.mvp.utils.HttpUtils;
import com.bawei.dsover.mvp.utils.ICallBack;

import java.lang.reflect.Type;

/**
 * Created by 小哥 on 2018/10/25.
 */

public class RightModel {
    public void getrights(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }
}
