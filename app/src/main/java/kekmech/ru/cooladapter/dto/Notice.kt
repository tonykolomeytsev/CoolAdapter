package kekmech.ru.cooladapter.dto

import kekmech.ru.cooladapter.adapter.BindItem
import kekmech.ru.cooladapter.items.NoticeItem
import java.util.*

@BindItem(NoticeItem::class)
data class Notice(
    val flightDate: Date? = null,
    val gate: String? = null
)