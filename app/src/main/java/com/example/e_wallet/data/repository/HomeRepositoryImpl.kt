package com.example.e_wallet.data.repository

import com.example.e_wallet.data.Answer
import com.example.e_wallet.data.cache.HomeCache
import com.example.e_wallet.data.remote.HomeRemoteSource
import com.example.e_wallet.domain.entity.PersonCard
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeCache: HomeCache,
    private val homeRemoteSource: HomeRemoteSource
) : HomeRepository {

    override fun getAnswer(): Single<Answer> {
        return homeCache.getHomeCache().flatMap {
            if (it == Answer.Failure) {
                homeRemoteSource.getPersonCardList()
                    .map { personCardList ->
                        val personCardArrayList = arrayListOf<PersonCard>()
                        personCardArrayList.addAll(personCardList)
                        homeCache.setPersonCard(personCardArrayList)
                    }
                    .flatMap {
                        homeRemoteSource.getBalance().map { balance ->
                            homeCache.setBalance(balance)
                        }
                    }
                    .flatMap { homeCache.getHomeCache() }
            } else Single.just(it)
        }
    }
}