package kekmech.ru.cooladapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kekmech.ru.cooladapter.App
import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainActivityView {

    override val currentFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.instance
            .presenter<MainPresenter>()
            .onCreate(this)
    }

    override fun onResume() {
        super.onResume()
        App.instance
            .presenter<MainPresenter>()
            .onResume(this)
    }

    override fun onPause() {
        super.onPause()
        App.instance
            .presenter<MainPresenter>()
            .onPause()
    }

    override fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()

    }

    override fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, fragment)
            .addToBackStack(fragment.javaClass.simpleName)
            .commit()
    }

    override fun popBackFragment() {
        onBackPressed()
    }
}
