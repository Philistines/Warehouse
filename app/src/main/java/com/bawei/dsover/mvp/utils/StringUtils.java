package com.bawei.dsover.mvp.utils;

/**
 * Created by 小哥 on 2018/10/25.
 */

public class StringUtils {
    public static String https2Http(String url) {
        return url.replace("https", "http");
    }
}
