package com.bawei.dsover.mvp.shou.view;

import com.bawei.dsover.ui.bean.Banner;
import com.bawei.dsover.ui.bean.MessageBean;
import com.bawei.dsover.ui.bean.Shopper;

import java.util.List;

/**
 * Created by 小哥 on 2018/10/25.
 */

public interface IView {

    void failed(Exception e);

    void getBanner(MessageBean<List<Banner>> banners);

    void getProduct(MessageBean<List<Shopper>> products);
}
