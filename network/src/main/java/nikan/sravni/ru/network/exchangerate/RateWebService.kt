package nikan.sravni.ru.network.exchangerate

import io.reactivex.Observable
import retrofit2.http.GET


interface IRateWebService {
    @GET()
    fun getRates(): Observable<RateWebClass>
}


