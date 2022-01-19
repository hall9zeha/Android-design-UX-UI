package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentAppBarTopBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AppBarTopFragment : DialogFragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind:FragmentAppBarTopBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setStyle(STYLE_NORMAL, R.style.myDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= FragmentAppBarTopBinding.inflate(inflater, container,false)
        bind.toolbar.setNavigationOnClickListener {
            dismiss()
        }
        return bind.root
    }

    companion object {
        val TAG: String?="AppBatTopFragment"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AppBarTopFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}