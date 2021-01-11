import retrofit.dictionary.YandexDictionaryService
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

val key = "dict.1.1.20210111T111918Z.0f820773933ab066.46a8b39ad29bc680e3e545c9254d10a1dd8e4d2b"
//https://dictionary.yandex.net/api/v1/dicservice/lookup?key=dict.1.1.20210111T111918Z.0f820773933ab066.46a8b39ad29bc680e3e545c9254d10a1dd8e4d2b&lang=en-ru&text=time
val urlXml =
    "https://dictionary.yndex.net/api/v1/dicservice/lookup?key=&lang=en-ru&text=time"

val urlJson = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=dict.1.1.20210111T111918Z.0f820773933ab066.46a8b39ad29bc680e3e545c9254d10a1dd8e4d2b&lang=en-ru&text=time"

val retrofit : Retrofit = Retrofit.Builder()
    .baseUrl("https://dictionary.yandex.net")
    .addConverterFactory(SimpleXmlConverterFactory.create())
    .build()

val yandexDictionaryService = retrofit.create(YandexDictionaryService::class.java)

fun main() {
    val response = yandexDictionaryService.lookup(key = key,
    lang="en-ru", text="fighter jet").execute()
    if (response.isSuccessful) {
        val result = response.body()
        println(result?.defs?.get(0)?.trs?.get(0)?.text)
    }
}