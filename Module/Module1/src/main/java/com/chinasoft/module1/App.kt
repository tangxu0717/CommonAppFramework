package com.chinasoft.module1

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        lateinit var app: App

        init {
            fun getApp(): App {
                return app
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}