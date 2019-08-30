package kekmech.ru.cooladapter.view


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kekmech.ru.cooladapter.App
import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.Resources
import kekmech.ru.cooladapter.adapter.BaseAdapter
import kekmech.ru.cooladapter.presenter.ListPresenter
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment(), ListFragmentView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        App.instance
            .presenter<ListPresenter>()
            .onCreate(this)
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        if (recyclerView.layoutManager == null)
            recyclerView.layoutManager = LinearLayoutManager(activity)
        App.instance
            .presenter<ListPresenter>()
            .onResume(this)
    }

    override fun onPause() {
        super.onPause()
        App.instance
            .presenter<ListPresenter>()
            .onPause()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        activity!!.window.statusBarColor = Resources.getColor(context, R.color.colorPrimary)
    }

    override fun updateAdapter(adapter: BaseAdapter) {
        recyclerView.adapter = adapter
    }

}
