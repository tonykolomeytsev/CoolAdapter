package kekmech.ru.cooladapter.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KProperty

/**
 * Created by Kolomeytsev Anton
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseViewHolder : RecyclerView.ViewHolder {

    constructor(itemView: View) : super(itemView) {
        this.onCreateView(itemView)
    }

    abstract fun onCreateView(view: View)

    fun<D: View> bind(id: Int): ViewDelegate<D> {
        return ViewDelegate(id)
    }

    inner class ViewDelegate<V:View>(val id: Int) {
        var view: V? = null

        operator fun getValue(thisRef: BaseViewHolder, property: KProperty<*>): V {
            if (view == null) view = itemView.findViewById(id) as V
            return view!!
        }

        operator fun setValue(thisRef: BaseViewHolder, property: KProperty<*>, value: View) {
            view = value as V
        }
    }

}