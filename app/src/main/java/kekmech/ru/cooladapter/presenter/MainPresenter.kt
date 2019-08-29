package kekmech.ru.cooladapter.presenter

import kekmech.ru.cooladapter.view.MainActivityView
import kekmech.ru.cooladapter.model.MainModel

class MainPresenter : BasePresenter<MainActivityView, MainModel>(){
    override val model by lazy { MainModel() }

    fun onCreate(view: MainActivityView) {
        model
    }

    fun onResume(view: MainActivityView) {
        this.view = view
    }

    fun onPause() {
        this.view = null
    }

}