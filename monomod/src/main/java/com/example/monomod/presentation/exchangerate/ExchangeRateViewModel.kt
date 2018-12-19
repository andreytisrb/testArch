package com.example.monomod.presentation.exchangerate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.monomod.domain.exchangerate.IRateInteractor
import io.reactivex.disposables.Disposable

interface IExchangeRateViewModel{
    val rate: LiveData<List<RateForView>>
    fun init(exchangeRateIntercator: IRateInteractor)
    fun refresh()
}

class ExchangeRateViewModel : ViewModel(), IExchangeRateViewModel {

    private lateinit var exchangeRateInteractor: IRateInteractor
    private var subscription: Disposable? = null

    override fun init(exchangeRateIntercator: IRateInteractor){
        this.exchangeRateInteractor = exchangeRateIntercator
        refresh()
    }

    override val rate = MutableLiveData<List<RateForView>>()
    override fun refresh() {
        subscription?.dispose()
        subscription = exchangeRateInteractor.rateList.subscribe {listRate->
            rate.value = listRate.map { RateForView(it) }
        }
    }
}
