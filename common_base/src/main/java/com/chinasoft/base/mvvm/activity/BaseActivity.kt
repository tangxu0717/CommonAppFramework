package com.chinasoft.base.mvvm.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chinasoft.base.mvvm.vm.BaseVM
import com.gyf.immersionbar.ktx.immersionBar

abstract class BaseActivity<V : ViewDataBinding, VM : BaseVM> : AppCompatActivity() {
    lateinit var mBinding: V
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        initImmersionBar()
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return getViewModelInstance() as T
            }
        })[getViewModelClass()]
        mBinding.setVariable(getVariableId(), viewModel)
        mBinding.lifecycleOwner = this
        initView()
        addObserver()
    }

    open fun initImmersionBar() {
        immersionBar {
            fitsSystemWindows(true)
            navigationBarColor(android.R.color.white)
            statusBarDarkFont(true)
        }
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun getViewModelInstance(): VM
    abstract fun getViewModelClass(): Class<VM>
    abstract fun getVariableId(): Int

    open fun initView() {}
    open fun addObserver() {}
}