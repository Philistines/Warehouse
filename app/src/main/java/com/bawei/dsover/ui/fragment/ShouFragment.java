package com.bawei.dsover.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.dsover.mvp.shou.presenter.HomePresenter;
import com.bawei.dsover.mvp.shou.view.IView;
import com.bawei.dsover.ui.activity.R;
import com.bawei.dsover.ui.adapter.BannerAdapter;
import com.bawei.dsover.ui.adapter.ProductAdapter;
import com.bawei.dsover.ui.bean.Banner;
import com.bawei.dsover.ui.bean.MessageBean;
import com.bawei.dsover.ui.bean.Product;
import com.bawei.dsover.ui.bean.Shopper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小哥 on 2018/10/25.
 */

public class ShouFragment extends Fragment implements IView {

    private ViewPager vp;
    private RecyclerView rec_view;
    private List<Banner> bannerList;
    private BannerAdapter bannerAdapter;

    private List<Product> productList;
    private ProductAdapter productAdapter;

    private HomePresenter presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_shou,container,false);
        vp = view.findViewById(R.id.vp);
        rec_view = view.findViewById(R.id.rec_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bannerList = new ArrayList<>();
        bannerAdapter = new BannerAdapter(getActivity(), bannerList);
        vp.setAdapter(bannerAdapter);
        productList = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        rec_view.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(getActivity(), productList);
        rec_view.setAdapter(productAdapter);
        presenter = new HomePresenter();
        presenter.attach(this);
        presenter.getBanner();
        presenter.getProduct();
    }

    @Override
    public void failed(Exception e) {
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getBanner(MessageBean<List<Banner>> banners) {
        if (banners != null){
            List<Banner> data = banners.getData();
            if (data != null){
                bannerList.clear();
                bannerList.addAll(data);
                bannerAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void getProduct(MessageBean<List<Shopper>> products) {
        List<Shopper> shoppers = products.getData();
        if (shoppers != null){
            productList.clear();
            for (Shopper shopper : shoppers){
                List<Product> list = shopper.getList();
                if (list != null){
                    productList.addAll(list);
                }
            }
            productAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detach();
        }
    }
}
