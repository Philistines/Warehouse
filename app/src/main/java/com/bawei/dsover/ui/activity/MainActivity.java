package com.bawei.dsover.ui.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bawei.dsover.ui.fragment.FlFragment;
import com.bawei.dsover.ui.fragment.GwcFragment;
import com.bawei.dsover.ui.fragment.ShouFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView1;
    private TextView textView2;
    private FlFragment flFragment;
    private GwcFragment gwcFragment;
    private ShouFragment shouFragment;
    private List<Fragment> list;
    private ViewPager viewPager;
    private EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.fl);
        textView2 = findViewById(R.id.gwc);
        edit_text = findViewById(R.id.edit_text);
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        flFragment = new FlFragment();
        gwcFragment = new GwcFragment();
        shouFragment = new ShouFragment();
        list = new ArrayList<>();
        list.add(shouFragment);
        list.add(flFragment);
        list.add(gwcFragment);
        viewPager = findViewById(R.id.vp_s);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        edit_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LiuShiActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shou:
                viewPager.setCurrentItem(0);
                break;
            case R.id.fl:
                viewPager.setCurrentItem(1);
                break;
            case R.id.gwc:
                viewPager.setCurrentItem(2);
                break;
        }
    }
}
