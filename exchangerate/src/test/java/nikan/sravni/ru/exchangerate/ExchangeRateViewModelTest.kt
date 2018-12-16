package nikan.sravni.ru.exchangerate


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import io.reactivex.Observable
import nikan.sravni.ru.domain.exchangerate.IRateInteractor
import nikan.sravni.ru.domain.exchangerate.entity.Rate
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

        viewModel.excangeRates.test().assertNoValue()

        viewModel.init(interactor)

        viewModel.excangeRates.test().assertValue(listOfRates.map { ExcangeRatesForView(it.code, it.name, it.curRate) })


    }

}