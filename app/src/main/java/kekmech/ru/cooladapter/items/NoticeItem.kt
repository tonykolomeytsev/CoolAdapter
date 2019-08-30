package kekmech.ru.cooladapter.items

import android.view.View
import android.widget.TextView
import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.adapter.BaseClickableItem
import kekmech.ru.cooladapter.adapter.BaseFactory
import kekmech.ru.cooladapter.adapter.BaseItem
import kekmech.ru.cooladapter.adapter.BaseViewHolder
import kekmech.ru.cooladapter.dto.Notice
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

class NoticeItem(val notice: Notice) : BaseClickableItem<NoticeItem.ViewHolder>() {

    override fun updateViewHolder(viewHolder: ViewHolder) {
        val date = SimpleDateFormat("dd MMMM").format(notice.flightDate)
        viewHolder.title.text = "Flight on $date on Gate ${notice.gate}"
    }

    class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val title by bind<TextView>(R.id.textViewPrimary)
        override fun onCreateView(view: View) = Unit
    }

    override fun approveFactory(factory: BaseFactory) = factory is Factory

    class Factory : BaseFactory(R.layout.item_single_line_layout) {
        override fun instance(view: View): BaseViewHolder = ViewHolder(view)
    }
}