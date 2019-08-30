package kekmech.ru.cooladapter.presenter

import kekmech.ru.cooladapter.App
import kekmech.ru.cooladapter.adapter.BaseAdapter
import kekmech.ru.cooladapter.adapter.BaseClickableItem
import kekmech.ru.cooladapter.adapter.BaseItem
import kekmech.ru.cooladapter.dto.Event
import kekmech.ru.cooladapter.dto.Move
import kekmech.ru.cooladapter.dto.Notice
import kekmech.ru.cooladapter.model.ListModel
import kekmech.ru.cooladapter.view.ListFragmentView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListPresenter : BasePresenter<ListFragmentView, ListModel>() {
    override val model by lazy { ListModel() }
    val adapter = BaseAdapter.Builder()
        .registerViewTypeFactory(Event::class)
        .registerViewTypeFactory(Move::class)
        .registerViewTypeFactory(Notice::class)
        .build()

    fun onCreate(view: ListFragmentView) {
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) { model.randomSolyanka.map { adapter.generateItem(it) } }
                .forEach {
                    adapter.baseItems.add(it)
                    if (it is BaseClickableItem) it.clickListener = this@ListPresenter::onItemSelect
                }
            adapter.notifyDataSetChanged()
        }
    }

    fun onResume(view: ListFragmentView) {
        this.view = view
        view.updateAdapter(adapter)
    }

    fun onPause() {
        this.view = null
    }

    fun onItemSelect(baseItem: BaseItem<*>) {
        App.instance
            .presenter<MainPresenter>()
            .onItemSelect(baseItem)
    }

}