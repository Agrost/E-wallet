package com.example.e_wallet.data.cache

import com.example.e_wallet.data.Answer
import com.example.e_wallet.domain.entity.PersonCard
import io.reactivex.rxjava3.core.Single
import java.util.*
import javax.inject.Inject

class HomeCacheImpl @Inject constructor() : HomeCache {

    private var _personCardList: ArrayList<PersonCard> = arrayListOf()
    private var _balance = 0
    override fun getCountPersonCard(): Int = _personCardList.size

    override fun getHomeCache(): Single<Answer> {
        if (_personCardList.isEmpty()) return Single.just(Answer.Failure)
        return Single.just(Answer.Success(_personCardList, _balance))
    }

    override fun setPersonCard(personCardList: ArrayList<PersonCard>) {
        _personCardList = personCardList
    }

    override fun setBalance(balance: Int){
        _balance = balance
    }
}