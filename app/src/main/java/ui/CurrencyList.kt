package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.focusstart.R
import com.example.focusstart.ui.theme.Green
import com.example.focusstart.ui.theme.Red
import com.example.focusstart.ui.theme.Typography
import model.ValuteInfo
import utils.Screens


@Composable
fun CurrencyList(currencyList: HashMap<String, ValuteInfo>, navController: NavHostController) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            text = stringResource(R.string.currency_head),
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
            LazyColumn {
                currencyList.values.forEach { item ->
                    item {
                        CurrencyCard(item, navController)
                    }
                }
            }
        }
    }
}

@Composable
fun CurrencyCard(currency: ValuteInfo, navController: NavHostController) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 20.dp,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Screens.CurrencyConverter.route
                        + "/${currency.charCode}"
                        + "/${currency.name}"
                        + "/${currency.value / currency.nominal}")
            }
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ){
            Column(modifier = Modifier.weight(2f)) {
                Text(text = currency.charCode, style = Typography.body2)
                Text(text = currency.name, maxLines = 3, overflow = TextOverflow.Ellipsis)
            }

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.End
            ){
                Text(text = String.format("%.4f", currency.value / currency.nominal) + " ₽")
                val delta = currency.value - currency.previous
                var color = Green
                if (delta < 0)
                    color = Red
                Text(
                    text = String.format("%.4f", delta / currency.nominal),
                    color = color
                )
            }
        }

    }
}