package com.lmm.taker.common.widget;

import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lmm.taker.common.R;
import com.lmm.taker.common.widget.convention.PlaceHolderView;

import net.qiujuer.genius.ui.widget.Loading;


/**
 * 简单的占位控件，
 * 实现了显示一个空的图片显示，
 * 可以和MVP配合显示没有数据，正在加载等状态
 */
@SuppressWarnings("unused")
public class EmptyView extends LinearLayout{
    private ImageView mEmptyImg;
    private TextView mStatusText;
    private Loading mLoading;

    private int[] mDrawableIds = new int[]{0, 0};
    private int[] mTextIds = new int[]{0, 0, 0};

    private View[] mBindViews;


    public EmptyView(Context context) {
        super(context);
    }
}
