package com.chinasoft.api

import com.chinasoft.api.config.Api
import com.chinasoft.api.service.GithubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
    private val mGithubService: GithubService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        mGithubService = retrofit.create(GithubService::class.java)
    }

    fun getGithubService(): GithubService = mGithubService
}