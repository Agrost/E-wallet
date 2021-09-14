package com.example.e_wallet.data.repository

import com.example.e_wallet.data.Answer
import io.reactivex.rxjava3.core.Single

interface HomeRepository {
    fun getAnswer(): Single<Answer>
}