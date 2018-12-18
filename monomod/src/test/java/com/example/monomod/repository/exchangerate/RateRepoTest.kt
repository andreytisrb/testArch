package com.example.monomod.repository.exchangerate

import com.example.monomod.domain.exchangerate.entity.Rate
import io.reactivex.Observable
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