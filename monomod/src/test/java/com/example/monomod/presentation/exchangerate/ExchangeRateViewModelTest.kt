package com.example.monomod.presentation.exchangerate


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.monomod.domain.exchangerate.IRateInteractor
import com.example.monomod.domain.exchangerate.entity.Rate
import com.jraska.livedata.test
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ExchangeRateViewModelTest {

    private lateinit var viewModel: IExchangeRateViewModel
    private lateinit var interactor: IRateInteractor

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    @Before
    fun init(){
        viewModel = ExchangeRateViewModel()
        interactor = mock(IRateInteractor::class.java)
    }

    @Test
    fun `viewModel inition test`(){

        val listOfRates = listOf(Rate("1", "Ru", 1.2f))
        `when`(interactor.rateList).thenReturn(
            Observable.just(listOfRates)
        )

        viewModel.rate.test().assertNoValue()

        viewModel.init(interactor)

        viewModel.rate.test().assertValue(listOfRates.map { RateForView(it.code, it.name, it.curRate) })

    }

    @Test
    fun `refresh test`(){
        `viewModel inition test`()
        val listOfRates = listOf(Rate("1", "En", 1.3f))
        `when`(interactor.rateList).thenReturn(
            Observable.just(listOfRates)
        )
        viewModel.refresh()
        viewModel.rate.test().assertValue(listOfRates.map { RateForView(it.code, it.name, it.curRate) })

    }

}