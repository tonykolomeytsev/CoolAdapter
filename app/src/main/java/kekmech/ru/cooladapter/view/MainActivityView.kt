package kekmech.ru.cooladapter.view

import androidx.fragment.app.Fragment

interface MainActivityView {
    fun replaceFragment(fragment: Fragment)

    fun pushFragment(fragment: Fragment)

    fun popBackFragment()
}