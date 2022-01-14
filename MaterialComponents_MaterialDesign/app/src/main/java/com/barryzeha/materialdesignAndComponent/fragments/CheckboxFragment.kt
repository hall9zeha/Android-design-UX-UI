package com.barryzeha.materialdesignAndComponent.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.barryzeha.materialdesignAndComponent.R
import com.barryzeha.materialdesignAndComponent.databinding.FragmentCheckboxBinding
import com.barryzeha.materialdesignAndComponent.utils.Component
import com.barryzeha.materialdesignAndComponent.utils.Constants


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CheckboxFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bind:FragmentCheckboxBinding

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
        bind= FragmentCheckboxBinding.inflate(inflater, container, false)
        bind.chkEnable.setOnClickListener {
        var status = if(bind.chkEnable.isChecked)   "habilitado" else "desabilitado"
        Toast.makeText(activity, status, Toast.LENGTH_SHORT).show()
        }
        return bind.root
    }

    companion object {

        private lateinit var component: Component
        @JvmStatic
        final val TAG = "Checkbox"

        fun getInstance(): Component {
            component =  Component()
            component.name= TAG
            component.photoRes= R.drawable.img_checkboxes
            component.type= Constants.SCROLL
            return component
        }
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckboxFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}