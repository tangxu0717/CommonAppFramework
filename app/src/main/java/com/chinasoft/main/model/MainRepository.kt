package com.chinasoft.main.model

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.chinasoft.api.RetrofitManager
import com.chinasoft.base.mvvm.model.BaseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class MainRepository(scope: CoroutineScope) : BaseRepository(scope) {
    fun<T> searchRepos(block: suspend CoroutineScope.() -> T) {
        scope.launch {
            flow {
//                var body = RetrofitManager.getGithubService().searchRepos(1,10)
//                emit(body)
//                Log.d("xu.tang","flowOn thread:"+Thread.currentThread().name)
                val body: T = block()
                emit(body)
            }.flowOn(Dispatchers.IO)
                .collect {
                    Log.d("xu.tang","collect thread:"+Thread.currentThread().name)
                    val result: ResponseBody = it as ResponseBody
                    Log.d("xu.tang", "body:"+it.string())
                }

            //Log.d("xu.tang", "body:"+body.string())
        }
    }
}