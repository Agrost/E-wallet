package com.example.e_wallet.di

import com.example.e_wallet.data.cache.HomeCache
import com.example.e_wallet.data.cache.HomeCacheImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface CacheModule {
    @Binds
    @Singleton
    fun bindsCachePage(memoryCacheImpl: HomeCacheImpl): HomeCache
}