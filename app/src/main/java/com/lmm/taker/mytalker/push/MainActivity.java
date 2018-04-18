package com.lmm.taker.mytalker.push;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lmm.taker.common.Common;
import com.lmm.taker.common.app.Activity;

import butterknife.BindView;

public class MainActivity extends Activity{
    @BindView(R.id.txt_test)
    TextView mTestText;
    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mTestText.setText("Test Hello!");
    }
}
