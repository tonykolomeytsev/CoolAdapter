package kekmech.ru.cooladapter.items

import android.view.View
import android.widget.TextView
import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.adapter.BaseClickableItem
import kekmech.ru.cooladapter.adapter.BaseFactory
import kekmech.ru.cooladapter.adapter.BaseItem
import kekmech.ru.cooladapter.adapter.BaseViewHolder
import kekmech.ru.cooladapter.dto.Move
import java.text.SimpleDateFormat

class MoveItem(private val move: Move) : BaseClickableItem<MoveItem.ViewHolder>() {

    override fun updateViewHolder(viewHolder: MoveItem.ViewHolder) {
        viewHolder.title.text = "from " + move.fromPlace + " to " + move.toPlace
        viewHolder.startTime.text = SimpleDateFormat("hh:mm").format(move.estimateTime!!.first)
        viewHolder.endTime.text = SimpleDateFormat("hh:mm").format(move.estimateTime!!.second)
    }

    class ViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val title by bind<TextView>(R.id.textViewTimeOverlay)
        val startTime by bind<TextView>(R.id.textViewCoupleTimeStart)
        val endTime by bind<TextView>(R.id.textViewCoupleTimeEnd)
        override fun onCreateView(view: View) = Unit
    }

    override fun approveFactory(factory: BaseFactory) = factory is Factory

    class Factory : BaseFactory(R.layout.item_couple_full_layout) {
        override fun instance(view: View): BaseViewHolder = ViewHolder(view)
    }
}