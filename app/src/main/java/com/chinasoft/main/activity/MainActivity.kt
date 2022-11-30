package com.chinasoft.main.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.chinasoft.base.mvvm.activity.BaseActivity
import com.chinasoft.base.util.RouterActivityPath
import com.chinasoft.main.BR
import com.chinasoft.main.R
import com.chinasoft.main.databinding.ActivityMainBinding
import com.chinasoft.main.vm.MainVM

@Route(path = RouterActivityPath.PAGER_MAIN)
class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelInstance(): MainVM = MainVM(application)

    override fun getViewModelClass(): Class<MainVM> = MainVM::class.java

    override fun getVariableId(): Int = BR.vm

    override fun initView() {
        super.initView()
        mBinding.tvTest.setOnClickListener {
            ARouter.getInstance().build(RouterActivityPath.PAGER_MODULE1).navigation()
        }
        viewModel.searchRepos()
    }

    override fun onResume() {
        super.onResume()
        /*PermissionX.init(this)
            .permissions(Manifest.permission.READ_CONTACTS, Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE)
            .onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(deniedList, "Core fundamental are based on these permissions", "OK", "Cancel")
            }
            .explainReasonBeforeRequest()
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "These permissions are denied: $deniedList", Toast.LENGTH_LONG).show()
                }
            }*/
    }
}