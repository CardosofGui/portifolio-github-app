package com.example.portifoliogithub.domain.di

import com.example.portifoliogithub.data.di.DataModule
import com.example.portifoliogithub.domain.ListUserRepositoriesUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load(){
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule() : Module = module {
        factory { ListUserRepositoriesUseCase(get()) }
    }
}