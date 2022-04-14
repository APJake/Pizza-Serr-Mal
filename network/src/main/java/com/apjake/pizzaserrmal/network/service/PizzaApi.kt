import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface PizzaApi {
    @GET("pizzas")
    fun getAllPizza(): Observable<PizzaResponse>
}