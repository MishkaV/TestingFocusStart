package api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import utils.Constants.Companion.BASE_URL

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api by lazy {
        retrofit.create(DailyApi::class.java)
    }
}