package com.example.signindemo

import android.app.Application
import com.example.signindemo.di.AppModule
import com.example.signindemo.di.AppModuleImpl

class HarryPotterApp: Application() {
    companion object{
        lateinit var  appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule=AppModuleImpl()
    }
}