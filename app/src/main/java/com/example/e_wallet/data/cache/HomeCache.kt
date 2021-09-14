package com.example.e_wallet.data.cache

import com.example.e_wallet.data.Answer
import com.example.e_wallet.domain.entity.PersonCard
import io.reactivex.rxjava3.core.Single

interface HomeCache {
    fun getHomeCache(): Single<Answer>
    fun getCountPersonCard(): Int
    fun setPersonCard(personCardList: ArrayList<PersonCard>)
    fun setBalance(balance: Int)
}