package kekmech.ru.cooladapter.presenter

abstract class BasePresenter<VIEW, MODEL> {
    protected abstract val model: MODEL
    protected var view: VIEW? = null
}