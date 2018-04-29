package com.lmm.taker.mytalker.push;

import com.igexin.sdk.PushManager;
import com.lmm.taker.common.app.Application;

/**
 * Created by Administrator on 2018/4/29.
 */

public class LaunchActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 调用Factory进行初始化
        Factory.setup();
        // 推送进行初始化
        PushManager.getInstance().initialize(this);
    }
}
