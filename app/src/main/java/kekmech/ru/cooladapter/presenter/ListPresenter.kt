package kekmech.ru.cooladapter.presenter

import kekmech.ru.cooladapter.model.ListModel
import kekmech.ru.cooladapter.view.ListFragmentView

class ListPresenter : BasePresenter<ListFragmentView, ListModel>() {
    override val model by lazy { ListModel() }

    fun onCreate(view: ListFragmentView) {
        model
    }

    fun onResume(view: ListFragmentView) {
        this.view = view
    }

    fun onPause() {
        this.view = null
    }

}