package kekmech.ru.cooladapter

import java.util.*
import kotlin.random.Random

fun randomDate() = Date(Random.nextLong(0, Long.MAX_VALUE))

fun randomGate() = Random.nextInt(0, 15).toString()

fun randomPlace() = places.random()

fun randomEvent() = (events.random() + " in " + places.random())

private val places = listOf("Moscow", "New-York", "Washington", "Kaliningrad", "Ryazan", "Alushta", "Warsaw", "Paris",
    "Munich", "Berlin", "Gdansk", "Gibraltar", "Minsk")

private val events = listOf("Meetup", "Hackaton", "GDG")

