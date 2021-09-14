package com.example.e_wallet.data

import com.example.e_wallet.data.dto.JsonResponse
import io.reactivex.rxjava3.core.Single

interface Api {
    fun getPersonCardList(): Single<JsonResponse>
}