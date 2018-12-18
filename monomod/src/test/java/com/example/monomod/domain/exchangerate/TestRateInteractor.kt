package com.example.monomod.domain.exchangerate

import com.example.monomod.domain.exchangerate.entity.Rate
import io.reactivex.Observable
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class RateInteractorTest{

    @Test
    fun `GetRate success`(){
        val mockedRepo : IRateRepo = mock(IRateRepo::class.java)
        val rate = Rate("01", "Rub", 1.4f)
        `when`(mockedRepo.rateList).thenReturn(
            Observable
            .just<List<Rate>>(
                listOf<Rate>(rate)
            )
        )
        val testedInteractor = RateInteractor(mockedRepo)
        val testObserver = testedInteractor.rateList.test()


        testObserver
            .assertNoErrors()
            .assertValue{
                it.size == 1 &&
                        it[0] == rate
            }
    }

    @Test
    fun `getRate error`(){
        val mockedRepo :IRateRepo = mock(IRateRepo::class.java)
        val testedInteractor = RateInteractor(mockedRepo)
        val throwable = Throwable("test")
        `when`(mockedRepo.rateList).thenReturn(Observable.error(throwable))

        val testObserver = testedInteractor.rateList.test()
        testObserver.assertError(throwable)
    }
}