package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentNavigationDrawerBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NavigationDrawerFragment : Fragment(), View.OnClickListener {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind:FragmentNavigationDrawerBinding

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
       bind= FragmentNavigationDrawerBinding.inflate(inflater, container, false)
        bind.btnBottomDrawer.setOnClickListener(this)
        bind.btnModalDrawer.setOnClickListener(this)
        return bind.root
    }

    companion object {
        private lateinit var component: Component
        @JvmStatic
        final val TAG = "NavigationDrawer"

        fun getInstance(): Component {
            component =  Component()
            component.name= TAG
            component.photoRes= R.drawable.img_navigation_drawer
            component.type= Constants.STATIC
            return component
        }
      @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NavigationDrawerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(view: View?) {
        var transaction=parentFragmentManager.beginTransaction();
        when(view?.id){
            R.id.btnModalDrawer->{
                var modalDrawer=ModalNavigationDrawerFragment()
                modalDrawer.show(transaction,ModalNavigationDrawerFragment.TAG)
            }
            R.id.btnBottomDrawer->{
                var bottomDrawer=BottomNavigationDrawerFragment()
                bottomDrawer.show(transaction, BottomNavigationDrawerFragment.TAG)
            }
        }
    }
}