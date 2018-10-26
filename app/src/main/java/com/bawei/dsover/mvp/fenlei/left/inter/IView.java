package com.bawei.dsover.mvp.fenlei.left.inter;

import com.bawei.dsover.ui.bean.LeftBean;

import java.util.List;

/**
 * Created by 小哥 on 2018/10/25.
 */

public interface IView {

    void getLeft(List<LeftBean.DataBean> list);

    void failed(Exception e);

}
