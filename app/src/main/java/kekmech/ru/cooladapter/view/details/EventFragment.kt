package kekmech.ru.cooladapter.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.items.EventItem
import kotlinx.android.synthetic.main.fragment_event.*
import java.text.SimpleDateFormat


class EventFragment(private val baseItem: EventItem) : DetailsFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onResume() {
        super.onResume()
        textViewName.text = baseItem.event.name
        textViewStartTime.text = SimpleDateFormat("hh:mm").format(baseItem.event.startTime)
        textViewEndTime.text = SimpleDateFormat("hh:mm").format(baseItem.event.endTime)
    }
}
