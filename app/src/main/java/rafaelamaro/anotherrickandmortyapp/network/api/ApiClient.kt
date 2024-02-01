package rafaelamaro.anotherrickandmortyapp.network.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import rafaelamaro.anotherrickandmortyapp.network.data.CharacterPagedResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://rickandmortyapi.com/api/"

private val moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit
    .Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface ApiService {
    @GET("character/")
    suspend fun getCharacters(@Query("page") page: Int): CharacterPagedResponse
}

object ApiClient {
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
