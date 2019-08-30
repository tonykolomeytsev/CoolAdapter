package kekmech.ru.cooladapter.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.items.EventItem


class EventFragment(baseItem: EventItem) : DetailsFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }
}
