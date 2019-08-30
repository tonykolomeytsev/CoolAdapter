package kekmech.ru.cooladapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kekmech.ru.cooladapter.dto.Itemable
import java.lang.IllegalStateException
import java.util.*
import kotlin.reflect.KClass

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

    /**
     * Генерирует ViewHolder для data классов из которых генерируется список
     */
    fun generateItem(item: Any): BaseItem<*> {
        val cls = item::class.java
        val annotationBind = cls.getAnnotation(BindItem::class.java)
        if (annotationBind != null) {
            val constructor = annotationBind.bindedItemKClass.java.constructors.first()
            return constructor.newInstance(item) as BaseItem<*>
        } else {
            throw IllegalStateException("Class ${cls::class.java.simpleName} is not annotated with @BindItem")
        }
    }

    class Builder {
        private val adapter = BaseAdapter()

        fun registerViewTypeFactory(factory: BaseFactory): Builder {
            adapter.viewFactories += adapter.viewFactories.size to factory
            return this
        }

        fun registerViewTypeFactory(kClass: KClass<*>): Builder {
            val annotationBind = kClass.java.getAnnotation(BindItem::class.java)
            if (annotationBind != null) {
                val fullName = annotationBind.bindedItemKClass.java.name
                val innerClass = Class.forName("$fullName\$Factory")
                registerViewTypeFactory(innerClass.newInstance() as BaseFactory)
            } else {
                throw IllegalStateException("Class ${kClass.java.simpleName} is not annotated with @BindItem")
            }
            return this
        }

        fun build() : BaseAdapter {

            return adapter
        }
    }

}