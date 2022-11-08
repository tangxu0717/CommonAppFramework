package com.chinasoft.main.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.chinasoft.api.RetrofitManager
import com.chinasoft.api.service.GithubService
import com.chinasoft.base.mvvm.vm.BaseVM
import com.chinasoft.main.model.MainRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import javax.inject.Inject

class MainVM(application: Application) : BaseVM(application) {
    private val mainRepository: MainRepository = MainRepository(viewModelScope)
    fun searchRepos() {
        /*viewModelScope.launch {
            flow {
                var body = RetrofitManager.getGithubService().searchRepos(1,10)
                emit(body)
                Log.d("xu.tang","flowOn thread:"+Thread.currentThread().name)
            }.flowOn(Dispatchers.IO)
                .collect {
                    Log.d("xu.tang","collect thread:"+Thread.currentThread().name)
                    Log.d("xu.tang", "body:"+it.string())
                }
        }*/
        mainRepository.searchRepos {
            RetrofitManager.getGithubService().searchRepos(1,10)
        }
    }
}