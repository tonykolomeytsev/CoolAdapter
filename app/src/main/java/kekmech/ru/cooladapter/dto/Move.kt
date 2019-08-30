package kekmech.ru.cooladapter.dto

import java.util.*

typealias TimeInterval = Pair<Date, Date>

class Move {
    var fromPlace: String? = null
    var toPlace: String? = null
    var estimateTime: TimeInterval? = null
}