package retrofit.dictionary

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// "https://dictionary.yndex.net/api/v1/dicservice/lookup?key=dict.1.1.20210111T111918Z.0f820773933ab066.46a8b39ad29bc680e3e545c9254d10a1dd8e4d2b&lang=en-ru&text=time"

interface YandexDictionaryService {
    @GET("/api/v1/dicservice/lookup")
    fun lookup(
        @Query("key")
        key: String,
        @Query("lang")
        lang: String,
        @Query("text")
        text: String
    ) : Call<DicResult>
}