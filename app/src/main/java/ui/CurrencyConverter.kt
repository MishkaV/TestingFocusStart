package ui

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.focusstart.R
import com.example.focusstart.ui.theme.FocusStartTheme
import com.example.focusstart.ui.theme.Typography


@Composable
fun CurrencyConverter(charCode: String, name : String, value: Float) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.currency_convert),
            fontSize = 30.sp,
            modifier = Modifier.padding(start = 14.dp, top = 20.dp)
        )

        Card(
            shape = RoundedCornerShape(10.dp),
            elevation = 20.dp,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                    var textState by rememberSaveable { mutableStateOf("")}

                Card(
                    shape = RoundedCornerShape(10.dp),
                    elevation = 20.dp,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    border = BorderStroke(1.dp, Color.Black)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(charCode, style = Typography.body2, fontSize = 20.sp)
                        var foreign_value = stringResource(R.string.zero)
                        if (textState.length > 0 && textState.toDoubleOrNull() != null)
                            foreign_value = String.format("%.4f",textState.toDouble() * value)
                        Text(foreign_value, fontSize = 30.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(name, fontSize = 20.sp)
                    }
                }

                Card(
                    shape = RoundedCornerShape(10.dp),
                    elevation = 20.dp,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    border = BorderStroke(1.dp, Color.Black)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 6.dp)
                        ) {
                            Text(stringResource(R.string.russian_ruble))
                            Text(stringResource(R.string.rub), style = Typography.body2)
                        }
                        OutlinedTextField(
                            value = textState,
                            onValueChange = { textState = it },
                            modifier = Modifier.fillMaxWidth()
                        )

                    }
                }
            }
        }
    }
}
