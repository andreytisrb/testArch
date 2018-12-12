package nikan.sravni.ru.repository.exchangerate

import io.reactivex.Observable
import nikan.sravni.ru.domain.exchangerate.entity.Rate
import nikan.sravni.ru.domain.exchangerate.repo.IRateRepo

class RateRepo(private val rateClient: IRateClient): IRateRepo {
    override val rateList: Observable<List<Rate>>
        get() = rateClient.rateList
}