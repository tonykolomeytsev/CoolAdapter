package kekmech.ru.cooladapter.adapter

import kekmech.ru.cooladapter.items.EventItem
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class BindItem(val bindedItemKClass: KClass<*>)