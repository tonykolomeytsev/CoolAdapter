package kekmech.ru.cooladapter.view.details


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.items.NoticeItem
import kotlinx.android.synthetic.main.fragment_notice.*
import java.text.SimpleDateFormat

/**
 * A simple [Fragment] subclass.
 */
class NoticeFragment(private val baseItem: NoticeItem) : DetailsFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notice, container, false)
    }

    override fun onResume() {
        super.onResume()
        textViewDate.text = SimpleDateFormat("dd MMMM").format(baseItem.notice.flightDate)
        textViewGate.text = baseItem.notice.gate
    }


}
