package nikan.sravni.ru.network.exchangerate

import io.reactivex.Observable
import nikan.sravni.ru.domain.exchangerate.entity.Rate
import nikan.sravni.ru.repository.exchangerate.IRateClient

class RateWebClient(private val rateWebService: IRateWebService) : IRateClient {

    override val rateList: Observable<List<Rate>>
        get() = rateWebService.getRates().map {
                it -> listOf(Rate(it.valute.uSD.charCode,it.valute.uSD.charCode, it.valute.uSD.value.toFloat()))
        }
}