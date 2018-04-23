package com.lmm.taker.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.lmm.taker.common.widget.convention.PlaceHolderView;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/17.
 */

public abstract class Activity extends AppCompatActivity {

    protected PlaceHolderView mPlaceHolderView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化界面之前初始化窗口
        initWindows();
        if(initArgs(getIntent().getExtras())) {
            int layId=getContentLayoutId();
            //得到界面id并设置到Activity界面中
            setContentView(layId);
            initWidget();
            initData();
        }else {
            finish();
        }
    }

    /**
     * 初始化控件调用之前
     */
    protected void initBefore() {

    }
/**
 *
 * 初始化窗口
 * */
    protected  void initWindows(){

    }
    /**
     * 初始化相关参数
     * @param bundle 参数bundle
     *  @return 如果参数正确返回true,错误返回false
     *
     * */
    protected boolean initArgs(Bundle bundle){
        return true;
    }
    protected abstract int getContentLayoutId();//得到当前界面的资源id
    /**
     * 初始化控件
     * */
    protected void initWidget(){

        ButterKnife.bind(this);

    }
    /**
     *
     *初始化数据
     * */
    protected void initData(){

    }

    /***
     *
     *
     */
    @Override
    public boolean onSupportNavigateUp() {
        //当点击界面导航时，finish当前界面
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        //得到当前Activity下的所有Fragment
        List<android.support.v4.app.Fragment> fragments=getSupportFragmentManager().getFragments();
        //判断是否为空
        if(fragments!=null&&fragments.size()>0){
            for(Fragment fragment:fragments){
                //判断是否为我们能够处理的Fragment类型
                if (fragment instanceof com.lmm.taker.common.app.Fragment){
                    //判断是否拦截了返回的按钮
                    if(((com.lmm.taker.common.app.Fragment) fragment).onBackpressed()){
                        //如果有直接返回
                       return;
                    }
                }
            }
        }
        super.onBackPressed();
        finish();
    }
}
