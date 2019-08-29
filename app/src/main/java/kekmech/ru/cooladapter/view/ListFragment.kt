package kekmech.ru.cooladapter.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kekmech.ru.cooladapter.App
import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.presenter.ListPresenter

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment(), ListFragmentView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        App.instance.presenter<ListPresenter>()
            .
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


}
