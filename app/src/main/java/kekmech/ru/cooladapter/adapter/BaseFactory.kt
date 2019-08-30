package kekmech.ru.cooladapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Kolomeytsev Anton
 */
abstract class BaseFactory(val layoutId: Int) {

    fun instanceNative(parent: ViewGroup?, inflater: LayoutInflater): BaseViewHolder {
        return instance(inflater.inflate(layoutId, parent, false))
    }

    abstract fun instance(view: View): BaseViewHolder
}