package kekmech.ru.cooladapter.adapter

import android.util.Log
import java.util.*
import kotlin.collections.any

/**
 * Created by Kolomeytsev Anton
 */
abstract class BaseClickableItem<T : BaseViewHolder>(
    private var itemId: String
): BaseItem<T>() {

    var clickListener: (String) -> Unit = {}

    override fun updateViewHolderNative(viewHolder: BaseViewHolder) {
        super.updateViewHolderNative(viewHolder)
        Log.d("VIEW HOLDER", "update")
        viewHolder.itemView.setOnClickListener {
            view -> view.postOnAnimation { clickListener(itemId) }
        }
    }
}