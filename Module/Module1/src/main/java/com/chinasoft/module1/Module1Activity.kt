package com.chinasoft.module1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.chinasoft.base.util.RouterActivityPath

@Route(path = RouterActivityPath.PAGER_MODULE1)
class Module1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module1)
        findViewById<TextView>(R.id.tv_test).setOnClickListener {
            ARouter.getInstance().build(RouterActivityPath.PAGER_MODULE2).navigation()
        }
    }
}