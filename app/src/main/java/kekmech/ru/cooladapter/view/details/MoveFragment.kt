package kekmech.ru.cooladapter.view.details


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kekmech.ru.cooladapter.R
import kekmech.ru.cooladapter.items.MoveItem
import kotlinx.android.synthetic.main.fragment_move.*
import java.text.SimpleDateFormat

/**
 * A simple [Fragment] subclass.
 */
class MoveFragment(private val baseItem: MoveItem) : DetailsFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_move, container, false)
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun onResume() {
        super.onResume()
        textViewFrom.text = baseItem.move.fromPlace
        textViewTo.text = baseItem.move.toPlace
        textViewTimeInterval.text = SimpleDateFormat("hh:mm").format(baseItem.move.estimateTime!!.first) +
                " - " + SimpleDateFormat("hh:mm").format(baseItem.move.estimateTime!!.second)
    }


}
