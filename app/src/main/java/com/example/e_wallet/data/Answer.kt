package com.example.e_wallet.data

import com.example.e_wallet.domain.entity.PersonCard

sealed class Answer {
    class Success(
        val personCardList: ArrayList<PersonCard>,
        val currentBalance: Int
        ) : Answer()
    object Failure : Answer()
    object Loading : Answer()
}