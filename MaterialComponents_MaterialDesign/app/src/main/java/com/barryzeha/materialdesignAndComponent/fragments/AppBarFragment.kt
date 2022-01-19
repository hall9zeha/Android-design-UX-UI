package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentAppBarBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AppBarFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind:FragmentAppBarBinding

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
        bind= FragmentAppBarBinding.inflate(inflater, container, false)
        var transaction=fragmentManager?.beginTransaction()
        bind.btnTopBar.setOnClickListener {
            var topBarFragment=AppBarTopFragment()
            topBarFragment.show(transaction!!,AppBarTopFragment.TAG)
        }
        bind.btnBottomBar.setOnClickListener {
            var bottomBarFragment=AppBarBottomFragment()
            bottomBarFragment.show(transaction!!,AppBarBottomFragment.TAG)
        }
        return bind.root
    }

    companion object {

        private lateinit var component: Component
        @JvmStatic
        final val TAG = "AppBar"

        fun getInstance(): Component {
            component =  Component()
            component.name= TAG
            component.photoRes= R.drawable.img_appbar
            component.type= Constants.STATIC
            return component
        }
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AppBarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}