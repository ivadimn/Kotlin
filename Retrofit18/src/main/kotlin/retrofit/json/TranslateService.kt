package retrofit.json

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslateService {
    @GET("/api/v1/dicservice.json/lookup")
    fun lookup(
        @Query("key")
        apiKey : String,
        @Query("lang")
        lang : String,
        @Query("text")
        text : String
    ) : Call<TranslateResult>
}