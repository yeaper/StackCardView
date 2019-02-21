package com.yyp.example.utils;

import android.content.Context;

/**
 * 尺寸转换工具
 *
 * Created by yyp on 2019/2/20
 */
public class DensityUtils {

    /**
     * dp转换成px
     */
    public static float dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return dpValue * scale + 0.5f;
    }
}
