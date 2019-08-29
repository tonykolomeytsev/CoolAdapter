package kekmech.ru.cooladapter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kekmech.ru.cooladapter.App
import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainActivityView {

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pushFragment(fragment: Fragment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun popBackFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
