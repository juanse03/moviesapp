package com.example.movies.api

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        ApiClient.initApiService()
    }
}