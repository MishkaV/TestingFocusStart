package api

import model.DailyData
import retrofit2.Response
import retrofit2.http.GET

interface DailyApi {
    @GET("daily_json.js")
    suspend fun getDailyData() : Response<DailyData>
}