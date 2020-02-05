package com.kingtech.cardfinder.modules.ui.display_card


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kingtech.cardfinder.R
import com.kingtech.cardfinder.data.entities.CardResult
import com.kingtech.cardfinder.data.entities.Result
import com.kingtech.cardfinder.databinding.FragmentCardDisplayBinding
import com.kingtech.cardfinder.utils.Constant

/**
 * A simple [Fragment] subclass.
 */
class CardDisplayFragment : Fragment() {

    companion object {
        const val TAG = "CardDisplayFragment"
    }

    private lateinit var viewBinding: FragmentCardDisplayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_card_display, container, false)
        val bundle = this.arguments
        bundle?.let {
            val cardResult = it.getSerializable(Constant.CARD_RESULT)
            if (cardResult != null) {
                val cardResultData = cardResult as CardResult
                Log.i(TAG, "CardDisPlayFragment is ${cardResultData.result}")
                setUpAdapter(cardResultData.result)
            }
        }

        return viewBinding.root
    }

    private fun setUpAdapter(result: List<Result>) {
        Log.i(TAG, "I was called to init RecyclerView")
        if (result.isNotEmpty()) {
            val adapter = CardRecyclerAdapter()
            adapter.submitList(result)
            viewBinding.cardRecyclerView.adapter = adapter
            viewBinding.cardRecyclerView.setHasFixedSize(true)
            viewBinding.CardDetailsTextView.visibility = View.GONE
            viewBinding.cardRecyclerView.visibility = View.VISIBLE
        } else {
            viewBinding.cardRecyclerView.visibility = View.GONE
            viewBinding.CardDetailsTextView.visibility = View.VISIBLE
        }
    }
}
