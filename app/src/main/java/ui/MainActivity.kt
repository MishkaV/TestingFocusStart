package ui

import android.content.res.Configuration
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.R
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.focusstart.ui.theme.FocusStartTheme
import com.example.focusstart.ui.theme.Green
import com.example.focusstart.ui.theme.Red
import com.example.focusstart.ui.theme.Typography
import model.ValuteInfo
import repositories.DailyRepository
import utils.Constants
import viewModel.MajorViewModel
import viewModel.MajorViewModulFactory
import java.util.*
import kotlin.collections.HashMap

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MajorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = DailyRepository()
        val viewModulFactory = MajorViewModulFactory(repository)
        viewModel = ViewModelProvider(this, viewModulFactory).get(MajorViewModel::class.java)
        viewModel.getDailyData()
        viewModel.rootResponse.observe(this, Observer { response ->
            if (response.isSuccessful){
                setContent {
                    FocusStartTheme {
                        Surface(color = MaterialTheme.colors.background) {
                            response.body()?.let { Navigation(it) }
                        }
                    }
                }
            }
        })

    }
}


@Preview(showBackground = true)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() {
    FocusStartTheme {
        CurrencyConverter("AUD", "Австралийский доллар", 52.7801F)
    }
}