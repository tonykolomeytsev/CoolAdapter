package kekmech.ru.cooladapter.model

import kekmech.ru.cooladapter.*
import kekmech.ru.cooladapter.dto.Event
import kekmech.ru.cooladapter.dto.Move
import kekmech.ru.cooladapter.dto.Notice
import kotlin.random.Random

class ListModel {

    fun getRandomNotices() = Array<Any>(10) { Notice(randomDate(), randomGate()) }

    fun getRandomMoves() = Array<Any>(10) { Move(randomPlace(), randomPlace(), Pair(randomDate(), randomDate())) }

    fun getRandomEvents() = Array<Any>(10) { Event(randomDate(), randomDate(), randomEvent()) }

    val randomSolyanka: List<Any>
        get() {
            val result = getRandomEvents().toMutableList()
            result.addAll(getRandomMoves())
            result.addAll(getRandomNotices())
            return result.shuffled()
        }
}