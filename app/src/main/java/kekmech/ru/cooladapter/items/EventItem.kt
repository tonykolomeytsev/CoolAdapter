package kekmech.ru.cooladapter.items

import android.view.View
import android.widget.TextView
import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.adapter.BaseClickableItem
import kekmech.ru.cooladapter.adapter.BaseFactory
import kekmech.ru.cooladapter.adapter.BaseItem
import kekmech.ru.cooladapter.adapter.BaseViewHolder
import kekmech.ru.cooladapter.dto.Event
import java.text.SimpleDateFormat

class EventItem(private val event: Event) : BaseClickableItem<EventItem.ViewHolder>() {

    override fun updateViewHolder(viewHolder: ViewHolder) {
        viewHolder.title.text = event.name
        viewHolder.startTime.text = SimpleDateFormat("hh:mm").format(event.startTime)
        viewHolder.endTime.text = SimpleDateFormat("hh:mm").format(event.endTime)
    }

    class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val title by bind<TextView>(R.id.textViewCoupleName)
        val startTime by bind<TextView>(R.id.textViewCoupleTimeStart)
        val endTime by bind<TextView>(R.id.textViewCoupleTimeEnd)
        override fun onCreateView(view: View) = Unit
    }

    override fun approveFactory(factory: BaseFactory) = factory is Factory

    class Factory : BaseFactory(R.layout.item_couple_min_layout) {
        override fun instance(view: View): BaseViewHolder = ViewHolder(view)
    }
}