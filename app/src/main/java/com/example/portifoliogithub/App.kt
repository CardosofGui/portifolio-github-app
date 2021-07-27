package com.example.portifoliogithub

import android.app.Application
import com.example.portifoliogithub.data.di.DataModule
import com.example.portifoliogithub.domain.di.DomainModule
import com.example.portifoliogithub.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}