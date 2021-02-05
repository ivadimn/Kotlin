package retrofit.json

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val key = "dict.1.1.20170402T202525Z.1ed8dd7c23205718.efda3a2c4bdf834b16909622280b20b0d60840a1"

//https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=&lang=en-ru&text=time

val retrofit = Retrofit.Builder()
    .baseUrl("https://dictionary.yandex.net")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val translateService = retrofit.create(TranslateService::class.java)

fun main() {
    val response = translateService.lookup(
        key, "en-ru", "fighter jet").execute()

    if (response.isSuccessful) {
        val result = response.body()
        println(
            result?.def?.get(0)?.tr?.get(0)?.text
        )
    }
}