package api

import model.DailyData
import retrofit2.Response
import retrofit2.http.GET

interface TestApi {
    @GET("daily_json.js")
    suspend fun getData() : Response<DailyData>

}