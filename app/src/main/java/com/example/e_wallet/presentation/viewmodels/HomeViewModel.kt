package com.example.e_wallet.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_wallet.data.Answer
import com.example.e_wallet.domain.usecase.GetHomeUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


class HomeViewModel @Inject constructor(getHomeUseCase: GetHomeUseCase) : ViewModel() {

    private var answerSource: Disposable? = null
    private val answer: MutableLiveData<Answer> = MutableLiveData(Answer.Loading)

    fun getAnswer(): LiveData<Answer> = answer

    init {
        answerSource = getHomeUseCase.getAnswer()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    answer.value = it
                },
                {
                    answer.value = Answer.Failure
                },
            )
    }

    override fun onCleared() {
        super.onCleared()
        answerSource?.dispose()
    }
}