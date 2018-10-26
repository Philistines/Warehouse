package com.bawei.dsover.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.dsover.mvp.utils.StringUtils;
import com.bawei.dsover.ui.activity.R;
import com.bawei.dsover.ui.bean.Product;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 小哥 on 2018/10/25.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    private Context context;
    private List<Product> list;

    public ProductAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_product, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = list.get(position);
        String[] strings = product.getImages().split("\\|");
        Glide.with(context)
                .load(StringUtils.https2Http(strings[0]))
                .into(holder.imgProduct);
        holder.txtTitle.setText(product.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProduct;
        private TextView txtTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_product);
            txtTitle = itemView.findViewById(R.id.txt_title);
        }
    }
}
