package com.example.e_wallet.domain.usecase

import com.example.e_wallet.data.repository.HomeRepository
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    fun getAnswer() = homeRepository.getAnswer()
}