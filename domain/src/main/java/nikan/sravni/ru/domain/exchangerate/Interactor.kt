package nikan.sravni.ru.domain.exchangerate

import io.reactivex.Observable
import nikan.sravni.ru.domain.exchangerate.entity.Rate
import nikan.sravni.ru.domain.exchangerate.repo.IRateRepo

interface IRateInteractor{
    val rateList: Observable<List<Rate>>
}


class RateInteractor (val rateRepo:IRateRepo): IRateInteractor{
    override val rateList: Observable<List<Rate>>
        get() = rateRepo.rateList

}