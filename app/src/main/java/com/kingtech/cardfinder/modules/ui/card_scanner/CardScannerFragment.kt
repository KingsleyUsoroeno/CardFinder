package com.kingtech.cardfinder.modules.ui.card_scanner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kingtech.cardfinder.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CardScannerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardScannerFragment : Fragment() {
    //private var mRecognizerBundle: RecognizerBundle? = null
    // private var mRecognizer: BlinkIdCombinedRecognizer? = null

    companion object {
        const val MY_REQUEST_CODE = 20
        const val TAG = "CardScannerFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // create BlinkIdCombinedRecognizer
//        mRecognizer = BlinkIdCombinedRecognizer()
//        // bundle recognizers into RecognizerBundle
//        mRecognizerBundle = RecognizerBundle(mRecognizer);

        return inflater.inflate(R.layout.fragment_card_scanner, container, false)
    }


//    fun startScanning() {
//        // Settings for BlinkIdActivity
//        val settings = BlinkIdUISettings(mRecognizerBundle)
//        // tweak settings as you wish
//        // Start activity
//        ActivityRunner.startActivityForResult(this, MY_REQUEST_CODE, settings)
//    }   // Settings for BlinkIdActivity


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == MY_REQUEST_CODE && resultCode == BlinkIdActivity.RESULT_OK && data != null){
//            mRecognizerBundle?.loadFromIntent(data)
//            val result = mRecognizer!!.result
//            if (result.resultState == Recognizer.Result.State.Valid) {
//                // result is valid, you can use it however you wish
//                Log.i(TAG, "result from Scanning Card $result")
//            }
//        }
//    }

//    private fun checkDeviceCompatability(){
//        // check if BlinkID is supported on the device
//        // check if BlinkID is supported on the device
//        val status =
//            RecognizerCompatibility.getRecognizerCompatibilityStatus(this.requireContext())
//        when (status) {
//            RecognizerCompatibilityStatus.RECOGNIZER_SUPPORTED -> {
//                Toast.makeText(this.requireContext(), "BlinkID is supported!", Toast.LENGTH_LONG).show()
//            }
//            RecognizerCompatibilityStatus.NO_CAMERA -> {
//                Toast.makeText(this.requireContext(), "BlinkID is supported only via Direct API!", Toast.LENGTH_LONG)
//                    .show()
//            }
//            else -> {
//                Toast.makeText(
//                    this.requireContext(),
//                    "BlinkID is not supported! Reason: " + status.name,
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//        }
//    }
}
