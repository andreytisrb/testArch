package nikan.sravni.ru.repository.exchangerate

import io.reactivex.Observable
import nikan.sravni.ru.domain.exchangerate.entity.Rate

interface IRateClient {
    val rateList: Observable<List<Rate>>
}