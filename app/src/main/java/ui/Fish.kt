package ui

import model.ValuteInfo

object Fish {
    var valueInfo = ValuteInfo(
        id = "R01010",
        numCode = "036",
        charCode = "AUD",
        nominal = 1,
        name = "Австралийский доллар",
        value = 52.7801,
        previous = 53.2432
    )


    var valueList = hashMapOf<String, ValuteInfo>(
        "LOL" to valueInfo,
        "KEK" to valueInfo,
        "ASD" to valueInfo,
        "ZCX" to valueInfo,
        "KLJ" to valueInfo,
        "OIU" to valueInfo,
        "OAS" to valueInfo,
        "BNN" to valueInfo,
        "WQQ" to valueInfo
    )
}