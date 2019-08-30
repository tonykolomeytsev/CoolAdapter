package kekmech.ru.cooladapter.view.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kekmech.ru.cooladapter.App
import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.presenter.MainPresenter
import kotlinx.android.synthetic.main.fragment_list.view.*

abstract class DetailsFragment : Fragment() {

    override fun onResume() {
        super.onResume()
        view?.findViewById<Toolbar>(R.id.toolbar)
            ?.setNavigationOnClickListener {
                it.postOnAnimation { App.instance.presenter<MainPresenter>().onBackPressed() }
            }
    }
}