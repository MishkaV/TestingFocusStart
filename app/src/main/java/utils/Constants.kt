package utils

class Constants {
    companion object {
        const val BASE_URL = "https://www.cbr-xml-daily.ru"
    }
}

sealed class Screens(val route : String) {
    object CurrencyList: Screens("currencyList")
    object CurrencyConverter: Screens("currencyConverter")
}