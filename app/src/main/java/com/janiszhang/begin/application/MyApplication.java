package com.janiszhang.begin.application;

import android.app.Application;

/**
 * Created by janiszhang on 2018/4/2.
 *
 * 1.Application 是整个程序的入口
 * 2.完成基础模块（第三方）的初始化工作
 * 3.为整个应用的其他模块提供上下文
 *   --为什么Application的单例可以写的这么简单呢？
 *   因为Application的onCreate()方法只会执行一次，不存在并发的问题；
 *   并且在使用是甚至不需要担心NPE的问题，因为Application的实例化是整个程序最初的行为
 */

public class MyApplication extends Application {

    private static MyApplication sApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();

        sApplication = this;
    }

    public static MyApplication getInstance() {
        return sApplication;
    }
}
