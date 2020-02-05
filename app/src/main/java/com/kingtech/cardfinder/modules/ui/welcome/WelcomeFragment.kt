package com.kingtech.cardfinder.modules.ui.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kingtech.cardfinder.R
import com.kingtech.cardfinder.databinding.FragmentWelcomeBinding

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewBinding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater,
            R.layout.fragment_welcome, container, false
        )

        viewBinding.btnScanCard.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment_to_cardScannerFragment)
        }

        viewBinding.enterCardDetails.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment_to_cardInputFragment)
        }

        return viewBinding.root
    }
}
