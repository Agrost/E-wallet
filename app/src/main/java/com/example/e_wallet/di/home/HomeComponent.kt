package com.example.e_wallet.di.home

import com.example.e_wallet.di.scope.FragmentScope
import com.example.e_wallet.presentation.fragments.HomeFragment
import dagger.Subcomponent

@Subcomponent(modules = [HomeViewModelModule::class])
@FragmentScope
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }
}