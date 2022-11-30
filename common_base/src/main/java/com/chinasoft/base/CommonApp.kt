package com.chinasoft.base

import android.app.Application

open class CommonApp : Application() {
    companion object {
        lateinit var app: CommonApp

        init {
            fun getApp(): CommonApp {
                return app
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}