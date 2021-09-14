package com.example.e_wallet.data.remote

import com.example.e_wallet.domain.entity.PersonCard
import io.reactivex.rxjava3.core.Single

interface HomeRemoteSource {
    fun getPersonCardList(): Single<List<PersonCard>>
    fun getBalance(): Single<Int>
}