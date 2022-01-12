package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentButtonBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var bind:FragmentButtonBinding ;
/**
 * A simple [Fragment] subclass.
 * Use the [ButtonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ButtonFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



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
        bind= FragmentButtonBinding.inflate(inflater)
        bind.btnEnable.setOnClickListener { Toast.makeText(activity, "Enable", Toast.LENGTH_SHORT).show() }
        return bind.root
    }

    companion object {
        private lateinit var component:Component
        @JvmStatic
        final val TAG = "Button"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ButtonFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ButtonFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
        fun getInstance():Component{
            component=  Component()
            component.name=TAG
            component.photoRes= R.drawable.img_button
            component.type=Constants.SCROLL
            return component
        }
    }


}