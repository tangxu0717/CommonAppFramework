package com.chinasoft.module2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.chinasoft.base.util.RouterActivityPath

@Route(path = RouterActivityPath.PAGER_MODULE2)
class Module2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module2)
    }
}