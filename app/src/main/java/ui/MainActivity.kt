package ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import api.DailyApi
import api.TestApi
import com.example.focusstart.ui.theme.FocusStartTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import repositories.DailyRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import utils.Constants
import viewModel.MajorViewModel
import viewModel.MajorViewModulFactory

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MajorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = DailyRepository()
        val viewModulFactory = MajorViewModulFactory(repository)
        viewModel = ViewModelProvider(this, viewModulFactory).get(MajorViewModel::class.java)
        viewModel.getDailyData()
        viewModel.rootResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.toString()?.let { Log.d("TAG", it) }
            }
        })

        setContent {
            FocusStartTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FocusStartTheme {
        Greeting("Android")
    }
}