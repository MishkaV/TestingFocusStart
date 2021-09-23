package repositories

import api.RetrofitInstance
import model.DailyData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

class DailyRepository {
    suspend fun getDailyData() : Response<DailyData> = RetrofitInstance.api.getDailyData()
}