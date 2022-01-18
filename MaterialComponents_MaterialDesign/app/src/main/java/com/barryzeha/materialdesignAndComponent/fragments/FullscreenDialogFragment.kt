package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentFullscreenDialogBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FullscreenDialogFragment : DialogFragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind:FragmentFullscreenDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.myDialogStyle)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind= FragmentFullscreenDialogBinding.inflate(inflater, container, false)
        bind.toolbar.setNavigationIcon(R.drawable.ic_close)
        bind.toolbar.setNavigationOnClickListener { dismiss() }
        bind.toolbar.setTitle(R.string.dialog_full_screen)
        return bind.root
    }

    companion object {
       @JvmStatic
        val TAG="FullScreenDialogFragment"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FullscreenDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}