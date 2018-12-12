package nikan.sravni.ru.repository.exchangerate

import io.reactivex.Observable
import nikan.sravni.ru.domain.exchangerate.entity.Rate
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class RateRepoTest{
    @Test
fun `repo get data check`(){
        val rateClientMock = mock(IRateClient::class.java)
        val rateList = listOf(Rate("12", "RUB", 4f))
        `when`(rateClientMock.rateList).thenReturn(Observable.just(
            rateList
        ))

        val rateRepo = RateRepo(rateClientMock)

        rateRepo.rateList.test()
            .assertNoErrors()
            .assertValue(rateList)

    }
}