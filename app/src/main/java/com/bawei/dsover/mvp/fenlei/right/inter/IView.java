package com.bawei.dsover.mvp.fenlei.right.inter;

import com.bawei.dsover.ui.bean.RightBean;

import java.util.List;

/**
 * Created by 小哥 on 2018/10/25.
 */

public interface IView {
    void getrights(List<RightBean.DataBean> list);
    void failed(Exception e);
}
