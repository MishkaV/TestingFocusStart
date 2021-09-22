package viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import repositories.DailyRepository

class MajorViewModulFactory(
    private val repository: DailyRepository
    ) :  ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MajorViewModel(repository) as T
    }
}