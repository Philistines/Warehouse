package com.bawei.dsover.mvp.shou.model;

import com.bawei.dsover.mvp.shou.inter.INetCallBack;
import com.bawei.dsover.mvp.utils.HttpUtils;
import com.bawei.dsover.mvp.utils.ICallBack;

import java.lang.reflect.Type;

/**
 * Created by 小哥 on 2018/10/25.
 */

public class HomeModel {
    public void getData(String url, ICallBack callBack, Type type) {
        HttpUtils.getInstance().get(url, callBack, type);
    }
}
