package kekmech.ru.cooladapter.view

import androidx.fragment.app.Fragment

interface MainActivityView {
    val currentFragment: Fragment?

    fun replaceFragment(fragment: Fragment)

    fun pushFragment(fragment: Fragment)

    fun popBackFragment()
}