package nikan.sravni.ru.exchangerate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import nikan.sravni.ru.domain.exchangerate.IRateInteractor


interface IExchangeRateViewModel{
    val excangeRates: LiveData<List<ExcangeRatesForView>>
    fun init(exchangeRateIntercator: IRateInteractor)
    fun refresh()
}

class ExchangeRateViewModel() : ViewModel(), IExchangeRateViewModel {

    private lateinit var exchangeRateInteractor: IRateInteractor
    private var subscription: Disposable? = null

    override fun init(exchangeRateIntercator: IRateInteractor){
        this.exchangeRateInteractor = exchangeRateIntercator
        refresh()
    }

    override val excangeRates = MutableLiveData<List<ExcangeRatesForView>>()
    override fun refresh() {
        subscription?.dispose()
        subscription = exchangeRateInteractor.rateList.subscribe {
            excangeRates.value = it.map { ExcangeRatesForView(it.code, it.name, it.curRate) }
        }
    }
}
