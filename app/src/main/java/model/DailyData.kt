package model

import com.google.gson.annotations.SerializedName

data class DailyData (
    @SerializedName("Date")
    var date : String,
    @SerializedName("PreviousDate")
    var previousDate : String,
    @SerializedName("PreviousURL")
    var previousURL : String,
    @SerializedName( "Timestamp")
    var timestamp : String,
    @SerializedName( "Valute")
    var valute : HashMap<String, Valute>
)

data class Valute(
    @SerializedName("ID")
    var id: String,
    @SerializedName("NumCode")
    var numCode: String,
    @SerializedName("CharCode")
    var charCode: String,
    @SerializedName("Nominal")
    var nominal: Int,
    @SerializedName("Name")
    var name: String,
    @SerializedName("Value")
    var value: Double,
    @SerializedName("Previous")
    var previous: Double
)