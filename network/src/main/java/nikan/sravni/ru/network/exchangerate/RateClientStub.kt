package nikan.sravni.ru.network.exchangerate

import io.reactivex.Observable
import nikan.sravni.ru.domain.exchangerate.entity.Rate
import nikan.sravni.ru.repository.exchangerate.IRateClient

class RateClientStub(): IRateClient {
    override val rateList: Observable<List<Rate>>
        get() = Observable.just(listOf(Rate("Ru","Ruble", 3.3f)))
}