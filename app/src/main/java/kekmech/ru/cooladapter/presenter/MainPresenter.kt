package kekmech.ru.cooladapter.presenter

import kekmech.ru.cooladapter.adapter.BaseItem
import kekmech.ru.cooladapter.items.EventItem
import kekmech.ru.cooladapter.items.MoveItem
import kekmech.ru.cooladapter.items.NoticeItem
import kekmech.ru.cooladapter.view.MainActivityView
import kekmech.ru.cooladapter.model.MainModel
import kekmech.ru.cooladapter.view.ListFragment
import kekmech.ru.cooladapter.view.details.EventFragment
import kekmech.ru.cooladapter.view.details.MoveFragment
import kekmech.ru.cooladapter.view.details.NoticeFragment

class MainPresenter : BasePresenter<MainActivityView, MainModel>(){
    override val model by lazy { MainModel() }

    fun onCreate(view: MainActivityView) {
        if (view.currentFragment == null)
            view.replaceFragment(ListFragment())
    }

    fun onResume(view: MainActivityView) {
        this.view = view
    }

    fun onPause() {
        this.view = null
    }

    fun onItemSelect(baseItem: BaseItem<*>) {
        when (baseItem) {
            is MoveItem -> view?.pushFragment(MoveFragment(baseItem))
            is NoticeItem -> view?.pushFragment(NoticeFragment(baseItem))
            is EventItem -> view?.pushFragment(EventFragment(baseItem))
        }
    }

    fun onBackPressed() {
        view?.popBackFragment()
    }

}