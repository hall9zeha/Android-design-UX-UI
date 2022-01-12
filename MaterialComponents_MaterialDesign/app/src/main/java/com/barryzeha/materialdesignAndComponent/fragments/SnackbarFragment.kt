package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentSnackbarBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SnackbarFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind:FragmentSnackbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind= FragmentSnackbarBinding.inflate(inflater, container,false)

        Snackbar.make(bind.root, R.string.message_action_success, Snackbar.LENGTH_LONG)
            .setAction("Volver") { activity?.finish() }
            .show()
        return bind.root
    }

    companion object {
        private lateinit var component: Component
        @JvmStatic
        final val TAG = "Snackbar"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SnackbarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        fun getInstance():Component{
           component =  Component()
           component.name= TAG
           component.photoRes= R.drawable.img_singleline_action
            component.type= Constants.STATIC
            return component
        }
    }
}