package kekmech.ru.cooladapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * Created by Kolomeytsev Anton
 */
open class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    internal val viewFactories = hashMapOf<Int, BaseFactory>()
    private val viewCache = hashMapOf<Int, View>()
    val baseItems: MutableList<BaseItem<*>> = ArrayList()
    var inflater: LayoutInflater? = null

    override fun getItemViewType(position: Int): Int {
        return baseItems[position].getType(viewFactories)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        baseItems[position].updateViewHolderNative(holder)
    }

    override fun getItemCount() = baseItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if (inflater == null) inflater = LayoutInflater.from(parent.context)
        return viewFactories[viewType]!!.instanceNative(parent, inflater!!)
    }

    class Builder {
        private val adapter = BaseAdapter()

        fun registerViewTypeFactory(factory: BaseFactory): Builder {
            adapter.viewFactories += adapter.viewFactories.size to factory
            return this
        }

        fun build() : BaseAdapter {

            return adapter
        }
    }

}