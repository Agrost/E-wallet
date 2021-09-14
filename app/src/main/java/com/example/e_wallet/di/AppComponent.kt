package com.example.e_wallet.di

import android.content.Context
import com.example.e_wallet.di.home.HomeComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [CacheModule::class])
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun registerHomeComponent(): HomeComponent.Factory
}