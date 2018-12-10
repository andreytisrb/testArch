package nikan.sravni.ru.domain.exchangerate.repo

import io.reactivex.Observable
import nikan.sravni.ru.domain.exchangerate.entity.Rate

interface IRateRepo {
    val rateList: Observable<List<Rate>>
}