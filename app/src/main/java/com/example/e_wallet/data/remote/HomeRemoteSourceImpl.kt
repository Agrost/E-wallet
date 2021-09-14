package com.example.e_wallet.data.remote

import com.example.e_wallet.R
import com.example.e_wallet.domain.entity.PersonCard
import io.reactivex.rxjava3.core.Single
import java.util.*
import javax.inject.Inject

class HomeRemoteSourceImpl @Inject constructor(
//    private val api: Api
) : HomeRemoteSource {
    override fun getPersonCardList(): Single<List<PersonCard>> {
//        return api.getPersonCardList().map { it.result }

        //Mock card list
        val personCardList: ArrayList<PersonCard> = arrayListOf(
            PersonCard(1, R.drawable.ic_avatar_1, "Mike"),
            PersonCard(2, R.drawable.ic_avatar_2, "Joseph"),
            PersonCard(3, R.drawable.ic_avatar_3, "Ashley"),
            PersonCard(4, R.drawable.ic_avatar_1, "Alex"),
            PersonCard(5, R.drawable.ic_avatar_3, "Mary"),
            PersonCard(6, R.drawable.ic_avatar_3, "Patricia"),
            PersonCard(7, R.drawable.ic_avatar_2, "Robert"),
        )
        return Single.just(personCardList)
    }

    override fun getBalance(): Single<Int> {
        //        return api.getBalance().map { it.result }

        //Mock balance
        return Single.just(20600)
    }
}