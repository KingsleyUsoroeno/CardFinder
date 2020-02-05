package com.kingtech.cardfinder.modules.ui.card_input

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.kingtech.cardfinder.R
import com.kingtech.cardfinder.databinding.CardInputFragmentBinding
import com.kingtech.cardfinder.utils.Constant.CARD_RESULT

class CardInputFragment : Fragment() {

    private val cardInputViewModel: CardInputViewModel by viewModels()
    private lateinit var viewBinding: CardInputFragmentBinding

    companion object {
        fun newInstance() = CardInputFragment()
        const val TAG = "CardInputFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding =
            DataBindingUtil.inflate(inflater, R.layout.card_input_fragment, container, false)
        viewBinding.cardViewModel = cardInputViewModel
        viewBinding.lifecycleOwner = this

        val navController = NavHostFragment.findNavController(this)
        val spinnerDialog = getSpinnerDialog()

        cardInputViewModel.loadingLiveData.observe(viewLifecycleOwner, Observer { loading ->
            if (loading) {
                Log.i(TAG, "Am loading")
                spinnerDialog.show()

            } else {
                Log.i(TAG, "Ive stopped loading")
                spinnerDialog.dismiss()
            }
        })

        cardInputViewModel.errorLiveData.observe(viewLifecycleOwner, Observer { errorMsg ->
            if (spinnerDialog.isShowing) spinnerDialog.dismiss()
            Log.i(TAG, "encountered an error $errorMsg")
            Toast.makeText(
                this.requireContext(),
                "Encountered an issue $errorMsg",
                Toast.LENGTH_LONG
            ).show()
        })

        cardInputViewModel.success.observe(viewLifecycleOwner, Observer { cardDetails ->
            if (spinnerDialog.isShowing) spinnerDialog.dismiss()
            if (cardDetails == null) return@Observer

            Log.i(TAG, "Card Details is $cardDetails")
            val bundle = Bundle()
            bundle.putSerializable(CARD_RESULT, cardDetails)
            navController.navigate(R.id.action_cardInputFragment_to_cardDisplayFragment, bundle)
        })

        return viewBinding.root
    }

    private fun getSpinnerDialog(): AlertDialog {
        val dialog = AlertDialog.Builder(this.requireContext())
        val dialogView =
            LayoutInflater.from(this.requireActivity()).inflate(R.layout.loading_background, null)
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        return dialog.create()
    }
}
