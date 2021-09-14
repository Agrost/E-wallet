package com.example.e_wallet.di.home

import androidx.lifecycle.ViewModel
import com.example.e_wallet.data.remote.HomeRemoteSource
import com.example.e_wallet.data.remote.HomeRemoteSourceImpl
import com.example.e_wallet.data.repository.HomeRepository
import com.example.e_wallet.data.repository.HomeRepositoryImpl
import com.example.e_wallet.di.keys.ViewModelKey
import com.example.e_wallet.di.scope.FragmentScope
import com.example.e_wallet.presentation.viewmodels.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @ViewModelKey(HomeViewModel::class)
    @FragmentScope
    @IntoMap
    @Binds
    abstract fun bindsHomeViewModule(
        homeViewModel: HomeViewModel
    ): ViewModel

    @Binds
    @FragmentScope
    abstract fun bindsPageRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository

    @Binds
    @FragmentScope
    abstract fun bindsPageRemoteSource(
        homeRemoteSource: HomeRemoteSourceImpl
    ): HomeRemoteSource
}