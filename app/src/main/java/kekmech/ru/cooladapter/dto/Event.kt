package kekmech.ru.cooladapter.dto

import kekmech.ru.cooladapter.adapter.BindItem
import kekmech.ru.cooladapter.items.EventItem
import java.util.*

@BindItem(EventItem::class)
class Event (
    var startTime: Date? = null,
    var endTime: Date? = null,
    var name: String? = null
)