package com.yyp.stackcardview.config;

import android.support.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 相关的配置
 *
 * Created by yyp on 2019/2/19.
 */
public class PageTransformerConfig {

    /**
     * 左层叠
     */
    public static final int LEFT = 1;
    /**
     * 右层叠
     */
    public static final int RIGHT = 2;

    /**
     * 视图类型
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.PARAMETER)
    @IntDef({LEFT, RIGHT})
    public @interface ViewType {
    }

}
