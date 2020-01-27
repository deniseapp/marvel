package marvelapp.com.marvelapp.data

import io.reactivex.Observable
import marvelapp.com.marvelapp.model.Characters
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("v1/public/characters")
    fun getCharacters(
            @Query("ts") ts: Long,
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String,
            @Query("offset") offset: Int?,
            @Query("limit") limit: Int?
    ): Observable<Characters>
}