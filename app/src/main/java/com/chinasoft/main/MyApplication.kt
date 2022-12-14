package com.chinasoft.main

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.chinasoft.base.CommonApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : CommonApp() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}