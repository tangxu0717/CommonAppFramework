package com.chinasoft.main.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.chinasoft.base.util.RouterActivityPath
import com.chinasoft.main.R

@Route(path = RouterActivityPath.PAGER_TEST)
class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    }
}