package com.lmm.taker.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.security.acl.Group;

/**
 * Created by Administrator on 2018/4/17.
 */

public abstract class Fragment extends android.support.v4.app.Fragment {
    protected View mRoot;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //初始化参数
        initArgs(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mRoot==null) {
            int layId = getContentLayoutId();
            //初始化当前的根布局，但是不在创建是就添加到container里面
            View root = inflater.inflate(layId, container, false);
            initWidget(root);
            mRoot=root;
        }else {
            //把当前Root从其父控件中移除
            if(mRoot.getParent()!=null){
                ((ViewGroup)mRoot.getParent()).removeView(mRoot);
            }
        }

        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //当view创建完成后初始化数据
        initData();
    }

    protected abstract int getContentLayoutId();
    protected void initWidget(View root){

    }
    /**
     * 初始化数据
     * */
    protected void initData(){

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
    /**
     *返回按键触发时调用
     * @return 返回true表示我已处理返回逻辑，Activity不用自己finish，
     * 返回false代表我没有处理逻辑，Activity自己走自己
     *
     * */
   public boolean onBackpressed(){
        return false;
   }
}
