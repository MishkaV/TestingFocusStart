package viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import api.DailyApi
import kotlinx.coroutines.launch
import model.DailyData
import repositories.DailyRepository
import retrofit2.Response

class MajorViewModel (private val repository: DailyRepository) : ViewModel(){

    val rootResponse : MutableLiveData<DailyData> = MutableLiveData()

    fun getDailyData() {
        viewModelScope.launch {
            rootResponse.value  = repository.getDailyData()
        }
    }
}