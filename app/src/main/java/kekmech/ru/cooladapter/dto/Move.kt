package kekmech.ru.cooladapter.dto

import kekmech.ru.cooladapter.adapter.BindItem
import kekmech.ru.cooladapter.items.MoveItem
import java.util.*

typealias TimeInterval = Pair<Date, Date>

@BindItem(MoveItem::class)
class Move(
    var fromPlace: String? = null,
    var toPlace: String? = null,
    var estimateTime: TimeInterval? = null
)