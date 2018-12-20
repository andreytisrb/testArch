package com.example.monomod.presentation.exchangerate.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.monomod.domain.exchangerate.IRateInteractor
import com.example.monomod.presentation.exchangerate.viewdata.RateForView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

interface IExchangeRateViewModel {
    val rate: LiveData<List<RateForView>>
    fun init(exchangeRateIntercator: IRateInteractor)
    fun refresh()
}

class ExchangeRateViewModel : ViewModel(),
    IExchangeRateViewModel {

    private lateinit var exchangeRateInteractor: IRateInteractor
    private var subscription: Disposable? = null

    override fun init(exchangeRateIntercator: IRateInteractor) {
        this.exchangeRateInteractor = exchangeRateIntercator
        refresh()
    }

    override val rate = MutableLiveData<List<RateForView>>()
    override fun refresh() {
        subscription?.dispose()
        subscription = exchangeRateInteractor.rateList.map { rateList -> rateList.map { RateForView(it) } }
            .observeOn(AndroidSchedulers.mainThread()).subscribe({ listRate ->
            rate.value = listRate
        },
            {
                Log.e("err", it.message)
            }
        )
    }
}

