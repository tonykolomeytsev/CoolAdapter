package kekmech.ru.cooladapter

import android.app.Application

class App : Application() {

    val presenters = mutableMapOf<Class<*>, Any>()

    override fun onCreate() {
        super.onCreate()
        hiddenInstance = this
    }

    /**
     * Так вот зачем нужен reified (шутка)
     */
    inline fun <reified T: Any> presenter(): T {
        //lazy init
        if (!presenters.containsKey(T::class.java)) {
            presenters[T::class.java] = T::class.java.newInstance()
        }
        return presenters[T::class.java] as T
    }

    companion object {
        private lateinit var hiddenInstance: App
        val instance: App get() = hiddenInstance
    }
}